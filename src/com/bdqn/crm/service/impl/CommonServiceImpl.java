package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.CommonDao;
import com.bdqn.crm.dao.impl.CommonDaoImpl;
import com.bdqn.crm.service.CommonService;

public class CommonServiceImpl implements CommonService {

    private CommonDao commonDao = new CommonDaoImpl();

    @Override
    public int getTotalNumber(String tableName) {
        return commonDao.getTotalNumber(tableName);
    }

    @Override
    public int deleteOneById(String tableName, long id) {
        return commonDao.deleteOneById(tableName, id);
    }

    @Override
    public int deleteBatch(String tableName, String ids) {
        return commonDao.deleteBatch(tableName, ids);
    }
}
