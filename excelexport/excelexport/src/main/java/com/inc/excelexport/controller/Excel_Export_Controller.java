package com.inc.excelexport.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inc.excelexport.service.Emp_Serv;

@RestController
public class Excel_Export_Controller {
	@Autowired
	private Emp_Serv serv;

	@GetMapping("/getexcel")
	public void generateExcel(HttpServletResponse response) throws IOException {

		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=Emp_List.xls";

		response.setHeader(headerKey, headerValue);

		serv.generateExcelServ(response);
	}
}
