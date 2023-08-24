package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;






@Repository
public class MemberDAO {
	
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	public MemberVO login(HashMap<String , String> params) {
		MemberVO vo = sql.selectOne("member.login", params);
		return vo;
}

	
	
	public MemberVO idcheck(String member_id) {
		return sql.selectOne("member.idcheck",member_id);
	}
	
	public MemberVO	check(MemberVO vo) {
		return sql.selectOne("member.check",vo);
	}
	
	
	
	public MemberVO	order(MemberVO vo) {
		return sql.selectOne("member.order",vo);
	}
	

	
	public MemberVO findid(HashMap<String, String> params) {
		return sql.selectOne("member.findid",params);
	}
	
	
	public MemberVO findpw(HashMap<String, String> params) {
		return sql.selectOne("member.findpw",params);
	}
	
	
	public MemberVO member_info(String store_id) {
		return sql.selectOne("member.info", store_id);
	}
	
	
	
}
