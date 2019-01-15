package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.HouseDao;
import com.bdqn.crm.dto.HouseInfoDto;
import com.bdqn.crm.entity.HouseInfo;
import com.bdqn.crm.util.DBUtil;

import java.util.List;


public class HouseDaoImpl implements HouseDao {


    @Override
    public List<HouseInfoDto> findPageAllUser(int thisPage, int pageSize) {
        String sql = "SELECT hi.*, ui.`name` AS userName, di.`name` AS typeName FROM houser_info hi LEFT JOIN user_info ui ON hi.user_id=ui.id  LEFT JOIN dic_item di ON hi.type_id=di.id " +
                "ORDER BY hi.id DESC LIMIT ?, ?";
        return DBUtil.find(HouseInfoDto.class, sql, thisPage, pageSize);
    }

    @Override
    public int save(HouseInfo houseInfo) {
        return DBUtil.insert("houser_info", houseInfo);
    }
}
