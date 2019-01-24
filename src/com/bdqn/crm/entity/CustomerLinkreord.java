package com.bdqn.crm.entity;

import java.util.Date;

/**
 * 联系客户记录T_CUSTOMER_LINKREORD
 */
public class CustomerLinkreord {
    private Long id;
    private Long customerId;
    // 联系客户时间
    private Date time;
    // 联系客户的人
    private String whoLink;
    // 联系客户类型
    private String type;
    // 联系主题内容
    private String theme;
    // 确定下次联系客户的时间
    private Date nextTime;
    // 联系情况备注
    private String remark;
    private int used;


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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getWhoLink() {
        return whoLink;
    }

    public void setWhoLink(String whoLink) {
        this.whoLink = whoLink;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "CustomerLinkreord{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", time=" + time +
                ", whoLink='" + whoLink + '\'' +
                ", type='" + type + '\'' +
                ", theme='" + theme + '\'' +
                ", nextTime='" + nextTime + '\'' +
                ", remark='" + remark + '\'' +
                ", used=" + used +
                '}';
    }
}
