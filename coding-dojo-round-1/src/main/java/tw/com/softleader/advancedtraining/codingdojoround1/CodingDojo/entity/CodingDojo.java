package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
public class CodingDojo {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "seqNo")
  private Long seqNo = 0L;

  private String user;

  private String content;

  private LocalDateTime creatTime = LocalDateTime.now();

  private String ip;
}
