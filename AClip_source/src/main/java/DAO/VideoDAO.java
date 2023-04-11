package DAO;
//Make by Bình An || AnLaVN || KatoVN

import Entity.Video;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

public class VideoDAO {
    
    /**Sử dụng phương thức này để INSERT một video vào CSDL.
     * @param video Là Video cần INSERT.
     * @return TRUE Nếu INSERT thành công, ngược lại là FALSE.
     */
    public static final boolean Insert(Video video){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction

            em.persist(video);              //Thêm video vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để UPDATE một video trong CSDL.
     * @param video Là Video cần UPDATE.
     * @return TRUE Nếu UPDATE thành công, ngược lại là FALSE.
     */
    public static final boolean Update(Video video){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.merge(video);                //Cập nhật video vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để DELETE một video khỏi CSDL.
     * @param id Là id video cần DELETE.
     * @return TRUE Nếu DELETE thành công, ngược lại là FALSE.
     */
    public static final boolean Delete(String id){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.remove(em.find(Video.class, id));		//Xoá video khỏi CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để SELECT một video trong CSDL bằng ID video.
     * @param id Là ID video cần SELECT.
     * @return Video nếu SELECT thành công. Hoặc Null nếu không tồn tại.
     * @throws java.lang.IllegalArgumentException Ngoại lệ được ném ra khi không thể SELECT được video, khoá chính không hợp lệ hoặc null.
     */
    public static final Video Select(String id) throws IllegalArgumentException{
        EntityManager em = JPA.getEM();     //Create transaction
        Video video = em.find(Video.class, id);			//Select ONE Video
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return video;   
    }

    /**Sử dụng phương thức này để SELECT toàn bộ video trong CSDL.
     * @return Danh sách Video nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Video> Select() throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Video> query = em.createNamedQuery("Video.SelectAll", Video.class);  //Create query
        List<Video> listVideo = query.getResultList();		//Select ALL Video
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;                   //Return List Video
    }
    
    /**Sử dụng phương thức này để SELECT danh sách video có/không lượt like trong CSDL.
     * @return Danh sách Video có/không lượt like trong CSDL nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Video> Select(boolean Video) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Video> query = em.createQuery("SELECT DISTINCT o FROM VIDEOS o WHERE o.listLiked IS"+(Video?" ":" NOT ")+"EMPTY ORDER BY o.time DESC", Video.class);  //Create query
        List<Video> listVideo = query.getResultList();		//Select ALL Video
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;					//Return List Video
    }

    
    
    
    /**Sử dụng phương thức này để SELECT những Video có tiêu đề tương tự trong CSDL.
     * @return Danh sách Video có tiêu đề tương tự nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Video> SelectByTitleContains(String title) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Video> query = em.createNamedQuery("Video.ByTitleContains", Video.class);  //Create query
        query.setParameter(0, "%"+title+"%");
        List<Video> listVideo = query.getResultList();    //Select Video có tiêu đề tương tự
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;                   //Return List Video
    }
    
    /**Sử dụng phương thức này để SELECT những Video được thích bởi người dùng trong CSDL.
     * @return Danh sách Video được thích bởi người dùng nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Video> SelectByIDUserLiked(String username, int page) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Video> query = em.createNamedQuery("Video.ByIDUserLiked", Video.class);  //Create query
        query.setParameter(0, username);	//Set username want select
        query.setFirstResult((page-1)*6);	//Select from result start of page
        query.setMaxResults(6);				//Select 6 result for page
        List<Video> listVideo = query.getResultList();    //Select Video được thích bởi người dùng
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;                   //Return List Video
    }
    
    /**Sử dụng phương thức này để SELECT những Video nằm giữa khoảng 2 ngày trong CSDL.
     * @return Danh sách Video nằm giữa khoảng 2 ngày nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Video> SelectByBetweenDate(Date oldest, Date newest) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Video> query = em.createNamedQuery("Video.ByBetweenDate", Video.class);  //Create query
        query.setParameter(0, oldest);
        query.setParameter(1, newest);
        List<Video> listVideo = query.getResultList();    //Select Video nằm giữa khoảng 2 ngày
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;                   //Return List Video
    }
    
    /**Sử dụng phương thức này để SELECT những Video nằm trong danh sách tháng trong CSDL.
     * @return Danh sách Video nằm trong danh sách tháng nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Video> SelectByListMonth(List<Integer> listMonth) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Video> query = em.createNamedQuery("Video.ByListMonth", Video.class);  //Create query
        query.setParameter(0, listMonth);
        List<Video> listVideo = query.getResultList();    //Select Video nằm trong danh sách tháng
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;                   //Return List Video
    }
    
    
    
    /**Sử dụng phương thức này để SELECT những Video ngẫu nhiên trong CSDL.
     * @return Danh sách Video ngẫu nhiên nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Video> SelectRandom() throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        Query query = em.createNamedQuery("Video.SelectRandom");  //Create query
        List<Video> listVideo = query.getResultList();    //Select Video ngẫu nhiên
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;                   //Return List Video
    }
    
    public static final List<Video> SelectPage(int page) throws Exception{
    	EntityManager em = JPA.getEM();     //Create transaction
    	TypedQuery<Video> query = em.createNamedQuery("Video.SelectAll", Video.class);  //Create query
        query.setFirstResult((page-1)*6);	//Select from result start of page
        query.setMaxResults(6);				//Select 6 result for page
        List<Video> listVideo = query.getResultList();		//Select ALL Video
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listVideo;                   //Return List Video
    }
    
}