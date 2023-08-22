package com.hanul.cloude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
@RequestMapping("/member")
public class MemeberController {
	
	
	@Autowired
	@Qualifier("ippda")
	SqlSession sql;
	@Autowired
	MemberDAO dao;

	@RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
	public String login(String member_id, String member_pw) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("member_id", member_id);
		params.put("member_pw", member_pw);
		MemberVO vo = dao.login(params);
		return new Gson().toJson(vo);
	}

	@RequestMapping(value = "/insert", produces = "text/html;charset=utf-8")
	public void insert(MemberVO vo) {
		sql.insert("member.join", vo);
	}

	@RequestMapping("idcheck")
	public String idcheck(String member_id) {
		MemberVO vo = dao.idcheck(member_id);
		return new Gson().toJson(vo);
	}

	
	@RequestMapping("check")
	public String check(MemberVO vo) {
		return new Gson().toJson(dao.check(vo));
	}
	
	@RequestMapping("order")
	public String order(MemberVO vo) {
		return new Gson().toJson(dao.order(vo));
	}
	
	
	@RequestMapping(value = "/findid", produces = "text/html;charset=utf-8")
	public String findid(MemberVO vo) {
		MemberVO vo1 = dao.findid(vo);
		return new Gson().toJson(vo1);
	}
	
	
	
	@RequestMapping(value = "/resetPw", produces = "text/html;charset=utf-8")
	public String resetPassword(MemberVO vo) {
		return new Gson().toJson(dao.resetPw(vo));
	}

	
	
	@RequestMapping(value = "/sms", produces = "text/html;charset=utf-8")
	public String sendSms(String phoneNum) {

		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		String resultNum = "";

		for (int i = 0; i < 6; i++) {
			createNum = random.nextInt(9);
			ranNum = Integer.toString(createNum);
			resultNum += ranNum;
		}

		final String APIKEY = "NCSG2LLRPF6C8E0W";
		final String APISECRET = "RT7T0LQHVFECZ5LD09VOD7TB8SK9RKE5";

		DefaultMessageService messageService = NurigoApp.INSTANCE.initialize(APIKEY, APISECRET,
				"https://api.solapi.com");
		Message message = new Message();
		message.setFrom("01034481720");
		message.setTo(phoneNum);
		message.setText("인증번호는 [" + resultNum + "] 입니다.");

		try {
			// send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
			messageService.send(message);
		} catch (NurigoMessageNotReceivedException exception) {
			// 발송에 실패한 메시지 목록을 확인할 수 있습니다!
			System.out.println(exception.getFailedMessageList());
			System.out.println(exception.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		return resultNum;
	}

	
	@RequestMapping(value = "/address" , produces = "text/html;charset=utf-8")
	public String address(int member_no) {
		String address = sql.selectOne("member.address", member_no);
		return new Gson().toJson(address);
	}
	
	
	@RequestMapping(value = "/charge" , produces = "text/html;charset=utf-8")
	public void charge(MemberVO vo) {
		sql.update("member.charge", vo);
	}
	
	@RequestMapping(value = "/money" , produces = "text/html;charset=utf-8")
	public String money(int member_no) {
		int money = sql.selectOne("member.money", member_no);
		return new Gson().toJson(money);
	}
	
	@RequestMapping(value = "/payment" , produces = "text/html;charset=utf-8")
	public void payment(MemberVO vo) {
		sql.update("member.payment", vo);
	}
	
	
	
	
}
