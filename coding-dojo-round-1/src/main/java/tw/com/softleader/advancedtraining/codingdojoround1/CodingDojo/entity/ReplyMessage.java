package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ReplyMessage {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @JsonBackReference
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="CODING_DOJO_ID")
  private CodingDojo codingDojo;
  
  private Long replySeqNo = 0L;
  
  private String replyUser;

  private String replyContent;

  private LocalDateTime creatTime = LocalDateTime.now();

  private String replyIp;
}
