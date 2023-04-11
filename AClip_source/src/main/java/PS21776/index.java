package PS21776;
//Make by Bình An || AnLaVN || KatoVN

import DAO.*;
import Tool.*;
import Entity.*;
import com.AnLa.FILE.Log;
import com.AnLa.HASH.AES;
import com.AnLa.HASH.SHA256;
import com.AnLa.NET.DocNet;
import com.AnLa.NET.Email;
import com.AnLa.NET.RandomORG;
import javax.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.util.List;

@WebServlet({
	"/Home", "/Liked", "/Video/*", 
	"/SignIn", "/SignUp", "/MyAccount", "/ResetPass", "/SignOut", 
	"/AdVideos", "/AdUsers", "/AdStatistics"})
@MultipartConfig()
public class index extends HttpServlet{
	private static final long serialVersionUID = -3484811390900032959L;
	private static DocNet dn = null; 
	private static Email smtp = null;
	
	@Override
	public void init() throws ServletException {
        try{
        	dn = new DocNet("https://raw.githubusercontent.com/AnLaVN/EOA/Releases/EOA-Version/EOA-Author.txt");
			smtp = new Email(	AES.Decrypt(dn.readLine(), "5edf7d86ec54f9ce8357cd97d8592dcdf4ab243fa165157e981b0b613d97cd5d"), 
			                	AES.Decrypt(dn.readLine(), "5edf7d86ec54f9ce8357cd97d8592dcdf4ab243fa165157e981b0b613d97cd5d"), 
			                	"smtp.zoho.com");
		}catch(IOException e){
			Log.add("Loi khoi tao smtp");
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String URI = req.getRequestURI(), lang = myScope.Request().getParameter("lang");
		
    	if(lang != null) myScope.Session().setAttribute("lang", lang);
		
		if(URI.contains("/Home")) 			this.doHome(req,resp);
		if(URI.contains("/Liked"))			this.doLiked(req,resp);
		if(URI.contains("/Video/"))			this.doVideo(req,resp);
		
		if(URI.contains("/SignIn")) 		this.doSignIn(req,resp);
		if(URI.contains("/SignUp")) 		this.doSignUp(req,resp);
		if(URI.contains("/MyAccount")) 		this.doMyAccount(req,resp);
		if(URI.contains("/ResetPass"))		this.doResetPass(req,resp);
		if(URI.contains("/SignOut"))		this.doSignOut(req,resp);
		
		if(URI.contains("/AdVideos"))		this.doAdVideos(req,resp);
		if(URI.contains("/AdUsers"))		this.doAdUsers(req,resp);
		if(URI.contains("/AdStatistics"))	this.doAdStatistics(req,resp);
	}
	
	private void doAdVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myScope.Request().setAttribute("WebView", "AdVideos");
		String  videoID = myScope.Request().getParameter("videoId"),
				method = myScope.Request().getMethod();
		if(videoID != null) {
			myScope.Request().setAttribute("video", VideoDAO.Select(videoID));
			myScope.Request().setAttribute("TabContent", true);
		}else if(method.equals("POST")) {
			try {
				Video video = myForm.getBean(Video.class);
				videoID = video.getIdYoutube();
				boolean onDelete = myScope.Request().getParameter("Del").equals("delete"),
						isExists = VideoDAO.Select(videoID) != null;
//				File img = myForm.getFile("inpThumbnail", "Thumbnail");
//				video.setThumbnail(img.getAbsolutePath());
//				video.setThumbnail("https://cdn.sforum.vn/sforum/wp-content/uploads/2021/08/YoutubeThumbnailSize-1-1280x720-1.jpg");
				video.setThumbnail("https://i3.ytimg.com/vi/"+videoID+"/maxresdefault.jpg");
				if(onDelete)		VideoDAO.Delete(videoID);
				else if(isExists) 	VideoDAO.Update(video);
				else				VideoDAO.Insert(video);
			} catch (Exception e) {
				myScope.Request().setAttribute("Toast", true);
				myScope.Request().setAttribute("contentColor", "danger");
				myScope.Request().setAttribute("content", "Không thể upload/delete video !!!");
			}
		}
		
		try {
			String page = myScope.Request().getParameter("page");
			if(page == null) page = "1";
			List<Video> listVideo = VideoDAO.SelectPage(Integer.parseInt(page));
			int videoSize = VideoDAO.Select().size();
			myScope.Request().setAttribute("listVideo", listVideo);
			myScope.Request().setAttribute("totalVideo", videoSize);
			myScope.Request().setAttribute("page", page);
			myScope.Request().setAttribute("pageVideo",(videoSize + 6 - 1) / 6);
		}catch(Exception e) { myScope.Request().setAttribute("WebView", "Error"); }
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}
	
	private void doAdUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myScope.Request().setAttribute("WebView", "AdUsers");
		String  userID = myScope.Request().getParameter("userId"),
				method = myScope.Request().getMethod();
		if(userID != null) {
			myScope.Request().setAttribute("user", UserDAO.Select(userID));
			myScope.Request().setAttribute("TabContent", true);
		}else if(method.equals("POST")) {
			try {
				User newUser = myForm.getBean(User.class);
				User curUser = UserDAO.Select(newUser.getUsername());
				curUser.setFullname(newUser.getFullname());
				curUser.setEmail(newUser.getEmail());
				curUser.setRole(newUser.getRole());
				boolean onDelete = myScope.Request().getParameter("Del").equals("delete");
				if(myScope.Request().getParameter("txtCPassRP").equals(curUser.getPassword())) {
					if(onDelete)UserDAO.Delete(curUser.getUsername());
					else 		UserDAO.Update(curUser);
				}else throw new RuntimeException();
			} catch (Exception e) {
				myScope.Request().setAttribute("Toast", true);
				myScope.Request().setAttribute("contentColor", "danger");
				myScope.Request().setAttribute("content", "Không thể update/delete user !!!");
			}
		}
		
		try {
			String page = myScope.Request().getParameter("page");
			if(page == null) page = "1";
			List<User> listUser = UserDAO.SelectPage(Integer.parseInt(page));
			int userSize = UserDAO.Select().size();
			myScope.Request().setAttribute("listUser", listUser);
			myScope.Request().setAttribute("totalUser", userSize);
			myScope.Request().setAttribute("page", page);
			myScope.Request().setAttribute("pageUser",(userSize + 6 - 1) / 6);
		}catch(Exception e) { myScope.Request().setAttribute("WebView", "Error"); }
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
		
	}
	
	private void doAdStatistics(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myScope.Request().setAttribute("WebView", "AdStatistics");
		String tabContent = myScope.Request().getParameter("TabContent");
		if(tabContent == null) tabContent = "1";
		myScope.Request().setAttribute("TabContent", tabContent);
		
		if(tabContent.equals("1")) {
			try {
				String page = myScope.Request().getParameter("page");
				if(page == null) page = "1";
				List<Video> listVideo = VideoDAO.SelectPage(Integer.parseInt(page));
				int videoSize = VideoDAO.Select().size();
				myScope.Request().setAttribute("listVideo", listVideo);
				myScope.Request().setAttribute("totalVideo", videoSize);
				myScope.Request().setAttribute("page", page);
				myScope.Request().setAttribute("pageVideo",(videoSize + 6 - 1) / 6);
			}catch(Exception e) {
				myScope.Request().setAttribute("Toast", true);
				myScope.Request().setAttribute("contentColor", "danger");
				myScope.Request().setAttribute("content", "Danh sách video không thể load. !!!");
			}
		}else if(tabContent.equals("2") || tabContent.equals("3")) {
			try {
				String videoId = myScope.Request().getParameter("videoId");
				myScope.Request().setAttribute("listVideo", VideoDAO.Select());
				if(videoId != null) {
					Video video = VideoDAO.Select(videoId);	
					myScope.Request().setAttribute("videoId", videoId);
					if(video != null) {
						switch (tabContent) {
						case "2" -> myScope.Request().setAttribute("listLiked", video.getListLiked());
						case "3" -> {
							List<Viewed> listViewed = video.getListViewed();
							myScope.Request().setAttribute("listViewedSize", listViewed.size());
							myScope.Request().setAttribute("listViewedDetail",ViewedDAO.DetailViewed(listViewed));
						}}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
				myScope.Request().setAttribute("Toast", true);
				myScope.Request().setAttribute("contentColor", "danger");
				myScope.Request().setAttribute("content", "Không thể tải danh sách số liệu thống kê. !!!");
			}
		}else myScope.Request().setAttribute("WebView", "Error");
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}


	private void doHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myScope.Request().setAttribute("WebView", "Home");
		if(myScope.Request().getMethod().equals("POST")) {
			try {
				String search = myScope.Request().getParameter("txtSearch");
				List<Video> listVideo = VideoDAO.SelectByTitleContains(search);
				if(listVideo.size() < 1) throw new RuntimeException();
				myScope.Request().setAttribute("listVideo", listVideo);
			}catch(Exception e) { myScope.Request().setAttribute("WebView", "Error"); }
		}else {
			try {
				String page = myScope.Request().getParameter("page");
				if(page == null) page = "1";
				List<Video> listVideo = VideoDAO.SelectPage(Integer.parseInt(page));
				if(listVideo.size() < 1) throw new RuntimeException();
				myScope.Request().setAttribute("listVideo", listVideo);
				myScope.Request().setAttribute("page", page);
				myScope.Request().setAttribute("pageVideo",(VideoDAO.Select().size() + 6 - 1) / 6);
			}catch(Exception e) { myScope.Request().setAttribute("WebView", "Error"); }
		}
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(myScope.Request().getMethod().equals("POST")) {
			String	username = myScope.Request().getParameter("username"),
					password = myScope.Request().getParameter("password");
			User user = UserDAO.Select(username);
			if( user!=null && user.getPassword().equals(password) ) {
				myScope.Session().setAttribute("user", user);
				int hour = myScope.Request().getParameter("rdoCheck") != null ? 7*24 : 0;
				myCookie.add("userCookie", AES.Encrypt(username, "userCookie@#$%PS21776")+"~"+SHA256.Encrypt(password), hour);
				RRSharer.getResponse().sendRedirect("Home");
				return;
			}else {
				myScope.Request().setAttribute("Toast", true);
				myScope.Request().setAttribute("contentColor", "danger");
				myScope.Request().setAttribute("content", "Tên đăng nhập hoặc mật khẩu không hợp lệ !!!");
			}
		}
		myScope.Request().setAttribute("WebView", "SignIn");
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}

	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(myScope.Request().getMethod().equals("POST")) {
    		String contentColor = "danger", content = "";
    		try {
    			User user = myForm.getBean(User.class);
				if(UserDAO.Insert(user)) {
    				contentColor = "success";
       				content = "Tài khoản đã được đăng ký thành công. Hãy đăng nhập bên trang chủ.";
       			}else content = "Hông thể đăng ký tài khoản này :(((";
			}catch(IllegalAccessException | InstantiationException | InvocationTargetException e) { content = "Đã xảy ra lỗi !!!"; }
    		myScope.Request().setAttribute("Toast", true);
    		myScope.Request().setAttribute("contentColor", contentColor);
    		myScope.Request().setAttribute("content", content);
		}
		myScope.Request().setAttribute("WebView", "SignUp");
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}

	private void doMyAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if(myScope.Request().getMethod().equals("POST")) {
    		String contentColor = "danger", content = "";
    		try{
    			User curUser = (User) myScope.Session().getAttribute("user");
    			User newUser = myForm.getBean(User.class);
    			curUser.setFullname(newUser.getFullname());
    			curUser.setEmail(newUser.getEmail());
    			if(UserDAO.Update(curUser)) {
    				contentColor = "success";
    				content = "Cập nhật user Thành công !!!";
    				myScope.Session().setAttribute("user", curUser);
    			}else content = "Hông thể cập nhật tài khoản này :(((";
        	}catch(Exception e) { content = "Đã xảy ra lỗi !!!"; }
    		myScope.Request().setAttribute("Toast", true);
    		myScope.Request().setAttribute("contentColor", contentColor);
    		myScope.Request().setAttribute("content", content);
		}
    	myScope.Request().setAttribute("WebView", "MyAccount");
    	myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}

	private void doResetPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String OTPCode = (String) myScope.Session().getAttribute("OTPCode");
    	User curUser = (User) myScope.Session().getAttribute("user");
    	if(OTPCode == null) {
    		OTPCode = RandomORG.getInteger(111111, 999999, 10);
    		myScope.Session().setAttribute("OTPCode", OTPCode);
            smtp.setEmail("YÊU CẦU THAY ĐỔI MẬT KHẨU", EmailContent.getOTP(curUser.getFullname(), OTPCode));
    		new Thread() { @Override public void run() {
    			try{ smtp.sendEmailTo(curUser.getEmail()); }
    			catch (Exception e) {
                	myScope.Request().setAttribute("Toast", true);
            		myScope.Request().setAttribute("contentColor", "danger");
            		myScope.Request().setAttribute("content", "Hông thể gửi email về tài khoản, vui lòng thử lại sau !");
                }
            }}.start();
    	}
		if(myScope.Request().getMethod().equals("POST")) {
    		String contentColor = "danger", content = "";
    		if(curUser.getEmail().equals(myScope.Request().getParameter("txtEmailRP")) && OTPCode.equals(myScope.Request().getParameter("txtOTP"))) {
    			curUser.setPassword(myScope.Request().getParameter("txtNPassRP"));
    			if(UserDAO.Update(curUser)) {
        			contentColor = "success";
        			content = "Cập nhật mật khẩu thành công. Vui lòng đăng nhập lại !";
        			SignOut();
        		} else content = "Hông thể cập nhật mật khẩu của tài khoản này :(((";
    		}else content = "Địa chỉ email hoặc mã OTP không khớp !!!";
    		myScope.Request().setAttribute("Toast", true);
    		myScope.Request().setAttribute("contentColor", contentColor);
    		myScope.Request().setAttribute("content", content);
		}
    	myScope.Request().setAttribute("WebView", "ResetPass");
    	myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}
	
	private void doSignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SignOut();
		RRSharer.getResponse().sendRedirect("Home");
	}

	private void doVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String URI = req.getRequestURI(); 	URI = URI.substring(URI.lastIndexOf("/")+1);
			Video video = VideoDAO.Select(URI);
			User curUser = (User) myScope.Session().getAttribute("user");
			
			if(req.getMethod().equals("POST")) {
				String  videoShare = myScope.Request().getParameter("VideoShare"),
						emailShare = myScope.Request().getParameter("EmailGetShare"),
						videoLike  = myScope.Request().getParameter("VideoLike");
				if(videoShare != null && emailShare!= null) {
					smtp.setEmail("NỘI DUNG ĐƯỢC CHIA SẺ", EmailContent.getShare(curUser.getFullname(), videoShare));
					new Thread() { @Override public void run() {
						try{ smtp.sendEmailTo(emailShare);
						}catch (MessagingException e) {
							myScope.Request().setAttribute("contentColor", "danger");
							myScope.Request().setAttribute("content", "Không thể chia sẻ video!!!");
						}
		            }}.start();
				}if(videoLike != null) {
					new Thread() { @Override public void run() {
						for(Liked like : UserDAO.Select(curUser.getUsername()).getListLiked()) {
							if(like.getVideo().getIdYoutube().equals(videoLike)) {
								LikedDAO.Delete(like.getId());
								interrupt();
								return;
							}
						}
						Liked liked = new Liked();
						liked.setUser(curUser);
						liked.setVideo(video);
						LikedDAO.Insert(liked);
		            }}.start();
				}
			}
		
			if(video != null) {
				Viewed userViewed = new Viewed();
				userViewed.setUser(curUser);
				userViewed.setVideo(video);
				ViewedDAO.Insert(userViewed);
				myScope.Request().setAttribute("video", video);
				boolean liked = false;
				for(Liked like : UserDAO.Select(curUser.getUsername()).getListLiked()) {
					if(like.getVideo().getIdYoutube().equals(URI)) liked = true;
				}
				myScope.Request().setAttribute("liked", liked);
				List<Video> listVideo = VideoDAO.SelectRandom();
				myScope.Request().setAttribute("listVideo", listVideo);
				myScope.Request().setAttribute("WebView", "Video");
			}else myScope.Request().setAttribute("WebView", "Error");
		}catch(Exception e) {
			myScope.Request().setAttribute("contentColor", "danger");
			myScope.Request().setAttribute("content", "Video không thể load. !!!");
		}
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}
	
	private void doLiked(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myScope.Request().setAttribute("WebView", "Liked");
		try {
			String page = myScope.Request().getParameter("page");
			if(page == null) page = "1";
			User curUser = (User)myScope.Session().getAttribute("user");
			List<Video> listVideo = VideoDAO.SelectByIDUserLiked(curUser.getUsername(), Integer.parseInt(page));
			if(listVideo.size() < 1) throw new RuntimeException();
			myScope.Request().setAttribute("listVideo", listVideo);
			myScope.Request().setAttribute("page", page);
			myScope.Request().setAttribute("pageVideo",(UserDAO.Select(curUser.getUsername()).getListLiked().size() + 6 - 1) / 6);
		}catch(Exception e) { myScope.Request().setAttribute("WebView", "Error"); }
		myScope.Request().getRequestDispatcher("/WEB/index.jsp").forward(req, resp);
	}
	
	
	private void SignOut() {
		myCookie.remove("userCookie");
		myScope.Session().removeAttribute("user");
	}
}