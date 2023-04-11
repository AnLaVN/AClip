package Tool;
//Make by Bình An || AnLaVN || KatoVN

import java.io.IOException;
import com.AnLa.HASH.AES;
import com.AnLa.HASH.SHA256;
import DAO.UserDAO;
import Entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter({
	"/Home", "/Liked", "/Video/*", 
	"/MyAccount", "/ResetPass", "/SignOut", 
	"/AdVideos", "/AdUsers", "/AdStatistics"})
public class CookieFilter implements HTTPFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain fc) throws IOException, ServletException {
		User user = (User) req.getSession().getAttribute("user");
		String cookie = myCookie.get("userCookie");
		if(user != null) fc.doFilter(req, resp);
		else if(cookie != null) {
			String  username = cookie.substring(0, cookie.indexOf("~")),
					password = cookie.substring(cookie.indexOf("~")+1);
			username = AES.Decrypt(username, "userCookie@#$%PS21776");
			User userCookie = UserDAO.Select(username);
			if(userCookie != null && SHA256.Encrypt(userCookie.getPassword()).equals(password)) {
				myScope.Session().setAttribute("user", userCookie);
				fc.doFilter(req, resp);
			}else resp.sendRedirect("SignIn");
		}else resp.sendRedirect("SignIn");
	}

}