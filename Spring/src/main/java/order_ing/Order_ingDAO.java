package order_ing;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Order_ingDAO {
	
	@Autowired @Qualifier("ippda") SqlSession sql;
	public Order_ingVO Insert(HashMap<String , String> params) {
		Order_ingVO vo = sql.selectOne("order_ing.login", params);
		return vo;
	}
}
