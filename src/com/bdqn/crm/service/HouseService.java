package com.bdqn.crm.service;

import com.bdqn.crm.dto.HouseInfoDto;
import com.bdqn.crm.entity.HouseInfo;

import java.util.List;

public interface HouseService {


    /**
     * 分页查看房屋信息
     * @param thisPage
     * @param pageSize
     * @return
     */
    List<HouseInfoDto> findPageAllUser(int thisPage, int pageSize);

    /**
     * 保存房屋信息
     * @param houseInfo
     * @return
     */
    int save(HouseInfo houseInfo);
}
