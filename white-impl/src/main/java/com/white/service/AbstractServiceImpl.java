package com.white.service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.white.bean.pagination.OrderDTO;
import com.white.bean.pagination.OrderablePaginationDTO;

import java.util.Iterator;
import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/8
 */
public abstract class AbstractServiceImpl {

    protected <E> List<E> executeQuery(OrderablePaginationDTO op, ISelect select) {
        if (op.getOrders() != null) {
            Iterator var = op.getOrders().iterator();
            while (var.hasNext()) {
                OrderDTO orderDTO = (OrderDTO) var.next();
                PageHelper.orderBy(String.format("%s %s", orderDTO.getPropertyName(), orderDTO.isDesc() ? "desc" : "asc"));
            }
        }
        Page<E> page = PageHelper.startPage(op.getPage(), op.getSize()).doSelectPage(select);
        op.setTotalCount((int) page.getTotal());
        return page.getResult();
    }
}
