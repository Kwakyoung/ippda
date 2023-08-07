package com.hanul.cloude;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;

@RestController @RequestMapping("/member")
public class MemeberController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired MemberDAO dao;
	
	
	@RequestMapping(value = "/login" , produces = "text/html;charset=utf-8")
	public String login(String member_id, String member_pw) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("member_id", member_id);
		params.put("member_pw", member_pw);
		MemberVO vo = dao.login(params);
		return new Gson().toJson(vo);
	}
}
