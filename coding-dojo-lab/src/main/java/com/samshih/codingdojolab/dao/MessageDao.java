package com.samshih.codingdojolab.dao;

import com.samshih.codingdojolab.entity.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<Message, Long> {
  List<Message> findAllByOrderByCreateDateTimeDesc();
}
