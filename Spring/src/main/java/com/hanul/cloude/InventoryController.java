package com.hanul.cloude;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import coupon.CouponDAO;
import coupon.CouponVO;

@RestController @RequestMapping("/inventory")
public class InventoryController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired CouponDAO dao;
	
	@RequestMapping(value = "/check" , produces = "text/html;charset=utf-8")
	public String login(String member_no, String coupon_status) {
		HashMap<String, String> params = new HashMap<String, String>();

		List<CouponVO> vo = dao.load(params);
		return new Gson().toJson(vo);
	}
}
