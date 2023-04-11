package Tool;
//Make by Bình An || AnLaVN || KatoVN

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class myScope {
	
	public static HttpServletRequest Request() 					{ return RRSharer.getRequest(); 			}
	public static void setRequest(String name, Object value)	{ Request().setAttribute(name, value); 		}
	public static Object getRequest(String name)				{ return Request().getAttribute(name); 		}
	public static void removeRequest(String name)				{ Request().removeAttribute(name); 			}
	
	public static HttpSession Session() 						{ return Request().getSession(); 			}
	public static void setSession(String name, Object value)	{ Session().setAttribute(name, value);		}
	public static Object getSession(String name)				{ return Session().getAttribute(name);		}
	public static void removeSession(String name) 				{ Session().removeAttribute(name); 			}
	
	public static ServletContext Application() 					{ return Request().getServletContext(); 	}
	public static void setApplication(String name, Object value){ Application().setAttribute(name, value); 	}
	public static Object getApplication(String name)			{ return Application().getAttribute(name);	}
	public static void removeApplication(String name)			{ Application().removeAttribute(name); 		}
	
}