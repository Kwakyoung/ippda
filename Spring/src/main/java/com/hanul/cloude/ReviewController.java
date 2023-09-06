package com.hanul.cloude;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.json.Json;
import com.google.gson.Gson;

import review.ReviewVO;

@RestController @RequestMapping("/review")
public class ReviewController {

	
	@Autowired
	@Qualifier("ippda") SqlSession sql;
	
	@RequestMapping( value = "/insert" , produces = "text/html;charset=utf-8")
	public void insert(@ModelAttribute ReviewVO vo) {
		sql.insert("review.insert", vo);
	}
	
	
	@RequestMapping( value = "/list" , produces = "text/html;charset=utf-8")
	public String insert(int goods_no) {
		
		List<ReviewVO> list  = sql.selectList("review.list" , goods_no);
		
		return new Gson().toJson(list);
	}
	
	//리뷰갯수
	@RequestMapping( value = "/count" , produces = "text/html;charset=utf-8")
	public String count(int goods_no) {
		
		int reviewCnt = sql.selectOne("review.count", goods_no);
		
		return new Gson().toJson(reviewCnt);
	}
	
	//평점 평균
	@RequestMapping( value = "/rating" , produces = "text/html;charset=utf-8")
	public String rating(int goods_no) {
		
		int reviewCnt = sql.selectOne("review.rating", goods_no);
		
		return new Gson().toJson(reviewCnt);
	}
	
	
	
}
