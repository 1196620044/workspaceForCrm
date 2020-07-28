package com.chen.crm.settings.service.impl;

import com.chen.crm.settings.dao.DicTypeDao;
import com.chen.crm.settings.dao.DicValueDao;
import com.chen.crm.settings.service.DicService;
import com.chen.crm.utils.SqlSessionUtil;

/**
 * @Author: 86176
 * @Date: 2020/7/28 17:16
 * @Description:
 */
public class DicServiceImpl implements DicService {

    private DicTypeDao dicTypeDao= SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);
}
