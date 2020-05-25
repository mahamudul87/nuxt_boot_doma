package streaming.movies.vmotion.connector.infrastructure.doma;

import lombok.Builder;
import lombok.Data;
import org.seasar.doma.*;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "movies")
public class MovieDescriptorData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String title;
  public Integer  year;
  public String language;
  public String country;
  public String description;
  public Integer  status;
  public String type;
  public String image;
  public String vedios;
  public String user_type;
  public String created_by;
  public Timestamp created_at;
  @Override
  public String toString() {
    return "Movie [ Title="+title+"]";
  }
}
