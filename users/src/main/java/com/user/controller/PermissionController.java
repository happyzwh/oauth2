package com.user.controller;

import com.common.request.Result;
import com.user.entity.SysPermission;
import com.user.service.PermissionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "权限接口")
@Slf4j
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/findAuthByUserId")
    Result<List<SysPermission>> findByUserId(@RequestParam("userId") Integer userId){
        return Result.success(permissionService.findByUserId(userId));
    }
}
