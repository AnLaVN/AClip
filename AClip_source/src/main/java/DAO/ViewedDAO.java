package DAO;
//Make by Bình An || AnLaVN || KatoVN

import Entity.User;
import Entity.Video;
import Entity.Viewed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ViewedDAO {
    
    /**Sử dụng phương thức này để INSERT một viewed vào CSDL.
     * @param viewed Là Viewed cần INSERT.
     * @return TRUE Nếu INSERT thành công, ngược lại là FALSE.
     */
    public static final boolean Insert(Viewed viewed){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction

            em.persist(viewed);             //Thêm viewed vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để UPDATE một viewed trong CSDL.
     * @param viewed Là Viewed cần UPDATE.
     * @return TRUE Nếu UPDATE thành công, ngược lại là FALSE.
     */
    public static final boolean Update(Viewed viewed){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.merge(viewed);               //Cập nhật viewed vào CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để DELETE một viewed khỏi CSDL.
     * @param id Là id viewed cần DELETE.
     * @return TRUE Nếu DELETE thành công, ngược lại là FALSE.
     */
    public static final boolean Delete(Long id){
        EntityManager em = JPA.getEM();     //Create transaction
        try{
            em.getTransaction().begin();    //Start transaction
            
            em.remove(em.find(Viewed.class, id));	//Xoá viewed khỏi CSDL
            
            em.getTransaction().commit();   //Commit transaction
            em.clear();                     //Clear transaction
            em.close();                     //Close transaction
            return true;                    //Return TRUE if successfully
        }catch(Exception e){
            em.getTransaction().rollback(); //Rollback if error
            return false;                   //Return FALSE if error
        }
    }

    /**Sử dụng phương thức này để SELECT một viewed trong CSDL bằng ID viewed.
     * @param id Là ID viewed cần SELECT.
     * @return Viewed nếu SELECT thành công. Hoặc Null nếu không tồn tại.
     * @throws java.lang.IllegalArgumentException Ngoại lệ được ném ra khi không thể SELECT được video, khoá chính không hợp lệ hoặc null.
     */
    public static final Viewed Select(Long id) throws IllegalArgumentException{
        EntityManager em = JPA.getEM();     //Create transaction
        Viewed viewed = em.find(Viewed.class, id);      //Select ONE Viewed
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return viewed;   
    }

    /**Sử dụng phương thức này để SELECT toàn bộ viewed trong CSDL.
     * @return Danh sách Viewed nếu SELECT thành công.
     * @throws java.lang.Exception Ngoại lệ được ném ra khi không thể thực hiện truy vấn.
     */
    public static final List<Viewed> Select() throws Exception{
        EntityManager em = JPA.getEM();     //Create transaction
        TypedQuery<Viewed> query = em.createQuery("SELECT o FROM USERSVIEWED o", Viewed.class);  //Create query
        List<Viewed> listViewed = query.getResultList();    //Select ALL Viewed
        em.clear();                         //Clear transaction
        em.close();                         //Close transaction
        return listViewed;                  //Return List Viewed
    }
    
    /**Sử dụng phương thức này để SELECT chi tiết viewed trong CSDL.
     * @return Danh sách chi tiết Viewed nếu SELECT thành công.
     */
    public static Map<User, Long> DetailViewed(List<Viewed> inputList) {
		Map<User, Long> result = new HashMap<>();
	    for (Viewed element : inputList) {
	    	User user = element.getUser();
	        if(!result.containsKey(user))  result.put(user, 1L);  
	        else 		result.put(user, result.get(user) + 1L);
	    }
	    return result;
	}
    
}