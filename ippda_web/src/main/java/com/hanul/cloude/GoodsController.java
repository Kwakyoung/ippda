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
import org.springframework.web.bind.annotation.RequestParam;
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
		vo.setGoods_main_image( common.fileUpload("goods", file[0], request) );
		vo.setGoods_sub_image( common.fileUpload("goods", file[1], request) );
		
		int insert = sql.insert("goods.insert", vo);
		if( insert==1  ) {
//			sql.insert("goods.fileRegister", vo);

		}
		
		return "redirect:list";
	}
	
	@RequestMapping("/option")
	public String option(@RequestParam("goods_no") int goods_no , Model model , HttpSession session) {
	
		
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		model.addAttribute("loginInfo", loginInfo);
		model.addAttribute("goodsInfo" , goods_no);
		
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
		
		
		return "redirect:/goods/list";
	}
	
	
	@RequestMapping("/list")
	public String goodsList(HttpSession session, Model model) {
				
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		
		int store_no = loginInfo.getStore_no();
		List<GoodsVO> vo = sql.selectList("goods.list", store_no);
		model.addAttribute("goodslist", vo);
		session.setAttribute("goodsInfo", vo);
		return"goods/list";
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam("goods_no") int goods_no , Model model , HttpSession session , MultipartFile file[]) {
		GoodsVO vo = sql.selectOne("goods.modify", goods_no);
			
		model.addAttribute("vo", vo);
		
		return"goods/modify";
	}
	
	
	
}
