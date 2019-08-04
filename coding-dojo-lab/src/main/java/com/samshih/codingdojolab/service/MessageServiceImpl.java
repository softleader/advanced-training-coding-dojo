package com.samshih.codingdojolab.service;

import com.samshih.codingdojolab.dao.MessageDao;
import com.samshih.codingdojolab.entity.Message;
import com.samshih.codingdojolab.entity.Reply;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {

  private final MessageDao messageDao;

  @Autowired
  public MessageServiceImpl(MessageDao messageDao) {
    this.messageDao = messageDao;
  }

  public void saveMessage(Message message) {
    messageDao.save(message);
  }

  public List<Message> getAllMessage() {
    return messageDao.findAllByOrderByCreateDateTimeDesc();
  }

  public void updateReply(Long id, Reply reply) {
    Message messageDb =
        messageDao.findById(id).orElseThrow(() -> new RuntimeException("找不到id為" + id + "的Message"));
    messageDb.getReply().add(reply);
    messageDao.flush();
    messageDao.save(messageDb);
  }
}
