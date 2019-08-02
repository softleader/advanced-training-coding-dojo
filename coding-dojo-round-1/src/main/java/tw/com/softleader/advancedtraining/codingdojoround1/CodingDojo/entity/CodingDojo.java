package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CodingDojo {

  private Long id;

  private Long Seq;

  private String user;

  private String content;
}
