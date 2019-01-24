package com.bdqn.crm.service;

import com.bdqn.crm.entity.CustomerInfo; /**
 * 共有接口方法
 */
public interface CommonService {

    /**
     * 根据表名查询总数据量
     * @param sql
     * @return
     */
    int getTotalNumber(String sql, String... pram);


    /**
     * 根据Id删除一条数据
     * @param tableName
     * @param id
     * @return
     */
    int deleteOneById(String tableName, long id);

    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    int deleteBatch(String tableName, String ids);

    /**
     * 修改数据
     * @param tableName
     * @param object
     * @return
     */
    int update(String tableName, Object object);
}
