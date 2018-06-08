package com.white.bean.pagination;

import java.io.Serializable;
import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/8
 */
public class BootStrapTableDTO<T> implements Serializable {
    // 当前页码
    private int pageNumber = 1;
    // 每页数据量
    private int pageSize = 10;
    // 总条数
    private Integer total;
    // 当前显示的数据
    private List<T> rows;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public static <T> BootStrapTableDTO<T> assemable(PaginationResultDTO<T> paginationResultDTO) {
        BootStrapTableDTO<T> result = new BootStrapTableDTO<>();
        if (paginationResultDTO.getResult() != null) {
            result.setRows(paginationResultDTO.getResult());
        }
        result.setTotal(paginationResultDTO.getTotalCount());
        return result;
    }
}
