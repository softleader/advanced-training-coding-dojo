package com.samshih.codingdojolab.controller;

import com.samshih.codingdojolab.entity.Message;
import com.samshih.codingdojolab.entity.Reply;
import com.samshih.codingdojolab.service.MessageServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
  private final String REST_USER = "/user";
  private final MessageServiceImpl messageService;

  @Autowired
  public MessageController(MessageServiceImpl messageService) {
    this.messageService = messageService;
  }

  @PostMapping(REST_USER)
  public ResponseEntity<?> saveMessage(
      @RequestBody Message message, HttpServletRequest httpServletRequest) {
    message.setIp(httpServletRequest.getRemoteAddr());
    try {
      messageService.saveMessage(message);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    return ResponseEntity.ok().build();
  }

  @GetMapping(REST_USER)
  public ResponseEntity<List<Message>> getAllMessage() {
    List<Message> allMessage = messageService.getAllMessage();
    if (allMessage.size() == 0) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(allMessage);
  }

  @PutMapping(REST_USER + "/{id}")
  public ResponseEntity<?> saveReply(
      @PathVariable Long id, @RequestBody Reply reply, HttpServletRequest httpServletRequest) {
    reply.setIp(httpServletRequest.getRemoteAddr());
    try {
      messageService.updateReply(id, reply);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    return ResponseEntity.ok().build();
  }
}
