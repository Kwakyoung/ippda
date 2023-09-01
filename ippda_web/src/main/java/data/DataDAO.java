package data;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAO {

	@Autowired @Qualifier("ippda") private SqlSession sql;
	
	public List<HashMap<String, Object>> data_month() {
		return sql.selectList("data.Month");
	}
	
	public List<HashMap<String, Object>> data_year() {
		return sql.selectList("data.Year");
	}
}
