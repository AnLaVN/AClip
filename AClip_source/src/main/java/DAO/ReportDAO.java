package DAO;
//Make by Bình An || AnLaVN || KatoVN

import Entity.Report;
import java.util.List;
import javax.persistence.*;

public class ReportDAO {

    /**Sử dụng phương thức này để SELECT toàn bộ report trong CSDL.
     * @return Danh sách Report gồm ID Video, tổng lượt thích, ngày thích cũ nhất và mới nhất nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Report> Select() throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Report> query = em.createQuery("SELECT new Report(o.video.id, COUNT(o.user.username), MAX(o.time), MIN(o.time)) FROM USERSLIKED o GROUP BY o.video.id", Report.class);  //Create query
        List<Report> listReport = query.getResultList();    //Select ALL Report
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listReport;                  //Return List Report
    }
    
    /**Sử dụng phương thức này để SELECT những report trong 1 năm trong CSDL.
     * @return Danh sách Report trong 1 năm gồm ID Video, tổng lượt thích, ngày thích cũ nhất và mới nhất nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Report> SelectOfYear(int year) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.OfYear");  //Create query
        query.setParameter("year", year);
        List<Report> listReport = query.getResultList();    //Select ALL Report
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listReport;                  //Return List Report
    }
}