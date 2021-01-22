package com.auth.remote.rest;

import com.auth.remote.dto.SysPermission;
import com.common.request.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionServiceBack {

    Result<List<SysPermission>> findByUserId(Integer userId){
        return Result.fail("timeout",null);
    }
}
