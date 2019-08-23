package tw.com.softleader.advancedtraining.codingdojoround2;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Hashtable;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Controller
public class UploadController {

  public static volatile Hashtable<String, UploadStatus> result = new Hashtable<>();

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/upload/{id}")
  @ResponseBody
  public UploadStatus getUpload(@PathVariable String id) {
    return result.get(id);
  }

  @PostMapping("/upload")
  @ResponseBody
  public UploadStatus upload(@RequestParam MultipartFile file) throws Exception {

    String id = UUID.randomUUID().toString();
    UploadStatus status = new UploadStatus(id, 0, 0, false);
    result.put(id, status);

    try(Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
      Sheet sheet = workbook.getSheetAt(0);
      int lastRowNum = sheet.getLastRowNum();
      status.setTotal(lastRowNum);

      CompletableFuture.runAsync(() -> {
        for(int i = 1; i < lastRowNum; i++) {
          UploadFile uploadFile = new UploadFile(sheet.getRow(i));
          System.out.println(uploadFile);
          status.setProcess(i);
        }
        status.setComplete(true);
      });

      return status;
    }
  }

}
