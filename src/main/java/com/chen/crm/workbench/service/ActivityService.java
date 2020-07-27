package com.chen.crm.workbench.service;

import com.chen.crm.vo.PaginationVO;
import com.chen.crm.workbench.domain.Activity;

import java.util.Map;

/**
 * @Author: 86176
 * @Date: 2020/7/26 18:42
 * @Description:
 */
public interface ActivityService {
    boolean save(Activity activity);

    PaginationVO<Activity> pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    Map<String, Object> getUerListAndActivity(String id);

    boolean update(Activity activity);
}
