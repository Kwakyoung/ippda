package com.hanul.cloude;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import goods.GoodsVO;
import member.MemberVO;

@Controller @RequestMapping("/test")
public class TestController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	
		
	@RequestMapping("/home")
	public String home(HttpSession session ,Model model) {
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		System.out.println(loginInfo);
//		model.addAttribute("loginInfo", vo);
		return "test/home";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GoodsVO vo) {
		sql.insert("goods.insert" , vo);
		return "redirect:/test/home";
	}


}
