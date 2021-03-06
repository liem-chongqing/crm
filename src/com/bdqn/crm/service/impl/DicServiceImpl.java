package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.CustomerDao;
import com.bdqn.crm.dao.DicDao;
import com.bdqn.crm.dao.impl.CustomerDaoImpl;
import com.bdqn.crm.dao.impl.DicDaoImpl;
import com.bdqn.crm.dto.DicItemDto;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.DicType;
import com.bdqn.crm.service.DicService;

import java.util.List;

public class DicServiceImpl implements DicService {
    private DicDao dicDao = new DicDaoImpl();

    @Override
    public List<DicType> getAllType(int thisPage, int pageSize) {
        return dicDao.getAllType(thisPage, pageSize);
    }

    @Override
    public List<DicItemDto> getAllItems(int thisPage, int pageSize) {
        return dicDao.getAllItems(thisPage, pageSize);
    }

    @Override
    public int saveType(DicType dicType) {
        return dicDao.saveType(dicType);
    }

    @Override
    public int saveItem(DicItem dicItem) {
        return dicDao.saveItem(dicItem);
    }

    @Override
    public List<DicItem> findDicType(String key) {
        return dicDao.findDicType(key);
    }
}
