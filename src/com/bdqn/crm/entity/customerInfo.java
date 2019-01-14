package com.bdqn.crm.entity;

import java.util.Date;

public class customerInfo {
    private Long id;
    //客户状态ID，引用T_CUSTOMER_CONDITION表主键
    private Integer conditionId;
    // 客户来源ID，引用T_CUSTOMER_SOURCE表主键
    private Integer sourceId;
    //用户ID，负责员工ID，引用T_USER_INFO表主键
    private Long userId;
    //客户类型ID，引用T_CUSTOMER_TYPE表主键
    private Integer typeId;
    // 客户姓名
    private String name;
    // 客户性别
    private int sex;
    //客户移动电话
    private String mobile;
    //客户QQ
    private String qq;
    //客户地址
    private String address;
    //客户邮箱
    private String email;
    //客户备注
    private String remark;
    // 客户职位
    private String job;
    // 客户微博
    private String blog;
    // 客户固话
    private String tel;
    // 客户微信
    private String wechat;
    // 客户生日表
    private Date birthDay;
    // 数据创建时间
    private Date createTime;
    // 数据创建人
    private String createMan;
    // 数据修改时间
    private Date updateTime;
    // 数据修改人
    private String updateMan;
    // 客户公司
    private String company;
    private int used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateMan() {
        return updateMan;
    }

    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "customerInfo{" +
                "id=" + id +
                ", conditionId=" + conditionId +
                ", sourceId=" + sourceId +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", qq='" + qq + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", job='" + job + '\'' +
                ", blog='" + blog + '\'' +
                ", tel='" + tel + '\'' +
                ", wechat='" + wechat + '\'' +
                ", birthDay=" + birthDay +
                ", createTime=" + createTime +
                ", createMan='" + createMan + '\'' +
                ", updateTime=" + updateTime +
                ", updateMan='" + updateMan + '\'' +
                ", company='" + company + '\'' +
                ", used=" + used +
                '}';
    }
}
