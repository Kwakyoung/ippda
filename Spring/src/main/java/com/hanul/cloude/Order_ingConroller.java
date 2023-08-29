package com.hanul.cloude;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


import order_ing.Order_ingDAO;
import order_ing.Order_ingVO;
@RestController @RequestMapping("/order_ing")
public class Order_ingConroller {
	
	@Autowired
	@Qualifier("ippda") SqlSession sql;
	@Autowired Order_ingDAO dao;

	@RequestMapping(value = "/insert", produces = "text/html;charset=utf-8")
	public String Insert(String member_id, String member_pw) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("member_no", member_id);
		params.put("goods_no", member_pw);
		params.put("goods_option_no", member_pw);
		params.put("order_date", member_pw);
		params.put("order_size", member_pw);
		params.put("order_cnt", member_pw);
		params.put("order_status", member_pw);
		params.put("order_color", member_pw);
		
		Order_ingVO vo = dao.Insert(params);
		return new Gson().toJson(vo);
	}
	
	
	
}
