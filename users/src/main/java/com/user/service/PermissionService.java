package com.user.service;

import com.user.entity.SysPermission;

import java.util.List;

public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);

}
