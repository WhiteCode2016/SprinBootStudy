package com.white.bean.pagination;

import com.white.bean.ResultDTO;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果对象
 *
 * @author: White
 * @date: 2018/6/8
 */
public class PaginationResultDTO<T> extends ResultDTO<List<T>> implements Serializable {

    /** 每页记录数 */
    private int size;
    /** 当前页码 */
    private int page;
    /** 总记录数*/
    private int totalCount;

    public PaginationResultDTO() {
    }

    public PaginationResultDTO(OrderablePaginationDTO op, List<T> result) {
        setResult(result);
        if (op != null) {
            setTotalCount(op.getTotalCount());
            setPage(op.getPage());
            setSize(op.getSize());
        } else {
            setTotalCount(0);
        }
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
}
