package com.bdqn.crm.dto;

import java.util.List;

public class MenuModel {

    private String code;
    private String name;
    private String url;
    private String icon;
    private List<MenuModel> child;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuModel> getChild() {
        return child;
    }

    public void setChild(List<MenuModel> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "MenuModel{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", child=" + child +
                '}';
    }
}
