package com.hanul.cloude;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import delivery_address.Delivery_addressVO;
import goods.GoodsVO;
import member.MemberVO;

@RestController
public class AddressController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;

	//주소 입력
	@RequestMapping("/address/insert")
	public void insert(Delivery_addressVO vo) {
		sql.insert("address.insert", vo);
	}
	
	@RequestMapping(value = "/address/select" , produces = "text/html;charset=utf-8")
	public String select(int member_no) {
		List<Delivery_addressVO> list = sql.selectList("address.select" , member_no);
		 return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/address/update" , produces = "text/html;charset=utf-8")
	public void update(MemberVO vo) {
		sql.update("address.update" , vo);

	}
	
	
	
}
