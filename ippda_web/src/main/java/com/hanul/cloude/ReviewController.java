package com.hanul.cloude;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.PageVO;
import member.MemberVO;

@Controller @RequestMapping("/review")
public class ReviewController {
	
@Autowired @Qualifier("ippda") SqlSession sql;
	
	@RequestMapping("/list")
	public String reviewList(HttpSession session, Model model, PageVO page) {//int store_no
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("store_no", 1); //member.getStore_no()
		map.put("page", page);
		int totalList = sql.selectOne("review.total", 1);
		page.setTotalList(totalList) ; // member.getStore_no()
		page.setList( sql.selectList("review.list", map) );
		model.addAttribute("page", page); 
		
		
		return "review/list";
	}
	
	
}
