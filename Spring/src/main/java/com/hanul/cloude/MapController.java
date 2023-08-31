package com.hanul.cloude;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import delivery_address.Delivery_addressVO;


@Controller
public class MapController {

	@Autowired @Qualifier("ippda") SqlSession sql;
	
	//카카오 주소 검색 api 
	@RequestMapping("/map")
	public String map() {
		return "map/daum";
	}	
	

	
	
	
}
