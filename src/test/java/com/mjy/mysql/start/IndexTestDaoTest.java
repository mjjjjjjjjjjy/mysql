package com.mjy.mysql.start;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.mjy.mysql.MysqlApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class IndexTestDaoTest {

	@Autowired
	IndexTestDao indexTestDao;
	@Test
	public void testBatchInsert() {
		indexTestDao.batchInsert();
	}

}
