package excelEntity.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import excelEntity.entity.ExcelUpload;

public class CodingDojoService {

	public List<ExcelUpload> dataUpload(MultipartFile file) {
		List<ExcelUpload> excelUploadList = Lists.newArrayList();

		try(InputStream in = file.getInputStream()) {
			HSSFWorkbook wb = new HSSFWorkbook(in);
			HSSFSheet sheet = wb.getSheetAt(0);
			for (int i=0 ; i < sheet.getLastRowNum() ; ++i) {
				HSSFRow row = sheet.getRow(i);
				row.getCell(0).getStringCellValue();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}



		return excelUploadList;
	}


}
