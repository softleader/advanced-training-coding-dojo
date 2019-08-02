package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
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
  public List<CodingDojo> getAll(Model model) {

    model.addAttribute("list", service.queryAll());
    return service.queryAll();
  }

  @PostMapping("/save")
  public String saveMessage(@RequestBody CodingDojo form, HttpRequest httpRequest) {
    form.setIp(httpRequest.getHeaders().toString());
    service.save(form);
    return "/";
  }
}
