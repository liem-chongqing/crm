package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.CommonDao;
import com.bdqn.crm.dao.impl.CommonDaoImpl;
import com.bdqn.crm.service.CommonService;

public class CommonServiceImpl implements CommonService {

    private CommonDao commonDao = new CommonDaoImpl();

    @Override
    public int getTotalNumber(String sql, String... pram) {
        return commonDao.getTotalNumber(sql, pram);
    }

    @Override
    public int deleteOneById(String tableName, long id) {
        return commonDao.deleteOneById(tableName, id);
    }

    @Override
    public int deleteBatch(String tableName, String ids) {
        return commonDao.deleteBatch(tableName, ids);
    }

    @Override
    public int update(String tableName, Object object) {
        return commonDao.update(tableName, object);
    }

    @Override
    public Integer totalNumberByTableName(String tableName) {
        return commonDao.totalNumberByTableName(tableName);
    }
}
