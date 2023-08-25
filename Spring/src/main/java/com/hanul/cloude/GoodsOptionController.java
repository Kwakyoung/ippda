package com.hanul.cloude;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
	
import goods_option.Goods_optionDAO;
import goods_option.Goods_optionVO;

@RestController @RequestMapping("/goods_option")
public class GoodsOptionController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired Goods_optionDAO dao;
	
	

	
	@RequestMapping(value = "/check_size" , produces = "text/html;charset=utf-8")
	public String check_size(String goods_size, String goods_no) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("goods_no", goods_no);
		params.put("goods_size", goods_size);
		List<Goods_optionVO> vo = dao.check_size(params);
		return new Gson().toJson(vo);
	}

}
