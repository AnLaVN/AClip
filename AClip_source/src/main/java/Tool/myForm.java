package Tool;
//Make by Bình An || AnLaVN || KatoVN

import com.AnLa.HASH.SHA256;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.beanutils.BeanUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;

public class myForm {
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	public static boolean isExist(String name) {
		return RRSharer.getRequest().getParameter(name) != null;
	}

	public static String getString(String name) {
		return RRSharer.getRequest().getParameter(name);
	}

	public static int getInt(String name) {
		return Integer.parseInt(getString(name));
	}

	public static double getDoub(String name) {
		return Double.parseDouble(getString(name));
	}

	public static boolean getBool(String name) {
		return Boolean.parseBoolean(getString(name));
	}

	public static Date getDate(String name) throws ParseException {
		return SDF.parse(getString(name));
	}

	// @MultipartConfig()
	public static File getFile(String name, String folder) throws IOException, ServletException {
		File dir = new File(RRSharer.getRequest().getServletContext().getRealPath(folder)); // Khởi tạo thư mục chứa tệp
		if (!dir.exists()) dir.mkdirs(); 													// Tạo thư mục nếu không tồn tại
		Part part = RRSharer.getRequest().getPart(name);									// Khởi tạo phần của tệp
		String  fileName = part.getSubmittedFileName(), 									// Lấy tên tệp từ người dùng
				fileExtension = fileName.substring(fileName.lastIndexOf(".")); 				// Cắt chuỗi lấy phần tên mở rộng
		fileName = SHA256.Encrypt(System.currentTimeMillis() + fileName) + fileExtension; 	// Tên tệp = Mã hoá(thời gian mili hiện tại + tên tệp nguời dùng) + tên mở rộng
		File file = new File(dir, fileName); 												// Khởi tạo tệp tại thư mục với tên mới
		part.write(file.getAbsolutePath()); 												// Ghi các phần vào tệp tại đường dẫn tuyệt đối của tệp
		return file; 																		// Trả về tệp
	}

	public static <T> T getBean(Class<T> myClass) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		T myBean = myClass.newInstance();
		BeanUtils.populate(myBean, RRSharer.getRequest().getParameterMap());
		return myBean;
	}
}