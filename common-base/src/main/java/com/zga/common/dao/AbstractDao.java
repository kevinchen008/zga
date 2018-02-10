package com.zga.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2017-11-29 21:11
 */
public class AbstractDao {
    @Autowired
    @Qualifier("zga")
    protected SqlSessionTemplate session;

    public  String getUUID() {
        String id = UUID.randomUUID().toString();
        // 去掉“-”符号
        return id.replaceAll("-", "");
    }

    public String getNowTime(){
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 制定日期格式
        return df.format(date);
    }
}
