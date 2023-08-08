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

@RestController @RequestMapping("/coupon")
public class CouponController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired CouponDAO dao;
	
	
	@RequestMapping(value = "/load" , produces = "text/html;charset=utf-8")
	public String login(String member_no, String coupon_status) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("member_no", member_no);
		params.put("coupon_status", coupon_status);
		List<CouponVO> vo = dao.load(params);
		return new Gson().toJson(vo);
	}
	@RequestMapping(value = "/register", produces = "text/html;charset=utf-8")
	public String register(String member_no, String coupon_no, String coupon_status) {
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("member_no", member_no);
	    params.put("coupon_no", coupon_no);
	    params.put("coupon_status", coupon_status); // Add this line to include coupon_status parameter
	    CouponVO vo = dao.register(params);
	    return new Gson().toJson(vo);
	}

}
