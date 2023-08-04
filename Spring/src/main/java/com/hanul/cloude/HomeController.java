package com.hanul.cloude;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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
import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;

@RestController
public class HomeController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	
	@RequestMapping("/test")
	public String test() {
		int test = sql.selectOne("customer.mapper.test");
		System.out.println(test);
		return new Gson().toJson(test);
	}
	
	
	
	
	@Autowired MemberDAO dao;
	@RequestMapping(value = "/member" , produces = "text/html;charset=utf-8")
	public String list() {
		MemberVO vo = dao.list();
		return new Gson().toJson(vo);
	}
	
	
	
}
