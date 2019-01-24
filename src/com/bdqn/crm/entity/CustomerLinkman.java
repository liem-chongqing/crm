package com.bdqn.crm.entity;

/**
 * 客户联系人：跟踪联系客户的专员
 */
public class CustomerLinkman {

    private Long id;
    private Long customerId;
    private String name;
    private String sex;
    // 联系人职位
    private String job;
    // 联系人移动电话
    private String mobile;
    private int age;
    //联系人与客户之间的关系
    private String relation;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "customerLinkman{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", mobile='" + mobile + '\'' +
                ", age=" + age +
                ", relation='" + relation + '\'' +
                ", used=" + used +
                '}';
    }
}
