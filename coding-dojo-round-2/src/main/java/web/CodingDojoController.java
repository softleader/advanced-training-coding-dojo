package web;

import excelEntity.ExcelUploadDto;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class CodingDojoController {

  @GetMapping
  public ModelAndView index(ModelAndView modelAndView) {
    modelAndView.setViewName("index");
    return modelAndView;
  }

  @PostMapping("/upload")
  public ResponseEntity<ExcelUploadDto> FileBatchUpload(
      @PathVariable("id") String id, @RequestParam final MultipartFile file)
      throws IOException, InvalidFormatException {
    //        ResponseEntity<ResponseDetails<ExcelUploadDto>> result =
    // uploadService.fileBatchUpload(id, "GE", file,null);
    return null;
  }
}
