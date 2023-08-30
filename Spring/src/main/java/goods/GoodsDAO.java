package goods;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAO {
	@Autowired @Qualifier("ippda") SqlSession sql;
	
	public void insert(GoodsVO vo) {
		int  result = sql.insert("customer.insert" , vo);
		System.out.println("성공여부 : " + result);
	}

}
