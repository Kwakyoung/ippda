package data;

import java.util.HashMap;
import java.util.List;

import order.OrderVO;

public interface DataService {

	List<HashMap<String, Object>> department(); // 부서별 사원수 조회
	List<HashMap<String, Object>> sell_year(); // 년도별 총판매수
	List<HashMap<String, Object>> sell_month(); // 월별 총판매수
	
}
