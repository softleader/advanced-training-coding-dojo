package excelEntity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ExcelUpload {


  //文字    整數    小數    時間    日期    日期時間
  private Long id;

  private String word;

  private Integer number;

  private Double doubleNumber;

  private LocalDateTime time;

  private LocalDateTime timeWithMD;

  private LocalDateTime timeWithMDHS;

}
