package Tool;
//Make by Bình An || AnLaVN || KatoVN

import jakarta.servlet.http.Cookie;

public class myCookie {

    /**Sử dụng phương thức này để thêm một cookie mới.
     * @param name Là tên cookie cần thêm.
     * @param value Là giá trị của cookie cần thêm. Không vượt quá 4096 bytes.
     * @param hours Là số giờ khả dụng của cookie.
     */
    public static final void add(String name, String value, int hours) {
        Cookie ck = new Cookie(name, value);
        ck.setMaxAge(hours * 60 * 60);
        ck.setPath("/");
        RRSharer.getResponse().addCookie(ck);
    }

    /**Sử dụng phương thức này để lấy cookie.
     * @param name Là tên cookie cần tìm.
     * @return Giá trị của cookie cần tìm nếu có. Null nếu không tìm thấy cookie hoặc không có cookie nào.
     */
    public static final String get(String name) {
        Cookie[] cks = RRSharer.getRequest().getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                if (ck.getName().equals(name))  return ck.getValue();
            }
        }
        return null;
    }
    
    /**Sử dụng phương thức này để xoá cookie.
     * @param name Là tên cookie cần xoá.
     * @return TRUE nếu xoá thành công. FALSE nếu không tìm thấy cookie hoặc không có cookie nào.
     */
    public static final boolean remove(String name) {
    	Cookie[] cks = RRSharer.getRequest().getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                if (ck.getName().equals(name)) { 
                    add(name, null, 0);
                    return true;
                }
            }
        }
    	return false;
    }
}