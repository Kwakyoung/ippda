package com.hanul.cloude;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;

import goods.GoodsDAO;
import goods.GoodsVO;
import member.MemberDAO;
import member.MemberService;
import member.MemberVO;

@Controller
public class HomeController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired GoodsDAO dao ;
	
	
	
		//오류처리
		@RequestMapping("/error")
		public String error(HttpSession session, HttpServletRequest request, Model model) {
			session.setAttribute("category", "error");
			//header,footer없이
			//Object --> Integer --> int
			int code = (Integer)request.getAttribute("javax.servlet.error.status_code"); //오류코드
			model.addAttribute("code", code);
			model.addAttribute("method", request.getMethod());
			//오류내용:500
			if( code==500 ) {
				Throwable exception 
					= (Throwable)request.getAttribute("javax.servlet.error.exception");
				model.addAttribute("error", exception.getMessage());
			}
			
			return "default/error/" + (code==404 ? 404 : "common");
		}
	
		
	@ResponseBody @RequestMapping("/test")
	public String test() {
		int test = sql.selectOne("customer.mapper.test");
		System.out.println(test);
		return new Gson().toJson(test);
	}
	
	@RequestMapping("/insert")
	public void insert(GoodsVO vo) {
		dao.insert(vo);
	}
	
	@RequestMapping(value = "/list" , produces = "text/html;charset=utf-8")
	public String list() {
		List<GoodsVO> list = sql.selectList("customer.mapper.list");
		 return new Gson().toJson(list);
	}
	
	
	@Autowired MemberDAO dao1;
	
	// 로그인처리 요청
		@RequestMapping( value="/smartLogin")
		public String login(String member_id, String member_pw
				, HttpSession session
				, RedirectAttributes redirect) {
			
			//화면에서 입력한 아이디, 비번이 일치하는 회원정보가 DB에 있는지 확인
			//입력한 아이디에 해당하는 회원정보 조회
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("member_id", member_id);
			params.put("member_pw", member_pw);
			MemberVO vo = dao1.login(params);
			
			boolean match = false;
			if( vo != null ) { //아이디가 일치하는 회원정보가 있고
				member_pw = vo.getMember_pw(); // 비번일치여부 확인
			}
			if( match ) {
				session.setAttribute("loginInfo", vo);  //세션에 로그인한 회원정보 담기
				return "";
				
			}else {
				redirect.addFlashAttribute("fail", true );
				return "redirect:login"; //로그인화면 다시 요청
			}
		}
	
	
	// 로그인화면 요청
	@RequestMapping("/login")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		return "default/member/login";
	}
	
	
	
	
	// 회원가입 화면
	@RequestMapping("/register")
	public String register() {
		return "member/register";
	}
	
	
	// 홈화면 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session ) {
		
		String test = "ab12cA";
		System.out.println( Pattern.compile("[0-9]").matcher(test).find() );
		System.out.println( Pattern.compile("[a-zA-Z]").matcher(test).find() );
		
		session.setAttribute("now", new java.util.Date().getTime());
		//session.setAttribute("category", "");
		session.removeAttribute("category");
		return "home";
	}
	
	
	
}
