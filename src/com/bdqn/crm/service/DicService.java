package com.bdqn.crm.service;

import com.bdqn.crm.dto.DicItemDto;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.DicType;

import java.util.List;

public interface DicService {


    List<DicType> getAllType(int thisPage, int pageSize);

    List<DicItemDto> getAllItems(int thisPage, int pageSize);

    int saveType(DicType dicType);

    int saveItem(DicItem dicItem);

    /**
     * 查询数据状态
     * @param key
     * @return
     */
    List<DicItem> findDicType(String key);
}
