package com.hanul.cloude;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.PageVO;
import member.MemberVO;
import order.OrderVO;

@Controller @RequestMapping("/order")
public class OrderController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	
	@ResponseBody @RequestMapping("/status/cancel")
	public void orderCancel(String orderNo , Model model) {
		sql.update("order.orderStatusCancel", orderNo );
	}
	
	@ResponseBody @RequestMapping("/status/ing")
	public void orderStatus(String orderNo , Model model) {
		sql.update("order.orderStatusIng", orderNo ); 
	}
	
	@RequestMapping("/alarm")
	public Object orderAlarm(HttpSession session, String store_no , Model model) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("store_no", 1 ); // member.getStore_no());
		map.put("order_status", "결제완료");
//		return sql.selectList("order.alarm", map);
		model.addAttribute("alarmList", sql.selectList("order.alarm", map) ); 
		return "include/alarm/alarm";
	}
	
	@RequestMapping("/list")
	public String orderList(HttpSession session, Model model , PageVO page) {
//		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		session.setAttribute("category", "order");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("store_no", 1); //member.getStore_no()
		map.put("page", page);
		int totalList = sql.selectOne("order.total", 1);
		page.setTotalList(totalList) ; // member.getStore_no()
		page.setList( sql.selectList("order.list", map) );
		model.addAttribute("page", page); 
		
		
		
		
		return "order/list";
	}
	
	@RequestMapping("/info")
	public String orderInfo(int order_no, Model model) {
		OrderVO vo = sql.selectOne("order.info", order_no);
		model.addAttribute("orderInfo", vo);
		return "order/info";
	}
	
	@RequestMapping("/update")
	public String orderModify(@RequestParam("order_status") String order_status , @RequestParam("order_no") int order_no) {
		HashMap<String , Object> map = new HashMap<String, Object>();
		map.put("order_no", order_no);
		map.put("order_status", order_status);
		
		sql.update("order.update" , map);
		return "redirect:/order/list";
	}
	
}
