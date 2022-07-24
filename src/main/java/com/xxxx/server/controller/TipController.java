package com.xxxx.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.common.utils.R;
import com.xxxx.server.pojo.Tip;
import com.xxxx.server.service.ITipService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 每日赠言 前端控制器
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/tip")
public class TipController {

    @Autowired
    private ITipService tipService;

    @ApiOperation("获取每日一句功能")
    @GetMapping("/today")
    public R getTipToday(){
        Tip tip = tipService.getTipToday();
        return R.ok().put("data",tip);
    }
}
