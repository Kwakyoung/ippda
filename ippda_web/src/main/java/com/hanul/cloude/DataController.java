package com.hanul.cloude;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller @RequestMapping("/data")
public class DataController {
	
	@RequestMapping("/list")
	public String basicinfo() {
	
		return"data/list";
	}
	

}
