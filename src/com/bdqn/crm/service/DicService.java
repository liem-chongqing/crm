package com.bdqn.crm.service;

import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.DicType;

import java.util.List;

public interface DicService {
    int getTotalNumber(String tableName);

    List<DicType> getAllType(int thisPage, int pageSize);

    List<DicItem> getAllItems(int thisPage, int pageSize);

    int saveType(DicType dicType);

    int saveItem(DicItem dicItem);
}
