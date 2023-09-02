package goods_option;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class Goods_optionDAO {
	@Autowired @Qualifier("ippda") SqlSession sql;
	public List< Goods_optionVO > check_size(HashMap<String , String> params) {
		List< Goods_optionVO > vo = sql.selectList("goods_option.check_size", params);
		return vo;
	}
	
	public int Order(HashMap<String , String> params) {
		int vo = sql.update("goods_option.order", params);
		return vo;
	}
}
