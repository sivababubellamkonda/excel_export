package com.inc.excelexport.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.excelexport.dto.Emp;
import com.inc.excelexport.repo.Emp_Repo;

@Service
public class Emp_Serv {
	@Autowired
	private Emp_Repo repo;

	public void generateExcelServ(HttpServletResponse response) throws IOException {
		List<Emp> listOfEmp = repo.findAll();

		// creating workbook & sheet
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Emp");
		HSSFRow row = sheet.createRow(0);

		// writing Header row
		row.createCell(0).setCellValue("Emp_Id");
		row.createCell(1).setCellValue("Email_Id");
		row.createCell(2).setCellValue("Mobile_no");
		row.createCell(3).setCellValue("Department");
		row.createCell(4).setCellValue("Role");
		row.createCell(5).setCellValue("Org_Name");
		row.createCell(6).setCellValue("Emp_Type");
		row.createCell(7).setCellValue("B_Place");
		row.createCell(8).setCellValue("Address");

		// writing data
		int dataRowIndex = 1;

		for (Emp emp : listOfEmp) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(emp.getEmp_Id());
			dataRow.createCell(1).setCellValue(emp.getEmail_Id());
			dataRow.createCell(2).setCellValue(emp.getMobile_No());
			dataRow.createCell(3).setCellValue(emp.getDepartment());
			dataRow.createCell(4).setCellValue(emp.getRole());
			dataRow.createCell(5).setCellValue(emp.getOrg_Name());
			dataRow.createCell(6).setCellValue(emp.getEmp_Type());
			dataRow.createCell(7).setCellValue(emp.getB_Place());
			dataRow.createCell(8).setCellValue(emp.getAddress());

			dataRowIndex++;
		}
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
	}
}
