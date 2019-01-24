package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.MailDao;
import com.bdqn.crm.dto.EmailInfoDto;
import com.bdqn.crm.entity.EmailInfo;
import com.bdqn.crm.util.DBUtil;

import java.util.List;

public class MailDaoImpl implements MailDao {

    @Override
    public int savaSendInfo(EmailInfo emailInfo) {
        return DBUtil.insert("email_info",emailInfo);
    }

    @Override
    public List<EmailInfoDto> findPageAllEmail(int thisPage, int pageSize) {
        String sql = "SELECT ei.*, ci.email AS email,  ui.`name` AS userName FROM email_info ei, customer_info ci, user_info ui WHERE ei.customer_id=ci.id AND ei.user_id=ui.id ORDER BY time DESC LIMIT ?,?";
        return DBUtil.find(EmailInfoDto.class, sql, thisPage, pageSize);
    }

    @Override
    public EmailInfoDto getEmailInfoByMailId(Integer mailId) {
        String sql = "SELECT ei.*, ci.email AS email,  ui.`name` AS userName FROM email_info ei, customer_info ci, user_info ui WHERE ei.customer_id=ci.id AND ei.user_id=ui.id AND ei.id=?";
        return DBUtil.get(EmailInfoDto.class, sql, mailId);
    }

    @Override
    public int modifyMialSendStateByMailId(String state, Long id) {
        String sql = "UPDATE email_info SET state=? WHERE id=?";
        return DBUtil.update(sql, state, id);
    }


}
