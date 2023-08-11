package com.hanul.cloude;

import java.util.HashMap;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;
import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

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
	
	@RequestMapping(value = "/insert" , produces = "text/html;charset=utf-8")
	public void insert(MemberVO vo) {
		sql.insert("member.join", vo);
	}
	
	
	@RequestMapping("idcheck")
	public String idcheck(String member_id) {
		MemberVO vo = dao.idcheck(member_id);
		return new Gson().toJson(vo);
	}
	
	@RequestMapping(value="/sendSms", produces = "text/html;charset=utf-8")
	public String sendSms(String phoneNumber) {
		
		Random random = new Random();		//랜덤 함수 선언
		int createNum = 0;  			//1자리 난수
		String ranNum = ""; 			//1자리 난수 형변환 변수
		String resultNum = "";  		//결과 난수
		
		for (int i=0; i<6; i++) { 
			createNum = random.nextInt(9);		//0부터 9까지 올 수 있는 1자리 난수 생성
			ranNum =  Integer.toString(createNum);  //1자리 난수를 String으로 형변환
			resultNum += ranNum;			//생성된 난수(문자열)을 원하는 수(	letter)만큼 더하며 나열
		}	
		
		final String APIKEY = "NCSCTZA8YMURWIAC";
		final String APISECRET = "CKZVCPVIKL1I6BSISLDIH9BLTCVR7UNO";
		
		Message sms = new Message(APIKEY, APISECRET);
		
		HashMap<String, String> params = new HashMap();
		params.put("to", "01034481720");
		params.put("from", "01025407141");
		params.put("type", "SMS"); //SMS, LMS, MMS ...
		params.put("text", "IPPDA 인증번호\n["+resultNum+"]");
		params.put("app_version", "JAVA SDK v1.2");
		
		try {
			return resultNum;
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		}
	}
}
