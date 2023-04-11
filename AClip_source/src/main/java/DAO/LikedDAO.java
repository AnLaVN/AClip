package DAO;
//Make by Bình An || AnLaVN || KatoVN

import Entity.Liked;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LikedDAO {
    
    /**Sử dụng phương thức này để INSERT một liked vào CSDL.
     * @param liked Là Liked cần INSERT.
     * @return TRUE Nếu INSERT thành công, ngược lại là FALSE.
     */
    public static final boolean Insert(Liked liked){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction

            em.persist(liked);              //Thêm liked vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để UPDATE một liked trong CSDL.
     * @param liked Là Liked cần UPDATE.
     * @return TRUE Nếu UPDATE thành công, ngược lại là FALSE.
     */
    public static final boolean Update(Liked liked){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.merge(liked);                //Cập nhật liked vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để DELETE một liked khỏi CSDL.
     * @param id Là id liked cần DELETE.
     * @return TRUE Nếu DELETE thành công, ngược lại là FALSE.
     */
    public static final boolean Delete(Long id){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.remove(em.find(Liked.class, id));	//Xoá liked khỏi CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để SELECT một liked trong CSDL bằng ID liked.
     * @param id Là ID liked cần SELECT.
     * @return Liked nếu SELECT thành công. Hoặc Null nếu không tồn tại.
     * @throws java.lang.IllegalArgumentException Ngoại lệ được ném ra khi không thể SELECT được video, khoá chính không hợp lệ hoặc null.
     */
    public static final Liked Select(Long id) throws IllegalArgumentException{
        EntityManager em = JPA.getEM();     //Create transaction
        Liked liked = em.find(Liked.class, id);      //Select ONE Liked
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return liked;   
    }

    /**Sử dụng phương thức này để SELECT toàn bộ liked trong CSDL.
     * @return Danh sách Liked nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Liked> Select() throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Liked> query = em.createQuery("SELECT o FROM USERSLIKED o", Liked.class);  //Create query
        List<Liked> listLiked = query.getResultList();    //Select ALL Liked
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listLiked;                   //Return List Liked
    }
    
    /**Sử dụng phương thức này để SELECT những liked có chứa từ khoá cần tìm trong CSDL.
     * @return Danh sách Liked chứa từ khoá cần tìm nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Liked> Select(String title) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Liked> query = em.createQuery("SELECT o FROM USERSLIKED o WHERE o.video.title LIKE :title", Liked.class);  //Create query
        query.setParameter("title", "%"+title+"%");
        List<Liked> listLiked = query.getResultList();    //Select Liked chứa từ khoá
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listLiked;                   //Return List Liked
    }
    
}