package com.chen.crm.workbench.service.impl;

import com.chen.crm.utils.SqlSessionUtil;
import com.chen.crm.workbench.dao.ClueDao;
import com.chen.crm.workbench.service.ClueService;

/**
 * @Author: 86176
 * @Date: 2020/7/28 17:01
 * @Description:
 */
public class ClueServiceImpl implements ClueService {

    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
}
