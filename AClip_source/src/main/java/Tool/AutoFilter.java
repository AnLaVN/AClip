package Tool;
//Make by Bình An || AnLaVN || KatoVN

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/*"})
public class AutoFilter implements HTTPFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain fc) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		RRSharer.Add(req, resp);
		fc.doFilter(req, resp);
		RRSharer.Remove();
	}

}