package com.white.bean.pagination;

import java.io.Serializable;

/**
 * 排序对象
 *
 * @author: White
 * @date: 2018/6/8
 */
public class OrderDTO implements Serializable {
    /** 属性名 */
    private String propertyName;
    /** 是否降序 */
    private boolean isDesc;

    public OrderDTO() {
    }

    public OrderDTO(String propertyName, boolean isDesc) {
        this.propertyName = propertyName;
        this.isDesc = isDesc;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isDesc() {
        return isDesc;
    }

    public void setDesc(boolean desc) {
        isDesc = desc;
    }
}
