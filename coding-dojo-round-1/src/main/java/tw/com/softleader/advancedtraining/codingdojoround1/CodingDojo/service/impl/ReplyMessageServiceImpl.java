package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.dao.ReplyMessageDao;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.ReplyMessage;

@Transactional
@Service
public class ReplyMessageServiceImpl {
  
  @Autowired
  private ReplyMessageDao replyDao;
  
  public ReplyMessage getOne(Long id) {
    return replyDao.getOne(id);
  }
  
  public List<ReplyMessage> queryByCodingDojo(Long id){
    return replyDao.findByCodingDojoIdOrderByCreatTimeAsc(id);
  }
  
  public ReplyMessage save(ReplyMessage replyMessage) {
    return replyDao.save(replyMessage);
  }
  
}
