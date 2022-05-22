package com.xxxx.server.service.impl;

import com.xxxx.server.pojo.Post;
import com.xxxx.server.mapper.PostMapper;
import com.xxxx.server.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 话题表 服务实现类
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
