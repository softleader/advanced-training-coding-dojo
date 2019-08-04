package com.samshih.codingdojolab.entity;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Message {

  @Id @GeneratedValue private Long id;
  private String ip;
  private String userName;
  private String content;
  private LocalDateTime createDateTime = LocalDateTime.now();
  @Lob private Byte[] image;

  @OneToMany(targetEntity = Reply.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @OrderBy("createDateTime ASC")
  private List<Reply> reply = new ArrayList<>();
}
