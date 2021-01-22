package com.auth.remote.rest;

import com.auth.remote.dto.SysUser;
import com.common.request.Result;
import org.springframework.stereotype.Component;

@Component
public class UserServiceBack {

    Result<SysUser> getByUsername(String userName){
       return Result.fail("timeout",null);
    }
}
