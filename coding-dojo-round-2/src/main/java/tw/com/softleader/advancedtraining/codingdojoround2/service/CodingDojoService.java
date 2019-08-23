package tw.com.softleader.advancedtraining.codingdojoround2.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import tw.com.softleader.advancedtraining.codingdojoround2.entity.ExcelUpload;

public class CodingDojoService {

	private ExcelUpload ExcelUpload;

	public List<ExcelUpload> dataUpload(MultipartFile file) {


		List<ExcelUpload> excelUploads ;
		List<ExcelUpload> excelUploadList = Lists.newArrayList();

		try(InputStream in = file.getInputStream()) {
			HSSFWorkbook wb = new HSSFWorkbook(in);
			HSSFSheet sheet = wb.getSheetAt(0);
			for (int i=0 ; i < sheet.getLastRowNum() ; ++i) {
//			  private Long id;
//
//			  private String word;
//
//			  private Integer number;
//
//			  private Double doubleNumber;
//
//			  private LocalDateTime time;
//
//			  private LocalDateTime timeWithMD;
//
//			  private LocalDateTime timeWithMDHS;
				ExcelUpload excelUpload = new ExcelUpload();
				HSSFRow row = sheet.getRow(i);
				ExcelUpload excelRow = new ExcelUpload();
				excelUpload.setWord(row.getCell(0).getStringCellValue());
				excelUpload.setNumber(Integer.valueOf(row.getCell(1).getStringCellValue()));
				excelUpload.setDoubleNumber(row.getCell(2).getNumericCellValue());
				row.getCell(3).getStringCellValue(); //時間
				row.getCell(4).getStringCellValue(); //日期
				row.getCell(5).getStringCellValue(); //localDateTime
				
				
				

			}
		} catch (IOException e) {
			e.printStackTrace();
		}



		return excelUploadList;
	}


}
