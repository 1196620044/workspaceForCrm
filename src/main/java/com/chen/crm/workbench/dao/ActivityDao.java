package com.chen.crm.workbench.dao;

import com.chen.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * @Author: 86176
 * @Date: 2020/7/26 18:39
 * @Description:
 */
public interface ActivityDao {

    int save(Activity activity);

    List<Activity> getActivityByCondition(Map<String, Object> map);

    int getTotalByCondition(Map<String, Object> map);

    int delete(String[] ids);

    Activity getById(String id);

    int update(Activity activity);

}
