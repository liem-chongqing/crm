package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.MailDao;
import com.bdqn.crm.dao.impl.MailDaoImpl;
import com.bdqn.crm.dto.EmailInfoDto;
import com.bdqn.crm.entity.EmailInfo;
import com.bdqn.crm.service.MailService;

import java.util.List;

public class MailServiceImpl implements MailService {

    private MailDao mailDao = new MailDaoImpl();

    @Override
    public int savaSendInfo(EmailInfo emailInfo) {
        return mailDao.savaSendInfo(emailInfo);
    }

    @Override
    public List<EmailInfoDto> findPageAllEmail(int thisPage, int pageSize) {
        return mailDao.findPageAllEmail(thisPage, pageSize);
    }

    @Override
    public EmailInfoDto getEmailInfoByMailId(int mailId) {
        return mailDao.getEmailInfoByMailId(mailId);
    }

    @Override
    public int modifyMialSendStateByMailId(String state, Long id) {
        return mailDao.modifyMialSendStateByMailId(state, id);
    }

}
