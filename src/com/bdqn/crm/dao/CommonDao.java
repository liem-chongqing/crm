package com.bdqn.crm.dao;


public interface CommonDao {


    int getTotalNumber(String tableName);

    int deleteOneById(String tableName, long id);

    int deleteBatch(String tableName, String ids);
}
