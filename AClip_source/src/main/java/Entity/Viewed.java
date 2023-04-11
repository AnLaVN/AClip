package Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.io.Serializable;
import javax.persistence.*;

@Entity(name = "USERSVIEWED")
@Table(name = "USERSVIEWED", uniqueConstraints = {@UniqueConstraint(columnNames = {"IDUser", "IDVideo"})})
public class Viewed implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IDUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "IDVideo")
    private Video video;
    
    //Setter
    public void setId(Long idLike)    { id = idLike;     }
    public void setUser(User userLike){ user = userLike; }
    public void setVideo(Video videoV){ video = videoV;  }
    
    //Getter
    public Long getId()    { return id;    }
    public User getUser()  { return user;  }
    public Video getVideo(){ return video; }
}