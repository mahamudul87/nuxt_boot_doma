package streaming.movies.vmotion.connector.presentation.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Profile("local")
@Controller
public class VedioController {
  private static final Logger logger = LoggerFactory.getLogger(VedioController.class);
  private String decodePath(HttpServletRequest request, String prefix) throws UnsupportedEncodingException {
    return URLDecoder.decode(request.getRequestURI().replaceAll("[/]+", "/").substring(prefix.length()), "UTF-8");
  }
  @RequestMapping("video/**")
  public ResponseEntity<InputStreamResource> video(HttpServletRequest request)
    throws UnsupportedEncodingException, FileNotFoundException {
    final String decodeString = decodePath(request, "/video/");
    logger.info("vedios" + decodeString);
    File file = new File("vedios/" + decodeString);
    logger.info("DOWNLOAD " + file.getAbsolutePath());
    final HttpHeaders headers = new HttpHeaders();
    headers.add("Content-disposition", "attachment; filename=\"" + file.getName() + "\"");
    return ResponseEntity.ok().headers(headers).contentLength(file.length())
      .contentType(MediaType.parseMediaType("application/octet-stream"))
      .body(new InputStreamResource(new FileInputStream(file)));
  }
}
