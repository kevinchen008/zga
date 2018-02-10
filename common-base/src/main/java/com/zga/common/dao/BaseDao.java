package com.zga.common.dao;

import com.zga.common.bean.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2017-11-29 21:12
 */
@Repository
public class BaseDao extends  AbstractDao {

    public List<UserEntity> getAllUsers() {
        return session.selectList("user.getAllUsers");
    }


    public int addUser(UserEntity user){
        return session.insert("user.addUser",user);
    }
}