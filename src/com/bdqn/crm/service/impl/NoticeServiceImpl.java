package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.NoticeDao;
import com.bdqn.crm.dao.impl.NoticeDaoImpl;
import com.bdqn.crm.dto.NoticeInfoDto;
import com.bdqn.crm.entity.NoticeInfo;
import com.bdqn.crm.service.NoticeService;

import java.util.List;

public class NoticeServiceImpl implements NoticeService {

    private NoticeDao noticeDao = new NoticeDaoImpl();

    @Override
    public List<NoticeInfoDto> findPageAllNotice(int thisPage, int pageSize) {
        return noticeDao.findPageAllNotice(thisPage, pageSize);
    }

    @Override
    public int save(NoticeInfo noticeInfo) {
        return noticeDao.save(noticeInfo);
    }
}
