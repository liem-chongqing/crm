package com.bdqn.crm.service;

import com.bdqn.crm.dto.NoticeInfoDto;
import com.bdqn.crm.entity.NoticeInfo;

import java.util.List;

public interface NoticeService {

    /**
     * 分页查询所有公告
     * @param thisPage
     * @param pageSize
     * @return
     */
    List<NoticeInfoDto> findPageAllNotice(int thisPage, int pageSize);

    /**
     * 发布公告
     * @param noticeInfo
     * @return
     */
    int save(NoticeInfo noticeInfo);
}
