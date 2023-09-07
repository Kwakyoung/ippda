package com.hanul.cloude;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import goods_option.GoodsBoardBuyCheckDTO;
import order_ing.Order_ingDAO;
import order_ing.Order_ingVO;
@RestController @RequestMapping("/order_ing")
public class Order_ingConroller {
	
	@Autowired
	@Qualifier("ippda") SqlSession sql;
	@Autowired Order_ingDAO dao;
	
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
			sql.insert("order_ing.insert", dto);

	}
	@RequestMapping(value = "/check" , produces = "text/html;charset=utf-8")
	public String Check(String member_no, String order_status) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("member_no", member_no);
		params.put("order_status", order_status);
		List<Order_ingVO> vo = dao.Check(params);
		return new Gson().toJson(vo);
	}
	
	
}
