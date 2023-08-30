package com.hanul.cloude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import goods_option.GoodsBoardBuyCheckDTO;
import member.MemberVO;
import order_ing.Order_ingDAO;
@RestController @RequestMapping("/order_ing")
public class Order_ingConroller {
	
	@Autowired
	@Qualifier("ippda") SqlSession sql;
	@Autowired Order_ingDAO dao;

//	@RequestMapping(value = "/insert", produces = "text/html;charset=utf-8")
//	public void Insert(String member_no, String goods_no, GoodsOptionVO optionVO, String order_status ) {
//	HashMap<String, String> params = new HashMap<String, String>();
//	params.put("member_no", member_no);
//	params.put("goods_no", goods_no);
//	params.put("goods_option_no", optionVO.getGoods_option_no()+"");
//	params.put("order_size", optionVO.getGoods_size());
//	params.put("order_cnt", optionVO.getGoods_cnt()+"");
//	params.put("order_status",order_status );
//	params.put("order_color", optionVO.getGoods_color());
//	
//	sql.insert("order.insert", params);
//	
//}
	
	

		
	
	
	@RequestMapping(value = "/insert", produces = "text/html;charset=utf-8")
	public void Insert( String member_no,  String store_no,  String goods_no, String order_size, String order_cnt, String order_address, String order_status, String order_color ,String order_price ,String order_goods_name ) {
		
		GoodsBoardBuyCheckDTO dto = new GoodsBoardBuyCheckDTO();
			dto.setMember_no( Integer.parseInt( member_no ) );
			dto.setOrder_status(  order_status );
			dto.setOrder_color(  order_color );
			dto.setOrder_size( order_size );
			dto.setOrder_address(order_address); 
			dto.setOrder_cnt( Integer.parseInt(order_cnt) );
			dto.setGoods_no( Integer.parseInt(goods_no) );
			dto.setStore_no( Integer.parseInt(store_no) );
			dto.setOrder_price( Integer.parseInt(order_price) );
			dto.setOrder_goods_name(order_goods_name);
			sql.insert("order.insert", dto);
			
		System.out.println();
//		sql.insert("order.insert", list);

	}
	
	
	
}
