package com.bdqn.crm.dao;

import com.bdqn.crm.dto.DicItemDto;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.DicType;

import java.util.List;

public interface DicDao {


    List<DicType> getAllType(int thisPage, int pageSize);

    List<DicItemDto> getAllItems(int thisPage, int pageSize);

    int saveItem(DicItem dicItem);

    int saveType(DicType dicType);

    List<DicItem> findDicType(String key);
}
