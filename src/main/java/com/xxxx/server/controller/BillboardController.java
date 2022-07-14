package com.xxxx.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.common.base.BaseController;
import com.xxxx.server.common.utils.R;
import com.xxxx.server.pojo.Billboard;
import com.xxxx.server.service.IBillboardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 全站公告 前端控制器
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/billboard")
public class BillboardController extends BaseController {

    @Autowired
    private IBillboardService billboardService;

    @ApiOperation("获取公告板内容")
    @GetMapping("/show")
    public R getNotices(){
        List<Billboard> list = billboardService.list(new QueryWrapper<Billboard>().eq("show",true));
        return R.ok().put("data",list.get(list.size()-1)) ;
    }

}
