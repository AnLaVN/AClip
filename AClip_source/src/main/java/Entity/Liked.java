package Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

@Entity(name = "USERSLIKED")
@Table(name = "USERSLIKED", uniqueConstraints = {@UniqueConstraint(columnNames = {"IDUser", "IDVideo"})})
public class Liked implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IDUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "IDVideo")
    private Video video;
    @Temporal(TemporalType.DATE)
    private Date time = new Date();

    //Setter
    public void setId(Long idLike)    { id = idLike;     }
    public void setUser(User userLike){ user = userLike; }
    public void setVideo(Video videoL){ video = videoL;  }
    public void setTime(Date timeup)  { time = timeup;   }
    
    //Getter
    public Long getId()    { return id;    }
    public User getUser()  { return user;  }
    public Video getVideo(){ return video; }
    public Date getTime()  { return time;  }
}