package member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	public MemberVO list() {
		MemberVO vo = sql.selectOne("member.list");
		return vo;
	}
}
