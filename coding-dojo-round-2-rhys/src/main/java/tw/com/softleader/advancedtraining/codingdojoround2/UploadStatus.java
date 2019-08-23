package tw.com.softleader.advancedtraining.codingdojoround2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadStatus {

  String id;
  int process;
  int total;
  boolean complete = false;

}
