package Tool;
//Make by Bình An || AnLaVN || KatoVN

import java.util.HashMap;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RRSharer {
	private static HashMap<Long, HttpServletRequest>  mapReq  = new HashMap<Long, HttpServletRequest>();
	private static HashMap<Long, HttpServletResponse> mapResp = new HashMap<Long, HttpServletResponse>();
	private static Long getID(){	return Thread.currentThread().getId(); 		}
	
	public static void Add(HttpServletRequest req, HttpServletResponse resp) {
		mapReq.put(getID(), req);
		mapResp.put(getID(), resp);
	}
	
	public static HttpServletRequest getRequest() {
		return mapReq.get(getID());
	}
	
	public static HttpServletResponse getResponse() {
		return mapResp.get(getID());
	}
	
	public static void Remove() {
		mapReq.remove(getID());
		mapResp.remove(getID());
	}
}