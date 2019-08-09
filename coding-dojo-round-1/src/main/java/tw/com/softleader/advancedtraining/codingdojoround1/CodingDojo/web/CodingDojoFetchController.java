package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

import java.util.List;

@RestController
@RequestMapping("/fetch")
public class CodingDojoFetchController {
  @Autowired CodingDojoService service;

  @GetMapping("/getall")
  public List<CodingDojo> getAll() {
    return service.queryAll();
  }

  @PostMapping("/save")
  public CodingDojo saveMessage(@RequestBody CodingDojo codingDojo) {
    return service.save(codingDojo);
  }

}
