package com.chen.crm.workbench.dao;

/**
 * @Author: 86176
 * @Date: 2020/7/26 19:29
 * @Description:
 */
public interface ActivityRemarkDao {

    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

}
