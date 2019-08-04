package com.samshih.codingdojolab.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {
  @Id
  @GeneratedValue
  private Long id;
  private String ip;
  private String userName;
  private String content;
  private LocalDateTime createDateTime = LocalDateTime.now();
}
