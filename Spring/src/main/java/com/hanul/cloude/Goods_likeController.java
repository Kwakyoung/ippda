package com.hanul.cloude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import goods.GoodsVO;
import goods_like.Goods_likeDAO;
import goods_like.Goods_likeVO;
import goods_option.GoodsBoardBuyCheckDTO;
import member.MemberVO;
import order_ing.Order_ingDAO;
import order_ing.Order_ingVO;
import review.ReviewVO;


@RestController @RequestMapping("/goods_like")
public class Goods_likeController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired Goods_likeDAO dao;
	
	@RequestMapping(value = "/list" , produces = "text/html;charset=utf-8")
	public String list(String member_no, String goods_no) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("member_no", member_no);
		params.put("goods_no", goods_no);
		List<Goods_likeVO> vo = dao.list(params);
		return new Gson().toJson(vo);
	}

	@RequestMapping(value = "/add", produces = "text/html;charset=utf-8")
	public void insert(Goods_likeVO vo) {
		dao.add(vo);
	}
	@RequestMapping(value = "/delete", produces = "text/html;charset=utf-8")
	public void Delete(String member_no, String goods_no) {
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("member_no", member_no);
	    params.put("goods_no", goods_no);
	    dao.delete(params);
	}
	@RequestMapping(value = "/alllist" , produces = "text/html;charset=utf-8")
	public String allist(String member_no) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("member_no", member_no);
		List<Goods_likeVO> vo = dao.alllist(params);
		return new Gson().toJson(vo);
	}
}
