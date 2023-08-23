package com.hanul.cloude;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Controller
public class HomeController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	
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
	
	
	// 홈화면 
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String home(Locale locale, Model model, HttpSession session ) {
			
			session.setAttribute("now", new java.util.Date().getTime());
			//session.setAttribute("category", "");
			session.removeAttribute("category");
			return "home";
		}
	
		
	
	
}
