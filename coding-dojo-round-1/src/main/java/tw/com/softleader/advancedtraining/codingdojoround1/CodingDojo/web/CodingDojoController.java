package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

import java.util.List;

@RestController
public class CodingDojoController {
  @Autowired
  CodingDojoService service;

  @GetMapping("/getall")
  public List<CodingDojo> getAll() {
    return service.queryAll();
  }

  @PostMapping("/save")
  public String saveMessage(@RequestBody CodingDojo form) {

    service.save(form);
    return "/";
  }
}
