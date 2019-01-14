package com.bdqn.crm.dao;

import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.DicType;

import java.util.List;

public interface DicDao {
    int getTotalNumber(String tableName);

    List<DicType> getAllType(int thisPage, int pageSize);

    List<DicItem> getAllItems(int thisPage, int pageSize);

    int saveItem(DicItem dicItem);

    int saveType(DicType dicType);
}
