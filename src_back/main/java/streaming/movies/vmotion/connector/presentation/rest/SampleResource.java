package streaming.movies.vmotion.connector.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import streaming.movies.vmotion.connector.infrastructure.doma.DomaMoviesRepository;
import streaming.movies.vmotion.connector.infrastructure.doma.MovieDescriptorData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequestMapping("/api")
@RestController
public class SampleResource {
  @Autowired
  private DomaMoviesRepository domaMoviesRepository;
  private static List<String> LIST = Arrays.asList("太郎","次郎","三郎");
  @GetMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String hello() {
    List<String> shuffling = new ArrayList<>(LIST);
    Collections.shuffle(shuffling);
    return shuffling.get(0);
  }
  @GetMapping(path = "/vedioList", produces = MediaType.TEXT_PLAIN_VALUE)
  public String vedioList() {
    List<String> shuffling = new ArrayList<>(LIST);
    Collections.shuffle(shuffling);
    List<MovieDescriptorData> res=domaMoviesRepository.getMovieList();
    System.out.println(Arrays.toString(res.toArray()));
    return shuffling.get(0);
  }
}
