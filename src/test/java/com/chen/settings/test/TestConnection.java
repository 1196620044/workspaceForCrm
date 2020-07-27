package com.chen.settings.test;

import com.chen.crm.utils.SqlSessionUtil;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author: 86176
 * @Date: 2020/7/27 21:01
 * @Description:
 */
public class TestConnection {
    @Test
    public void testConnection() throws Exception {
        Connection connection = SqlSessionUtil.getSqlSession().getConnection();
        System.out.println(connection!=null?"连接成功":"连接失败");
    }
}
