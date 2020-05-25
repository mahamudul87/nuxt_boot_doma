package streaming.movies.vmotion.connector.infrastructure.doma;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import java.util.List;

import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface MovieDescriptorDao {
  @Select
  List<MovieDescriptorData> selectAll();
}
