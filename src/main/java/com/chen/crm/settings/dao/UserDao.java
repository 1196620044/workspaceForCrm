package com.chen.crm.settings.dao;

import com.chen.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: 86176
 * @Date: 2020/7/25 21:29
 * @Description:
 */
public interface UserDao {

    User login(Map<String, Object> map);

    List<User> getUserList();
}
