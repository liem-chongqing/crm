package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.NoticeDao;
import com.bdqn.crm.dto.NoticeInfoDto;
import com.bdqn.crm.entity.NoticeInfo;
import com.bdqn.crm.util.DBUtil;

import java.util.List;

public class NoticeDaoImpl implements NoticeDao {

    @Override
    public List<NoticeInfoDto> findPageAllNotice(int thisPage, int pageSize) {
        String sql ="SELECT ni.*, ui.`name` AS userName FROM notice_info ni, user_info ui WHERE ui.id = ni.user_id  ORDER BY ni.time DESC LIMIT ?,?";
        return DBUtil.find(NoticeInfoDto.class, sql, thisPage, pageSize);
    }

    @Override
    public int save(NoticeInfo noticeInfo) {
        return DBUtil.insert("notice_info", noticeInfo);
    }
}
