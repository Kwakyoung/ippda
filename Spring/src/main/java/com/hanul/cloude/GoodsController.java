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
	public String categorylist(int GOODS_MIDDLE_CATEGORY) {
		List<GoodsVO> list = sql.selectList("goods.list", GOODS_MIDDLE_CATEGORY);
		 return new Gson().toJson(list);
	}

	@RequestMapping(value = "/stylelist" , produces = "text/html;charset=utf-8")
	public String stylelist(int GOODS_STYLE) {
		List<GoodsVO> list = sql.selectList("goods.stylelist" , GOODS_STYLE);
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/subcategorylist" , produces = "text/html;charset=utf-8")
	public String subcategorylist(@RequestParam("GOODS_MIDDLE_CATEGORY") int GOODS_MIDDLE_CATEGORY,@RequestParam("GOODS_SUB_CATEGORY") int GOODS_SUB_CATEGORY) {
		  HashMap<String, Integer> params = new HashMap<String, Integer>();
		    params.put("GOODS_MIDDLE_CATEGORY", GOODS_MIDDLE_CATEGORY);
		    params.put("GOODS_SUB_CATEGORY", GOODS_SUB_CATEGORY);
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
