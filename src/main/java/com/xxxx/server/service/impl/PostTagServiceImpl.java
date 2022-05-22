package com.xxxx.server.service.impl;

import com.xxxx.server.pojo.PostTag;
import com.xxxx.server.mapper.PostTagMapper;
import com.xxxx.server.service.IPostTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 话题-标签 中间表 服务实现类
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@Service
public class PostTagServiceImpl extends ServiceImpl<PostTagMapper, PostTag> implements IPostTagService {

}
