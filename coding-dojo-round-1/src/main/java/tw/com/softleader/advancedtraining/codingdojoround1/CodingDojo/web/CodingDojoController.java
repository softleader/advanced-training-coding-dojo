package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

@RestController
public class CodingDojoController {
  @Autowired
  CodingDojoService service;

  @GetMapping("/getall")
  public List<CodingDojo> getAll() {
    return service.queryAll();
  }
}
