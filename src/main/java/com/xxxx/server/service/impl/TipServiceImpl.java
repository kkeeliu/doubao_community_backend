package com.xxxx.server.service.impl;

import com.xxxx.server.pojo.Tip;
import com.xxxx.server.mapper.TipMapper;
import com.xxxx.server.service.ITipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每日赠言 服务实现类
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@Service
public class TipServiceImpl extends ServiceImpl<TipMapper, Tip> implements ITipService {

}
