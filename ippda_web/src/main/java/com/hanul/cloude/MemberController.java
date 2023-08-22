package com.hanul.cloude;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import member.MemberDAO;
import member.MemberVO;


@Controller
public class MemberController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	
	
	@Autowired private MemberDAO service;
		
	// 로그인처리 요청
		@RequestMapping( value="/smartLogin")
		public String login(String member_id, String member_pw) {
						
			MemberVO vo = service.member_info(member_id);
			if() {
				return "home/sales";
			}else {
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
			return "default/member/register";
		}
		
		
}
