package com.zga.common.service;

import com.zga.common.bean.UserEntity;
import com.zga.common.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2017-11-29 21:14
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    BaseDao userDao;


    // @Cacheable(value = "common",key="'users'")
    public List<UserEntity> getAllUsers(){
        //  for (int i =0;i<100000000;i++) {
        LOGGER.info("===========getAllUsers" );

        //  }
        List<UserEntity> list =  userDao.getAllUsers();

     /*   try {
            testMethod();
        }catch (Exception e){
            LOGGER.error("============error===========",e);
        }*/

      /*  LOGGER.error("============error===========");*/

        LOGGER.info("getAllUsers {}");
        return  list;
    }


    public int addUser(UserEntity user) {
        return userDao.addUser(user);
    }

    public void testMethod2() throws Exception {

        throw new ClassNotFoundException("test2 Exception");
    }
}
