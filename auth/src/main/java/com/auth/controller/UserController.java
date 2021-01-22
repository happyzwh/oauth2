package com.auth.controller;


import com.auth.remote.dto.SysUser;
import com.auth.remote.rest.UserService;
import com.common.request.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户接口")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "/getByUsername")
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "请求失败")
    })
    @GetMapping(value = "/getByUsername")
    Result<SysUser> getByUsername(@RequestParam("username") String username){
        return Result.success(userService.getByUsername(username));
    }

}
