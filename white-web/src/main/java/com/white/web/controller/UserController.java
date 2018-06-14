package com.white.web.controller;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.javafx.binding.StringFormatter;
import com.white.bean.LabelValueBean;
import com.white.bean.ResultDTO;
import com.white.bean.pagination.DataTableDTO;
import com.white.bean.pagination.OrderDTO;
import com.white.bean.pagination.OrderablePaginationDTO;
import com.white.bean.pagination.PaginationResultDTO;
import com.white.domain.mapper.UserMapper;
import com.white.dto.UserDTO;
import com.white.dto.UserQueryDTO;
import com.white.entity.User;
import com.white.enums.CommonEnums;
import com.white.service.UserService;
import com.white.util.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/admin/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String USER_QUERY = "admin/user/userQuery";

    @Resource
    UserService userService;

    /*@ResponseBody
    @RequestMapping("/query")
    public PaginationResultDTO<UserDTO> query() {
        return userService.queryUsers(new OrderablePaginationDTO(3,1));
    }*/

    @RequestMapping
    public ModelAndView execute(@ModelAttribute("queryDTO") UserQueryDTO queryDTO) {
        ModelAndView mav = new ModelAndView(USER_QUERY);
        mav.addObject("queryDTO", queryDTO);
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public DataTableDTO<UserDTO> getListByPage(UserQueryDTO queryDTO, HttpServletRequest request, OrderablePaginationDTO orderablePaginationDTO) {
        /*System.out.println(orderablePaginationDTO.getPage() +" " +orderablePaginationDTO.getSize());
        //使用DataTables的属性接收分页数据
        DataTableDTO<UserDTO> dataTable = new DataTableDTO<>(request);
        //开始分页：PageHelper会处理接下来的第一个查询
        PageHelper.startPage(dataTable.getPage_num(), dataTable.getPage_size());
        //还是使用List，方便后期用到
        List<UserDTO> list = userService.queryUsers(queryDTO);

        //用PageInfo对结果进行包装
        PageInfo<UserDTO> pageInfo = new PageInfo<>(list);

        //封装数据给DataTables
        dataTable.setDraw(dataTable.getDraw());
        dataTable.setData(pageInfo.getList());
        dataTable.setRecordsTotal((int) pageInfo.getTotal());
        dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
        //返回数据到页面
        return dataTable;*/
        logger.info(String.format("当前页码:%s 每页大小:%s",orderablePaginationDTO.getPage(),orderablePaginationDTO.getSize()));
        logger.info(queryDTO.getUserName());
        PaginationResultDTO paginationResultDTO = userService.queryUsersByCondition(queryDTO,orderablePaginationDTO);
        return DataTableDTO.assemable(paginationResultDTO);
    }

    @ResponseBody
    @PostMapping("/delete")
    public ResultDTO<String> delete(@ModelAttribute("id") Long id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            return ResultDTO.reject(e.getMessage());
        }
        return ResultDTO.success();
    }

    /** 获取Enum List*/
    @ModelAttribute("lockedList")
    public List<LabelValueBean<String>> getUserTypes() {
        return EnumUtils.createLabelValueBeanList(CommonEnums.IF.class, getMessageSource(),true);
    }
}
