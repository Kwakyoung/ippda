package data;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAO implements DataService{

	@Autowired @Qualifier("ippda") private SqlSession sql;
	
	@Override
	public List<HashMap<String, Object>> department() {
		
		return null;
	}

	@Override
	public List<HashMap<String, Object>> sell_year() {
	
		return sql.selectList("data.Year");
	}

	@Override
	public List<HashMap<String, Object>> sell_month() {
		
		return sql.selectList("data.Month");
	}
}
