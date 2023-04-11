package Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedQueries({
	@NamedQuery(name = "User.SelectAll", query = "SELECT o FROM USERS o")
})
@Entity(name = "USERS")
@Table(name = "USERS")
public class User implements Serializable{
    @Id
    private String username;
    private String password, fullname, email;
    private Boolean role = false;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Liked> listLiked;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Viewed> listViewed;
	
    //Setter
    public void setUsername(String user)		{ username = user;  }
    public void setPassword(String pass)		{ password = pass;  }
    public void setFullname(String full)		{ fullname = full;  }
    public void setEmail(String emal)   		{ email = emal;     }
    public void setRole(Boolean rol)    		{ role = rol;       }
    public void setListLiked(List<Liked> arr)	{ listLiked = arr;  }
    public void setListViewed(List<Viewed> arr) { listViewed = arr; }

    //Getter
    public String getUsername() 		{ return username;   }
    public String getPassword() 		{ return password;   }
    public String getFullname() 		{ return fullname;   }
    public String getEmail()    		{ return email;      }
    public Boolean getRole()    		{ return role;       }
    public List<Liked> getListLiked()	{ return listLiked;  }
    public List<Viewed> getListViewed() { return listViewed; }
}