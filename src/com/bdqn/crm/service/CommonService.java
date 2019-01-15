package com.bdqn.crm.service;

/**
 * 共有接口方法
 */
public interface CommonService {

    /**
     * 根据表名查询总数据量
     * @param tableName
     * @return
     */
    int getTotalNumber(String tableName);


    /**
     * 根据Id删除一条数据
     * @param tableName
     * @param id
     * @return
     */
    int deleteOneById(String tableName, long id);

}
