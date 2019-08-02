package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
@Controller
public class CodingDojoController {
  @Autowired CodingDojoService service;

  @GetMapping("/getall")
  public String getAll(Model model) {
    model.addAttribute("list", service.queryAll());
    return "index";
  }

  @PostMapping("/save")
  public String saveMessage(
      @RequestParam("user") String user,
      @RequestParam("content") String content,
      HttpServletRequest request) {
    CodingDojo codingDojo = new CodingDojo();
    codingDojo.setUser(user);
    codingDojo.setIp(request.getRemoteAddr());
    service.save(codingDojo);
    return "index";
  }


    @GetMapping("/getImage")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
      try(InputStream is = this.getClass().getResourceAsStream("/image.png");
          OutputStream os = response.getOutputStream()) {

        response.setContentType("image/png");
        response.setContentLength(IOUtils.copy(is, os));

      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
    }

}
