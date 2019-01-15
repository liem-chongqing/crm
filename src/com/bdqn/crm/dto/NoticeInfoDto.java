package com.bdqn.crm.dto;

import java.util.Date;

public class NoticeInfoDto {
    private Long id;
    private Long userId;
    private String item;
    private String content;
    private Date time;
    private Date endTime;
    private int used;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "NoticeInfoDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", item='" + item + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", endTime=" + endTime +
                ", used=" + used +
                ", userName='" + userName + '\'' +
                '}';
    }
}
