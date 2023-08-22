package inventory;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import coupon.CouponVO;

@Repository
public class InventoryDAO {

	@Autowired @Qualifier("ippda") SqlSession sql;
	public List< InventoryVO > check_color(HashMap<String , String> params) {
		List< InventoryVO > vo = sql.selectList("inventory.check_color", params);
		return vo;
	}
	public List< InventoryVO > check_size(HashMap<String , String> params) {
		List< InventoryVO > vo = sql.selectList("inventory.check_size", params);
		return vo;
	}
	public List< InventoryVO > check(HashMap<String , String> params) {
		List< InventoryVO > vo = sql.selectList("inventory.check", params);
		return vo;
	}
}
