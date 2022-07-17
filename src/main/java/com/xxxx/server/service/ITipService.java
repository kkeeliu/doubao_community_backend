package com.xxxx.server.service;

import com.xxxx.server.pojo.Tip;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 每日赠言 服务类
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
public interface ITipService extends IService<Tip> {

    Tip getTipToday();
}
