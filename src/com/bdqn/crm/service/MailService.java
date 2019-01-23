package com.bdqn.crm.service;

import com.bdqn.crm.dto.EmailInfoDto;
import com.bdqn.crm.entity.EmailInfo;

import java.util.List;

public interface MailService {
    /**
     * 保存邮件
     * @param emailInfo
     * @return
     */
    int savaSendInfo(EmailInfo emailInfo);

    /**
     * 分页查询邮件信息
     * @param thisPage
     * @param pageSize
     * @return
     */
    List<EmailInfoDto> findPageAllEmail(int thisPage, int pageSize);
}
