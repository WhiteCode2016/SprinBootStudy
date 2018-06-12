package com.white.bean;

import java.io.Serializable;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/12
 */
public class LabelValueBean<T> implements Serializable {
    private String label;
    private T value;

    public LabelValueBean() {
    }

    public LabelValueBean(String label, T value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
