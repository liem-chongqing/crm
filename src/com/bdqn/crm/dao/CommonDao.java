package com.bdqn.crm.dao;


public interface CommonDao {


    int getTotalNumber(String sql, String... pram);

    int deleteOneById(String tableName, long id);

    int deleteBatch(String tableName, String ids);

    int update(String tableName, Object object);

    Integer totalNumberByTableName(String tableName);
}
