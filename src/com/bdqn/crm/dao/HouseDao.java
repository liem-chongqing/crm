package com.bdqn.crm.dao;

import com.bdqn.crm.dto.HouseInfoDto;
import com.bdqn.crm.entity.HouseInfo;
import com.bdqn.crm.service.HouseService;

import java.util.List;


public interface HouseDao {


    List<HouseInfoDto> findPageAllUser(int thisPage, int pageSize);

    int save(HouseInfo houseInfo);
}
