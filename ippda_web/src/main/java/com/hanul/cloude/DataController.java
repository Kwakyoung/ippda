package com.hanul.cloude;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import data.DataDAO;
import data.DataService;



@Controller @RequestMapping("/data")
public class DataController {
	
	@Autowired private DataDAO service;
	
	
	@RequestMapping("/list")
	public String basicinfo() {
	
		return"data/list";
	}
	
	
	@ResponseBody
	@RequestMapping("/sell/month")
	public Object sell_month() {
		return service.sell_month();
	}
	
	@ResponseBody
	@RequestMapping("/sell/mprice")
	public Object mprice() {
		return service.mprice();
	}
}
