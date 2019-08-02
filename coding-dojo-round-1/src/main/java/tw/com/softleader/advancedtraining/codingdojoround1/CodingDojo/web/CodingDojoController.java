package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
public class CodingDojoController {
  @Autowired CodingDojoService service;

  @GetMapping("/getall")
  public List<CodingDojo> getAll(Model model) {

    model.addAttribute("list", service.queryAll());
    return service.queryAll();
  }

  @PostMapping("/save")
  public String saveMessage(
      @RequestParam("user") String user,
      @RequestParam("content") String content,
      HttpRequest httpRequest) {
//    form.setIp(httpRequest.getHeaders().toString());
    CodingDojo codingDojo = new CodingDojo();
    codingDojo.setUser(user);
//    service.save(form);
    return "/";
  }


    @GetMapping("/getImage")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

      response.setContentType("image/png");

      //ServletContext sc = getServletContext();
      ServletContext sc = null;
      InputStream is = sc.getResourceAsStream("images/mushroom.png");

      BufferedImage bi = ImageIO.read(is);
      OutputStream os = response.getOutputStream();
      ImageIO.write(bi, "png", os);
    }

}
