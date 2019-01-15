package com.bdqn.crm.dto;

/**
 * 字典列表
 */
public class DicItemDto {

    private Long id;
    private Long typeId;
    private String name;
    private String remark;
    private int used;

    // 扩展字段
    private String dicTypeName;

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


    public String getDicTypeName() {
        return dicTypeName;
    }

    public void setDicTypeName(String dicTypeName) {
        this.dicTypeName = dicTypeName;
    }

    @Override
    public String toString() {
        return "DicItem{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", used=" + used +
                ", dicTypeName='" + dicTypeName + '\'' +
                '}';
    }
}


