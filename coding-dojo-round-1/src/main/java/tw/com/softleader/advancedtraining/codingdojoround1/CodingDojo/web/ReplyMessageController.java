package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.ReplyMessage;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.impl.ReplyMessageServiceImpl;

@RestController
@RequestMapping("/reply")
public class ReplyMessageController {
  
  @Autowired
  private ReplyMessageServiceImpl replyService;
  
  @PostMapping("/find-by-message")
  private List<ReplyMessage> findByMessage(@RequestBody CodingDojo codingDojo){
    return replyService.queryByCodingDojo(codingDojo.getId());
  }
  
  @PostMapping("/save")
  private ReplyMessage save(@RequestBody ReplyMessage replyMessage){
    return replyService.save(replyMessage);
  }
  
  
  
}
