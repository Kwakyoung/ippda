package com.hanul.cloude;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import data.DataDAO;



@Controller @RequestMapping("/data")
public class DataController {
	
	@Autowired private DataDAO dao;
	
	@RequestMapping("/list")
	public String basicinfo() {
	
		return"data/list";
	}
	
	
	@ResponseBody
	@RequestMapping("/sell/month")
	public Object hirement_month() {
		
		return dao.data_month();
	}
	
	@ResponseBody
	@RequestMapping("/sell/year")
	public Object hirement_year() {
		
		return dao.data_year();
	}
}
