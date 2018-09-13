package com.mjy.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjy.mysql.start.IndexTestDao;

@SpringBootApplication
@EnableAsync
@Controller
public class MysqlApplication {

private static final Logger log = LoggerFactory.getLogger(MysqlApplication.class);

    @Autowired
    IndexTestDao indexTestDao;
    
	public static void main(String[] args) {
		SpringApplication.run(MysqlApplication.class, args);
	}
	
	@GetMapping("/2")
	@ResponseBody
	public void testBatchInsert2() {
        Integer j = 1000;
        for (int i = 0; i < j; i++) {
//            long currentTimeMillis = System.currentTimeMillis();
            indexTestDao.batchInsert();
//            long currentTimeMillis2 = System.currentTimeMillis();
            log.info("循环={}",i);
        }
    }
	
	@GetMapping("/3")
    @ResponseBody
    public void select() {
        Integer j = 50;
        for (int i = 0; i < j; i++) {
            String name = "name"+i;
            indexTestDao.query(name);
//            log.info("循环={}",i);
        }
    }
	

    @GetMapping("/4")
    @ResponseBody
    public void select2() {
        Integer j = 50;
        for (int i = 0; i < j; i++) {
            indexTestDao.query2();
        }
    }
}
