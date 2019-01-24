package com.bdqn.crm.dto;

import java.util.Date;

/**
 * 客户关怀对象
 */
public class CustomerCareDto {

    private Long id;
    private Long customerId;
    private String theme; // 关怀主题
    private String way; //关怀方式
    private Date time; // 关怀时间
    private String remark; // 关怀备注
    private Date nextTime; //下次关怀时间
    private String people; // 关怀人
    private int used; //数据状态（1有效，0无效）

    // 扩展字段
    private String customerName;

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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    @Override
    public String toString() {
        return "CustomerCareDto{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", theme='" + theme + '\'' +
                ", way='" + way + '\'' +
                ", time=" + time +
                ", remark='" + remark + '\'' +
                ", nextTime=" + nextTime +
                ", people='" + people + '\'' +
                ", used=" + used +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
