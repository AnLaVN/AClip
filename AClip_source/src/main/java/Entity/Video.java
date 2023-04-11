package Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;

@NamedQueries({
	@NamedQuery(name = "Video.SelectAll", query = "SELECT o FROM VIDEOS o ORDER BY o.time DESC"),
	@NamedQuery(name = "Video.ByTitleContains", query = "SELECT o FROM VIDEOS o WHERE o.title LIKE ?0 ORDER BY o.time DESC"),
	@NamedQuery(name = "Video.ByIDUserLiked", query = "SELECT o.video FROM USERSLIKED o WHERE o.user.id = ?0 ORDER BY o.time DESC"),
	@NamedQuery(name = "Video.ByBetweenDate", query = "SELECT o.video FROM USERSLIKED o WHERE o.time BETWEEN ?0 AND ?1 ORDER BY o.time DESC"),
	@NamedQuery(name = "Video.ByListMonth", query = "SELECT o.video FROM USERSLIKED o WHERE MONTH(o.time) IN (?0) ORDER BY o.time DESC")
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "Video.SelectRandom", query = "SELECT TOP 6 * FROM VIDEOS ORDER BY NEWID()", resultClass = Video.class)
})
@Entity(name = "VIDEOS")
@Table(name = "VIDEOS")
public class Video implements Serializable{
    @Id
    private String idYoutube;
    private String title, description, thumbnail;
    @Temporal(TemporalType.DATE)
    private Date time = new Date();
    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Liked> listLiked;
    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Viewed> listViewed;
	
    //Setter
    public void setIdYoutube(String id)    		{ idYoutube = id;     				}
    public void setTitle(String tit)       		{ title = tit.replaceAll("'","’");	}
    public void setDescription(String desp)		{ description = desp; 				}
    public void setThumbnail(String thum)  		{ thumbnail = thum;   				}
    public void setTime(Date timeup)       		{ time = timeup;      				}
    public void setListLiked(List<Liked> arrL)  { listLiked = arrL;	 				}
    public void setListViewed(List<Viewed> arrV){ listViewed = arrV;	 			}
    
    //Getter
    public String getIdYoutube()  		{ return idYoutube;   }
    public String getTitle()      		{ return title;       }
    public String getDescription()		{ return description; }
    public String getThumbnail()  		{ return thumbnail;   }
    public Date getTime()         		{ return time;        }
    public List<Liked> getListLiked()  	{ return listLiked;   }
    public List<Viewed> getListViewed() { return listViewed;  }
}