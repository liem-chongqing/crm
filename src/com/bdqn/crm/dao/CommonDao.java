package com.bdqn.crm.dao;


import java.util.ArrayList;
import java.util.List;

public interface CommonDao {


    int getTotalNumber(String sql, String... pram);

    int deleteOneById(String tableName, long id);

    int deleteBatch(String tableName, String ids);

    int update(String tableName, Object object);

    Integer totalNumberByTableName(String tableName);

    int batchAdd(List<ArrayList<Object>> list, String tableName);
}
