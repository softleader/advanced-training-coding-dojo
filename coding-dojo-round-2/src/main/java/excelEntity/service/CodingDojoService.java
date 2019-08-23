package excelEntity.service;

import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import excelEntity.entity.ExcelUpload;

public class CodingDojoService {

	public List<ExcelUpload> dataUpload(MultipartFile file) {
		List<ExcelUpload> excelUploadList = Lists.newArrayList();
		
		Workbook workbook = null;
		Sheet insuredSheet = null;


		return excelUploadList;
	}
}
