package Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.util.Date;
import javax.persistence.*;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "Report.OfYear", 
			procedureName = "sp_ReportOfYear", 
			parameters = {@StoredProcedureParameter(name = "year", type = Integer.class, mode = ParameterMode.IN)},
			resultClasses = {Report.class}
	)
})
@Entity()
public class Report {
    @Id
    private String idVideo;
    private Long likes;
    @Temporal(TemporalType.DATE)
    private Date newestLiked;
    @Temporal(TemporalType.DATE)
    private Date oldestLiked;

    //Constructor
    public Report(){}
    public Report(String idVideo, Long likes, Date newestLiked, Date oldestLiked) {
        this.idVideo = idVideo;
        this.likes = likes;
        this.newestLiked = newestLiked;
        this.oldestLiked = oldestLiked;
    }
    
    //Setter
    public String getIdVideo()  { return idVideo;     }
    public Long getLikes()      { return likes;       }
    public Date getNewestLiked(){ return newestLiked; }
    public Date getOldestLiked(){ return oldestLiked; }
    
    //Getter
    public void setIdVideo(String idVideo) { this.idVideo = idVideo;    }
    public void setLikes(Long likes)       { this.likes = likes;        }
    public void setNewestLiked(Date newest){ this.newestLiked = newest; }
    public void setOldestLiked(Date oldest){ this.oldestLiked = oldest; }
}