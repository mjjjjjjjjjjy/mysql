package com.mjy.mysql.start;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@Controller
public class IndexTestDao {
	
	private static final Logger log = LoggerFactory.getLogger(IndexTestDao.class);

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@GetMapping("/1")
	@ResponseBody
//	@Async
	public void batchInsert(){
		String sql = "INSERT INTO index_test (name, card_number,city) VALUES (?, ?, ?)";
		List<Object[]> arrayList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			arrayList.add(new String[]{"name"+i,"number"+i,"city"+i});
		}
		long currentTimeMillis = System.currentTimeMillis();
		jdbcTemplate.batchUpdate(sql,arrayList);
        long currentTimeMillis2 = System.currentTimeMillis();
//		log.info("批量插入{}条,耗时{}",arrayList.size(),currentTimeMillis2-currentTimeMillis);
		arrayList.clear();
//		log.info("插入了{}条数据",1000);
	}
	
	
	@Async
    public void query(String name){
        String sql = "select * from index_test1 where name = ? ";
        long currentTimeMillis = System.currentTimeMillis();
        List<VO> query = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(VO.class),name);
        long currentTimeMillis2 = System.currentTimeMillis();
        log.info("耗时{},查询{}",currentTimeMillis2-currentTimeMillis,org.springframework.util.CollectionUtils.isEmpty(query)?null:query.get(0).getName());
    }
	
    public void query2(){
        String sql = "SELECT * FROM mysql_test.index_test2;";
        long currentTimeMillis = System.currentTimeMillis();
        List<VO> query = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(VO.class));
        long currentTimeMillis2 = System.currentTimeMillis();
        log.info("耗时{}",currentTimeMillis2-currentTimeMillis);
    }
	
	
	
	@Async
	public void batchInsert(String sql,List<Object[]> arrayList) {
	    jdbcTemplate.batchUpdate(sql,arrayList);
	}
	
	@Async
    public void batchInsert2() {
	    String sql = "INSERT INTO index_test (name, card_number,city) VALUES (?, ?, ?)";
	    List<Object[]> arrayList = new ArrayList<>();
        arrayList.add(new String[]{"name","number","city"});
        jdbcTemplate.batchUpdate(sql,arrayList);
    }

}
