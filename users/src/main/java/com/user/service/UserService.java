package com.user.service;

import com.user.entity.SysUser;

public interface UserService {

    SysUser getByUsername(String username);
}
