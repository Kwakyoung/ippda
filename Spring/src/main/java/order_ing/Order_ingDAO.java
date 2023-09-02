package order_ing;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Order_ingDAO {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	public Order_ingVO Insert(HashMap<String , String> params) {
		Order_ingVO vo = sql.selectOne("order_ing.insert", params);
		return vo;
	}
	public List< Order_ingVO > Check(HashMap<String , String> params) {
		List< Order_ingVO > vo = sql.selectList("order_ing.check", params);
		return vo;
	}
}
