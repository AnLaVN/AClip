package DAO;
//Make by Bình An || AnLaVN || KatoVN

import Entity.User;
import Entity.Video;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDAO {
    
    /**Sử dụng phương thức này để INSERT một user vào CSDL.
     * @param user Là User cần INSERT.
     * @return TRUE Nếu INSERT thành công, ngược lại là FALSE.
     */
    public static final boolean Insert(User user){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction

            em.persist(user);               //Thêm user vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để UPDATE một user trong CSDL.
     * @param user Là User cần UPDATE.
     * @return TRUE Nếu UPDATE thành công, ngược lại là FALSE.
     */
    public static final boolean Update(User user){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.merge(user);                 //Cập nhật user vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để DELETE một user khỏi CSDL.
     * @param username Là username cần DELETE.
     * @return TRUE Nếu DELETE thành công, ngược lại là FALSE.
     */
    public static final boolean Delete(String username){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.remove(em.find(User.class, username));	//Xoá user khỏi CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để SELECT một user trong CSDL bằng ID username.
     * @param username Là ID user cần SELECT.
     * @return User nếu SELECT thành công. Hoặc Null nếu không tồn tại.
     * @throws java.lang.IllegalArgumentException Ngoại lệ được ném ra khi không thể SELECT được user, khoá chính không hợp lệ hoặc null.
     */
    public static final User Select(String username) throws IllegalArgumentException{
        EntityManager em = JPA.getEM();     //Create transaction
        User user = em.find(User.class, username);      //Select ONE User
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return user;   
    }

    /**Sử dụng phương thức này để SELECT toàn bộ user trong CSDL.
     * @return Danh sách User nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<User> Select() throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<User> query = em.createNamedQuery("User.SelectAll", User.class);  //Create query
        List<User> listUser = query.getResultList();    //Select ALL User
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listUser;                    //Return List user
    }
    
    /**Sử dụng phương thức này để SELECT những user đã like video trong CSDL.
     * @return Danh sách User đã like video nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<User> SelectByIDVideo(String idVideo) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<User> query = em.createQuery("SELECT o.user FROM USERSLIKED o WHERE o.video.idYoutube = :idVideo", User.class);  //Create query
        query.setParameter("idVideo", idVideo);
        List<User> listUser = query.getResultList();    //Select danh sách User đã like video
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listUser;                    //Return List user
    }
    
    
    public static final List<User> SelectPage(int page) throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
    	TypedQuery<User> query = em.createNamedQuery("User.SelectAll", User.class);  //Create query
        query.setFirstResult((page-1)*6);	//Select from result start of page
        query.setMaxResults(6);				//Select 6 result for page
        List<User> listUser = query.getResultList();		//Select ALL User
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listUser; 					//Return List user
    }

}