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
import inventory.InventoryDAO;
import inventory.InventoryVO;

@RestController @RequestMapping("/inventory")
public class InventoryController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired InventoryDAO dao;
	
	
	@RequestMapping(value = "/check_color" , produces = "text/html;charset=utf-8")
	public String check_color(String goods_color, String goods_no) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("goods_no", goods_no);
		params.put("goods_color", goods_color);
		List<InventoryVO> vo = dao.check_color(params);
		return new Gson().toJson(vo);
	}
	
	@RequestMapping(value = "/check_size" , produces = "text/html;charset=utf-8")
	public String check_size(String goods_size, String goods_no) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("goods_no", goods_no);
		params.put("goods_size", goods_size);
		List<InventoryVO> vo = dao.check_size(params);
		return new Gson().toJson(vo);
	}
	@RequestMapping(value = "/check" , produces = "text/html;charset=utf-8")
	public String check_check(String goods_no) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("goods_no", goods_no);
		List<InventoryVO> vo = dao.check(params);
		return new Gson().toJson(vo);
	}
}
