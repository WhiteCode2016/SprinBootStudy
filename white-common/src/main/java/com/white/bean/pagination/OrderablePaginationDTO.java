package com.white.bean.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/8
 */
public class OrderablePaginationDTO implements Serializable {
    /** 每页记录数 */
    private int size;
    /** 当前页码 */
    private int page;
    /** 总记录数 */
    private int totalCount;
    /** 排序 */
    private List<OrderDTO> orders;

    public OrderablePaginationDTO() {
        this(1, Integer.MAX_VALUE);
    }

    public OrderablePaginationDTO(int size, int page) {
        this.size = size;
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    /**
     * 增加Order
     * @param orderDTO
     */
    public void addOrder(OrderDTO orderDTO) {
        List<OrderDTO> orderDTOS = getOrders();
        if (orderDTOS == null) {
            orderDTOS = new ArrayList<>(1);
            setOrders(orderDTOS);
        }
        orderDTOS.add(orderDTO);
    }
}
