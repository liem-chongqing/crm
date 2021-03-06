package com.bdqn.crm.entity;

/**
 * 字典列表
 */
public class DicItem {

    private Long id;
    private Long typeId;
    private String name;
    private String remark;
    private int used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "DicItem{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", used=" + used +
                '}';
    }
}


