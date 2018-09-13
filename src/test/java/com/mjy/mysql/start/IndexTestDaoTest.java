package com.mjy.mysql.start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class IndexTestDaoTest {
    
    private static final Logger log = LoggerFactory.getLogger(IndexTestDaoTest.class);


	@Autowired
	IndexTestDao indexTestDao;
	@Test
	public void testBatchInsert() {
	    Integer j = 5000000;
	    long currentTimeMillis = System.currentTimeMillis();
		indexTestDao.batchInsert();
		long currentTimeMillis2 = System.currentTimeMillis();
		log.info("两个字段联合索引情况下，j={}条数据，每次批量10000条插入的时间={}",j,currentTimeMillis2-currentTimeMillis);
	}
	
	@Test
    public void testBatchInsert2() {
        Integer j = 20;
        for (int i = 0; i < j; i++) {
            long currentTimeMillis = System.currentTimeMillis();
            indexTestDao.batchInsert();
            long currentTimeMillis2 = System.currentTimeMillis();
            log.info("两个字段联合索引情况下，j={}条数据，每次批量10000条插入的时间={}",j,currentTimeMillis2-currentTimeMillis);
        }
    }
	
	@Test
	public void test2() {
	    for (int i = 0; i < 5; i++) {
	        indexTestDao.batchInsert2();
        }
	}

}
