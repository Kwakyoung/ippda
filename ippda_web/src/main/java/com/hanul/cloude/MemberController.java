package com.hanul.cloude;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Controller
@SessionAttributes("foundId")
public class MemberController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired MemberDAO dao;
	
		@RequestMapping("ippdaLogin")
		@ResponseBody // 결과를 문자열로 반환
		public String admin(HttpSession session, String store_id, String store_pw) {
		    HashMap<String, String> params = new HashMap<String, String>();
		    params.put("store_id", store_id);
		    params.put("store_pw", store_pw);
		    MemberVO vo = dao.login(params);
		    if (vo == null) {
		        return "failure"; // 로그인 실패 시
		    } else {
		    	session.setAttribute("loginInfo", vo);
		    	return "success"; // 로그인 성공 시 (관리자)
		    }
	
	
//		// 로그인 처리
//		@RequestMapping(value = "/ippdaLogin", produces = "text/html;charset=utf-8")
//		public String login(String store_id, String store_pw, HttpSession session) {
//			HashMap<String, String> params = new HashMap<String, String>();
//			params.put("store_id", store_id);
//			params.put("store_pw", store_pw);
//			MemberVO vo = dao.login(params);
//	
//			
//			if(vo==null) {
//				return "redirect:/login";
//			}else {
//				session.setAttribute("loginInfo", vo);
//					
//				return "redirect:/sales";
//			}
			
			
		}
		
		
		
			
		// 로그인화면 요청
		@RequestMapping("/login")
		public String login(HttpSession session) {
			session.setAttribute("category", "login");
			return "default/member/login";
		}
		
		

		//로그아웃 처리 요청
		@RequestMapping("/logout")
		public String logout(HttpSession session, HttpServletRequest request) {
			MemberVO login = (MemberVO)session.getAttribute("loginInfo");
			session.removeAttribute("loginInfo");
			
				return "redirect:/";
		}
		
		
		
		//회원가입 화면 요청
		@RequestMapping("/join")
		public String join(HttpSession session) {
			session.setAttribute("category", "join");
			return "default/member/join";
		}
		
		
		//회원가입 처리 요청
		@ResponseBody
		@RequestMapping(value="/register", produces="text/html; charset=utf-8")
		public String join(MemberVO vo, HttpSession session) {
			dao.member_join(vo);
			session.setAttribute("loginInfo", vo);
			return "success";
		}
		
		
		// 아이디 찾기 화면
		@RequestMapping("/findid")
		public String findid() {
			return "default/member/findid";
		}
		
		
		// 아이디 중복체크
		@RequestMapping("/idcheck")
		@ResponseBody
		public String idcheck(String store_id) {
			MemberVO vo = dao.idcheck(store_id);
			if(vo==null) {
				return "success"; // 사용 가능
			}else {
				return "failure"; // 있는 아이디
			}
		}
		
		
		
		@RequestMapping("findingid")
		@ResponseBody // 결과를 문자열로 반환
		public String findingid(String store_ceo, String store_phone, Model model) {
		    HashMap<String, String> params = new HashMap<String, String>();
		    params.put("store_ceo", store_ceo);
		    params.put("store_phone", store_phone);
		    MemberVO vo = dao.findid(params);
		    

		    if (vo != null) {
		    	model.addAttribute("foundId", vo.getStore_id());
		        return "success"; 
		    } else {
		    	return "failure"; 
		    }
		}
		
		
		// 아이디 찾기 화면
		@RequestMapping(value = "/findidresult", produces = "text/html;charset=utf-8")
		public String findidresult(Model model) {
			String foundId = (String) model.getAttribute("foundId");
		    model.addAttribute("foundId", foundId);
			return "default/member/findidresult";
		}
		
		
		
		// 휴대폰 인증문자 전송
		@RequestMapping(value = "sms")
		@ResponseBody 
		public Map<String, String> sendSms(String store_phone) {

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
			message.setTo(store_phone);
			message.setText("인증번호는 [" + resultNum + "] 입니다.");
			
			try {
				// send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
				messageService.send(message);
				System.out.println(" 인증번호는 : " + resultNum);
			} catch (NurigoMessageNotReceivedException exception) {
				// 발송에 실패한 메시지 목록을 확인할 수 있습니다!
				System.out.println(exception.getFailedMessageList());
				System.out.println(exception.getMessage());
				
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
				System.out.println(" 인증번호는 : " + resultNum);
			}
			
			HashMap<String, String> response = new HashMap();
			response.put("result", "success");
			response.put("Code", resultNum);
			
			return response;
		}
		

		
		
		// 비밀번호 찾기 화면
		@RequestMapping("/findpw")
		public String findpw() {
			return "default/member/findpw";
		}
		
		
		@RequestMapping("findingpw")
		@ResponseBody 
		public String findingpw(String store_id, String store_phone, Model model) {
		    HashMap<String, String> params = new HashMap<String, String>();
		    params.put("store_id", store_id);
		    params.put("store_phone", store_phone);
		    MemberVO vo = dao.findpw(params);
		    
		    if (vo == null) {
		        return "failure"; // 정보틀림
		    } else {
		    	model.addAttribute("foundId", vo.getStore_id());
		    	return "success"; // 정보맞음
		    }
		}
		
		
		
		// 비밀번호 수정 화면
		@RequestMapping(value = "/findpwresult", produces = "text/html;charset=utf-8")
		public String findpwresult(Model model) {
			
			return "default/member/findpwresult";
		}
		
		
		@RequestMapping("changePw")
		public String changePw(MemberVO vo, @RequestParam("store_id") String storeId) {
			vo.setStore_id(storeId);
			dao.member_resetPassword(vo);
			return "redirect:/login";
		}
		
		
//		//새비밀번호 변경저장 처리 요청
//		@ResponseBody @RequestMapping("/updatePassword")
//		public boolean update(MemberVO vo) {
//			//화면에서 입력한 새 비밀번호가 DB에 변경저장
//			vo.setStore_pw(vo.getStore_pw());
//			return service.member_resetPassword(vo)==1 ? true : false;
//		}
		
}
