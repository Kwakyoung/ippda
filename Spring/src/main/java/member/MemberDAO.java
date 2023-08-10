package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;



@Repository
public class MemberDAO {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	public MemberVO login(HashMap<String , String> params) {
		MemberVO vo = sql.selectOne("member.login", params);
		return vo;
}
	
//	public int insert(@RequestParam String member_id , ) {
//		HashMap<Stirng, Object> params = new HashMap<String, Object>();
//		params
//		
//		return sql.insert("member.join",vo);
//	}
	
	public MemberVO idcheck(String member_id) {
		return sql.selectOne("member.idcheck",member_id);
	}
	
}
