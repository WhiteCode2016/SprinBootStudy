package com.white.web.controller;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.white.bean.pagination.DataTableDTO;
import com.white.bean.pagination.OrderDTO;
import com.white.bean.pagination.OrderablePaginationDTO;
import com.white.bean.pagination.PaginationResultDTO;
import com.white.domain.mapper.UserMapper;
import com.white.dto.UserDTO;
import com.white.dto.UserQueryDTO;
import com.white.entity.User;
import com.white.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/8
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    /*@ResponseBody
    @RequestMapping("/query")
    public PaginationResultDTO<UserDTO> query() {
        return userService.queryUsers(new OrderablePaginationDTO(3,1));
    }*/

    @RequestMapping("/query")
    public ModelAndView query() {
        return new ModelAndView("admin/user/userQuery");
    }

    @ResponseBody
    @RequestMapping(value = "/listByPage")
    public DataTableDTO<UserDTO> getListByPage(UserQueryDTO queryDTO, HttpServletRequest request) {
        //使用DataTables的属性接收分页数据
        DataTableDTO<UserDTO> dataTable = new DataTableDTO<>(request);
        //开始分页：PageHelper会处理接下来的第一个查询
        PageHelper.startPage(dataTable.getPage_num(), dataTable.getPage_size());
        //还是使用List，方便后期用到
        List<UserDTO> list = userService.queryUsersByCondition(queryDTO);

        //用PageInfo对结果进行包装
        PageInfo<UserDTO> pageInfo = new PageInfo<>(list);

        //封装数据给DataTables
        dataTable.setDraw(dataTable.getDraw());
        dataTable.setData(pageInfo.getList());
        dataTable.setRecordsTotal((int) pageInfo.getTotal());
        dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
        //返回数据到页面
        return dataTable;
    }
}
