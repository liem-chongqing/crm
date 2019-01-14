package com.bdqn.crm.entity;

/**
 * 分类信息表
 */
public class DicType {

    private long id;
    private String name;
    private String key;
    private String remark;
    private int used;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
        return "DicType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", remark='" + remark + '\'' +
                ", used=" + used +
                '}';
    }
}
