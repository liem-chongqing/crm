package com.bdqn.crm.entity;

import java.util.Date;

public class UserInfo {
    private Long id;
    private String departmentName;
    private String roleName;
    private int rolePower;
    private String name;
    private int sex;
    private String mobile;
    private int age;
    private String address;
    private String num;
    private String pwd;
    private String tel;
    private String idnum;
    private String email;
    private Date  createTime;
    private String createMan;
    private Date  updateTime;
    private String updateMan;
    private String hobby;
    private String diploma;
    private String bankCard;
    private String nation;
    private int married;
    private int used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRolePower() {
        return rolePower;
    }

    public void setRolePower(int rolePower) {
        this.rolePower = rolePower;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", rolePower=" + rolePower +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", num='" + num + '\'' +
                ", pwd='" + pwd + '\'' +
                ", tel='" + tel + '\'' +
                ", idnum='" + idnum + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", createMan='" + createMan + '\'' +
                ", updateTime=" + updateTime +
                ", updateMan='" + updateMan + '\'' +
                ", hobby='" + hobby + '\'' +
                ", diploma='" + diploma + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", nation='" + nation + '\'' +
                ", married=" + married +
                ", used=" + used +
                '}';
    }
}
