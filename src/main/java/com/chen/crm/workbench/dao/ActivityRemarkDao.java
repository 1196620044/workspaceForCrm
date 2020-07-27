package com.chen.crm.workbench.dao;

import com.chen.crm.workbench.domain.ActivityRemark;

import java.util.List;

/**
 * @Author: 86176
 * @Date: 2020/7/26 19:29
 * @Description:
 */
public interface ActivityRemarkDao {

    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    int deleteRemark(String id);

    int saveRemark(ActivityRemark ar);

    int updateRemark(ActivityRemark ar);
}
