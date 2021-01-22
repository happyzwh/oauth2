package com.auth.remote.rest;

import com.auth.remote.dto.SysUser;
import com.common.request.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user",fallback = UserServiceBack.class)
public interface UserService {

    @PostMapping("/getByUsername")
    Result<SysUser> getByUsername(@RequestParam("username") String username);


}
