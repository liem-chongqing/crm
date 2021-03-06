package com.bdqn.crm.dto;

import java.util.Date;

/**
 * 字典列表
 */
public class EmailInfoDto {

    private Long id;
    // 收件人id
    private Long customerId;
    // 发件人id
    private Long userId;
    // 邮件主题
    private String theme;
    // 发送内容
    private String content;
    // 发送时间
    private Date time;
    // 邮件状态: 0:已发送 1:未发送 2:存入草稿
    private int state;
    private int used;


    // 扩展字段
    private String email;
    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    @Override
    public String toString() {
        return "EmailInfoDto{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", userId=" + userId +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", state=" + state +
                ", used=" + used +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

}


