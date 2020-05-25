package streaming.movies.vmotion.connector.infrastructure.doma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomaMoviesRepository{
  @Autowired
  MovieDescriptorDao movieDescriptorDao;
  public List<MovieDescriptorData> getMovieList(){
    List<MovieDescriptorData> response=movieDescriptorDao.selectAll();
    return response;
  }
}
