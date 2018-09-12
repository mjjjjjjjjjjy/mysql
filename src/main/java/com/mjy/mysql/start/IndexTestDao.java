package com.mjy.mysql.start;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public void batchInsert(){
		String sql = "INSERT INTO index_test (name, card_number,city) VALUES (?, ?, ?)";
		List<Object[]> arrayList = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			arrayList.add(new String[]{"name"+i,"number"+i,"city"+i});
			if (i%10000==0) {
				jdbcTemplate.batchUpdate(sql,arrayList);
				log.info("批量插入{}条",arrayList.size());
				arrayList.clear();
				log.info("插入了{}条数据",i);
			}
		}
	}

}
