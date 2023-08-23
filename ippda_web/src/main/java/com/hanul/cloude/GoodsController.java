package com.hanul.cloude;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/goods")
public class GoodsController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;

	
	@RequestMapping("/insert")
	public String insert() {
		
		
		return"goods/insert";
	}
	
	
}