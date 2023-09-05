package com.hanul.cloude;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import store.StoreVO;

@RestController @RequestMapping("/store")
public class StoreController {
	
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	
	@RequestMapping(value = "/list" , produces = "text/html;charset=utf-8")
	public String categorylist() {
		List<StoreVO> list = sql.selectList("store.list");
		 return new Gson().toJson(list);
	}

}
