package com.mjy.mysql.start.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
* @author MoJianyue
* @version 创建时间：2018年9月13日 下午2:36:28
*/
@Repository
public class MediaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public static void insert(Integer i) {
        String sql = "INSERT INTO `mysql_test`.`media_text_publish` (`serialnumber`, `office_account`, `schedule`, `task_id`, `tab`, `cover`)" 
                +"VALUES ('是多少多少%s', '的实打实大多数%s', '收到%s', '1%s', '收到%s', '收到%s');";
        for (int j = 0; j < i; j++) {
        }
        
    }
}
