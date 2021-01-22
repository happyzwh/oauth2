package com.auth.remote.rest;

import com.auth.remote.dto.SysPermission;
import com.common.request.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user",fallback = PermissionServiceBack.class)
public interface PermissionService {

    @PostMapping("/findAuthByUserId")
    Result<List<SysPermission>> findByUserId(@RequestParam("userId") Integer userId);
}
