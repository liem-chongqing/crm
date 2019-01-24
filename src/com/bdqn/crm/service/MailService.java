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


    /**
     * 根据id得到邮件信息
     * @param mailId
     * @return
     */
    EmailInfoDto getEmailInfoByMailId(int mailId);


    /**
     * 修改邮件的发送状态
     * @param send
     * @param id
     * @return
     */
    int modifyMialSendStateByMailId(String send, Long id);
}
