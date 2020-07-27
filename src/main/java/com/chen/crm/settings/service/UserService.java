package com.chen.crm.settings.service;

import com.chen.crm.exception.LoginException;
import com.chen.crm.settings.domain.User;

import java.util.List;

/**
 * @Author: 86176
 * @Date: 2020/7/25 21:47
 * @Description:
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
