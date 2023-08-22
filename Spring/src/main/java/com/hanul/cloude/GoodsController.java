package com.hanul.cloude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import goods.GoodsOptionVO;
import goods.GoodsVO;

@RestController @RequestMapping("/goods")
public class GoodsController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	
	@RequestMapping(value = "/categorylist" , produces = "text/html;charset=utf-8")
	public String categorylist(int goods_middle_category) {
		List<GoodsVO> list = sql.selectList("goods.list", goods_middle_category);
		 return new Gson().toJson(list);
	}

	@RequestMapping(value = "/stylelist" , produces = "text/html;charset=utf-8")
	public String stylelist(int goods_style) {
		List<GoodsVO> list = sql.selectList("goods.stylelist" , goods_style);
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/subcategorylist" , produces = "text/html;charset=utf-8")
	public String subcategorylist(@RequestParam("goods_middle_category") int goods_middle_category,@RequestParam("goods_sub_category") int goods_sub_category) {
		  HashMap<String, Integer> params = new HashMap<String, Integer>();
		    params.put("goods_middle_category", goods_middle_category);
		    params.put("goods_sub_category", goods_sub_category);
		    List<GoodsVO> list = sql.selectList("goods.subcategorylist", params);
		return new Gson().toJson(list);
	}
	
	
	@RequestMapping(value = "/goodsboard" , produces = "text/html;charset=utf-8")
	public String goodsboard(int goods_no) {
		System.out.println(goods_no);
		List<GoodsVO> list = sql.selectList("goods.goodsboard" , goods_no); 
		return new Gson().toJson(list);
	}
	
	
	
	
	
}
