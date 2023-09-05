package goods_like;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class Goods_likeDAO {
	@Autowired @Qualifier("ippda") SqlSession sql;
	public List< Goods_likeVO > list(HashMap<String , String> params) {
		List< Goods_likeVO > vo = sql.selectList("goods_like.list", params);
		return vo;
	}
	
	public int add(Goods_likeVO vo) {
	    return sql.insert("goods_like.add", vo);
	}

	public int delete(HashMap<String , String> params) {
		int vo = sql.delete("goods_like.delete", params);
		return vo;
	}
	public List< Goods_likeVO > alllist(HashMap<String , Object> params) {
		List< Goods_likeVO > vo = sql.selectList("goods_like.alllist", params);
		return vo;
	}
	
}
