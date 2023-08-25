package com.hanul.cloude;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.CommonUtility;
import goods.GoodsOptionVO;
import goods.GoodsVO;
import goods.OptionVO;
import member.MemberVO;

@Controller @RequestMapping("/goods")
public class GoodsController {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	@Autowired private CommonUtility common;
	
	@RequestMapping("/basicinfo")
	public String basicinfo(HttpSession session, Model model) {
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		model.addAttribute("loginInfo", loginInfo);
		System.out.println(loginInfo);
		return"goods/basicinfo";
	}
	
	@RequestMapping("/insert")
	public String insert(GoodsVO vo, MultipartFile file[] , HttpServletRequest request ,HttpSession session) {
		int insert = sql.insert("goods.insert", vo);
		vo.setFileList( common.attachedFiles("goods", file, request) );
		
		if( insert==1 && vo.getFileList() != null ) {
			sql.insert("goods.fileRegister", vo);
			session.setAttribute("goodsInfo", vo);
		}
		
		return "redirect:option";
	}
	
	@RequestMapping("/option")
	public String option(HttpSession session , Model model) {
		GoodsVO goodsInfo = (GoodsVO) session.getAttribute("goodsInfo");
		model.addAttribute("goodsInfo" , goodsInfo);
		
		return"goods/option";
	}
	
	
	@RequestMapping("/option/insert")
//	public String optionInsert(GoodsOptionVO vo 
	public String optionInsert(GoodsVO vo			
							, String goods_option_size
							, String goods_option_cnt
							, String goods_option_color
							, HttpSession session) {
		String size[] = goods_option_size.split(",");
		String cnt[] = goods_option_cnt.split(",");
		String color[] = goods_option_color.split(",");
		
		List<OptionVO> options = new ArrayList<OptionVO>();
		for( int idx=0; idx<size.length; idx++ ) {
			OptionVO option = new OptionVO();
			option.setGoods_cnt( Integer.parseInt(cnt[idx]) );
			option.setGoods_size( size[idx] );
			option.setGoods_color( color[idx] );
			options.add(option);
		}
		vo.setOptionList(options);
		
		sql.insert("goods.optionInsert", vo);
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		
		
		return"goods/list";
	}
	
	
	@RequestMapping("/list")
	public String goodsList(HttpSession session, Model model) {
				
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		
		int store_no = loginInfo.getStore_no();
		List<GoodsVO> vo = sql.selectList("goods.list", store_no);
		model.addAttribute("goodslist", vo);
		
		return"goods/list";
	}
	
}
