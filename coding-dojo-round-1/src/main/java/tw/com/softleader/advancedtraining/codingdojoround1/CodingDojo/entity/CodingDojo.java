package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
  
  @JsonManagedReference
  @OneToMany(mappedBy = "codingDojo")
  private List<ReplyMessage> replyMessages;
}
