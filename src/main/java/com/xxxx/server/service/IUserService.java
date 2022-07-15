package com.xxxx.server.service;

import com.xxxx.server.common.utils.R;
import com.xxxx.server.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liuke
 * @since 2022-05-22
 */
public interface IUserService extends IService<User> {

    R login(String username, String password, HttpServletRequest request);

    User getCurrentUserInfoByUserName(String username);
}
