package com.bdqn.crm.entity;

/**
 * 房屋信息
 */
public class HouseInfo {

    private Long id;
    private Long typeId;    // 房屋类型ID（户型）
    private Long userId;    // 用户ID
    private String address; // 房屋地址
    private int price;   // 房屋价格，单位M元/平米
    private String ambient;  // 房屋环境描述
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAmbient() {
        return ambient;
    }

    public void setAmbient(String ambient) {
        this.ambient = ambient;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", ambient='" + ambient + '\'' +
                ", used=" + used +
                '}';
    }
}


