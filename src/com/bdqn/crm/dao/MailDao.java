package com.bdqn.crm.dao;

import com.bdqn.crm.dto.EmailInfoDto;
import com.bdqn.crm.entity.EmailInfo;

import java.util.List;

public interface MailDao {

    int savaSendInfo(EmailInfo emailInfo);

    List<EmailInfoDto> findPageAllEmail(int thisPage, int pageSize);


    EmailInfoDto getEmailInfoByMailId(Integer mailId);

    int modifyMialSendStateByMailId(String state, Long id);
}
