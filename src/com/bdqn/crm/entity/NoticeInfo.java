package com.bdqn.crm.entity;

import com.bdqn.crm.dto.HouseInfoDto;
import com.bdqn.crm.service.CommonService;
import com.bdqn.crm.service.HouseService;
import com.bdqn.crm.service.impl.CommonServiceImpl;
import com.bdqn.crm.service.impl.HouseServiceImpl;
import com.bdqn.crm.servlet.BaseServlet;
import com.bdqn.crm.util.PageUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class NoticeInfo{
    private Long id;
    private Long userId;
    private String item;
    private String content;
    private Date time;
    private Date endTime;
    private int used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "NoticeInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", item='" + item + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", endTime=" + endTime +
                ", used=" + used +
                '}';
    }
}
