package tw.com.softleader.advancedtraining.codingdojoround2;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
public class UploadFile {

  private String s;
  private Integer i;
  private Double d;
  private LocalTime time;
  private LocalDate date;
  private LocalDateTime dateTime;

  public UploadFile(Row row) {
    this.s = row.getCell(0).getStringCellValue();
    this.i = BigDecimal.valueOf(row.getCell(1).getNumericCellValue()).intValue();
    this.d = row.getCell(2).getNumericCellValue();
    this.time = row.getCell(3).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    this.date = row.getCell(3).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    this.dateTime = row.getCell(3).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

}
