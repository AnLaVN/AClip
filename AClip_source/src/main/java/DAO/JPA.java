package DAO;
//Make by Bình An || AnLaVN || KatoVN

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
    private static EntityManagerFactory emf = null;
    
    /**Phương thức trả về EntityManager từ 1 kết nối SQL duy nhất. Tự động kết nối nếu chưa được thiết lập.
     * @return EntityManager của kết nối SQL.
     */
    public static final EntityManager getEM(){
        if(emf == null || !emf.isOpen())	emf = Persistence.createEntityManagerFactory("AClip");
        return emf.createEntityManager();
    }
    
    /**Phương thức ngắt kết nối CSDL.
     */
    public static final void Disconnect(){
        emf.close();
        emf = null;
    }
}