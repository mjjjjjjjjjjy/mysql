package com.mjy.mysql.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 测试数据库的索引
 * @author mojianyue
 *
 */
@Service
public class MysqlIndex {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
}
