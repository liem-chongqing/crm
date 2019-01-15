package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.HouseDao;
import com.bdqn.crm.dao.impl.HouseDaoImpl;
import com.bdqn.crm.dto.HouseInfoDto;
import com.bdqn.crm.entity.HouseInfo;
import com.bdqn.crm.service.HouseService;

import java.util.List;


public class HouseServiceImpl implements HouseService {

    private HouseDao houseDao = new HouseDaoImpl();

    @Override
    public List<HouseInfoDto> findPageAllUser(int thisPage, int pageSize) {
        return houseDao.findPageAllUser(thisPage, pageSize);
    }

    @Override
    public int save(HouseInfo houseInfo) {
        return houseDao.save(houseInfo);
    }
}
