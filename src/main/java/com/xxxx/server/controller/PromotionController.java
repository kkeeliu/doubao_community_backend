package com.xxxx.server.controller;


import com.xxxx.server.common.utils.R;
import com.xxxx.server.pojo.Promotion;
import com.xxxx.server.service.IPromotionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 广告推广表 前端控制器
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/promotion")
public class PromotionController {


    @Autowired
    private IPromotionService promotionService;

    /**
     * 获取所有推广列表
     * @return
     */
    @ApiOperation("获取所有推广列表")
    @GetMapping("/list")
    public R list(){
        List<Promotion> list = promotionService.list();
        return R.ok().put("data",list);
    }

}
