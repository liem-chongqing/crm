package com.bdqn.crm.dao;

import com.bdqn.crm.dto.NoticeInfoDto;
import com.bdqn.crm.entity.NoticeInfo;

import java.util.List;

public interface NoticeDao {

    List<NoticeInfoDto> findPageAllNotice(int thisPage, int pageSize);

    int save(NoticeInfo noticeInfo);

    List<NoticeInfo> findNoticeInfoByNumber(int rowNumber);
}
