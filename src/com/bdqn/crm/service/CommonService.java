package com.bdqn.crm.service;

import com.bdqn.crm.entity.CustomerInfo;

import java.util.ArrayList;
import java.util.List; /**
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

    /**
     * 统计总数据量
     * @param customer_info
     * @return
     */
    Integer totalNumberByTableName(String tableName);

    /**
     * 批量上传文件
     * @param list
     * @return
     */
    int batchAdd(List<ArrayList<Object>> list, String tableName);
}
