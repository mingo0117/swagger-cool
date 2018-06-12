package com.mingo.controller;

import com.mingo.constant.Global;
import com.mingo.exception.BizException;
import com.mingo.model.Result;
import com.mingo.model.User;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Author:mingo
 * Date:2018/5/23 13:46
 * Description:Swagger Test API，仅供参考
 *
 常用注解：
 - @Api()用于类；
 表示标识这个类是swagger的资源
 - @ApiOperation()用于方法；
 表示一个http请求的操作
 - @ApiParam()用于方法，参数，字段说明；
 表示对参数的添加元数据（说明或是否必填等）
 - @ApiModel()用于类
 表示对类进行说明，用于参数用实体类接收
 - @ApiModelProperty()用于方法，字段
 表示对model属性的说明或者数据操作更改
 - @ApiIgnore()用于类，方法，方法参数
 表示这个方法或者类被忽略
 - @ApiImplicitParam() 用于方法
 表示单独的请求参数
 - @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
 详见：https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X#quick-annotation-overview

 P.S：@APIxxxx中的required=true只代表页面必传。为防止绕过页面，后端仍然需要校验。可用本例中注解的方式做一些参数的基本校验
 *
 */
@Api(value = "Mingo Api", description = "Just as example")
@RequestMapping(value = "/api")
@RestController
public class OpenApi{


    @ApiOperation(value = "Create user", notes = "创建用户", tags = "user")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Result<User> saveUser(
            @ApiParam(required = true) @Validated @RequestBody User user,
            @ApiParam(value = "授权码", required = true) @RequestHeader(value = "authorization", required = true) String token) throws Exception{
        user.setId(System.currentTimeMillis());
        //mock service
        if(user.getFirstName().contains("1")){
            throw new BizException("ali_noway");//业务异常直接抛出
        }
        return Result.success(user);
    }

    @ApiOperation(value = "Modify user", notes = "修改用户", tags = "user")
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.PATCH)
    public Result<User> updateUser(
            @ApiParam(required=true) @PathVariable("uid") Long uid,
            @ApiParam(required=true) @Validated @RequestBody User user,
            @ApiParam(value = "授权码", required = true) @RequestHeader(value = "authorization", required = true) String token) throws Exception{
        user.setId(uid);
        //mock service err
        if(user.getFirstName().contains("明")){
            return Result.error(Global.BIZ_ERR,"biz.err.name.err");
        }
        return Result.success(user);
    }

    @ApiOperation(value = "Query user", notes = "查询用户", tags = "user")
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public Result<User> findUser(
            @ApiParam(required=true) @PathVariable("uid") Long uid,
            @ApiParam(value = "授权码", required = true) @RequestHeader(value = "authorization", required = true) String token) throws Exception{
        User user = new User();
        user.setId(uid);
        user.setEmail("mingo6666666@gmail.com");
        user.setLastName("明");
        user.setFirstName("哥");
        return Result.success(user);
    }

    @ApiOperation(value = "Delete user", notes = "删除用户", tags = "user")
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.DELETE)
    public Result<User> removeUser(
            @ApiParam(required=true) @PathVariable("uid") Long uid,
            @ApiParam(value = "授权码", required = true) @RequestHeader(value = "authorization", required = true) String token) throws Exception{
        User user = new User();
        user.setId(uid);
        user.setEmail("mingo6666666@gmail.com");
        user.setLastName("明");
        user.setFirstName("哥");
        return Result.success(user);
    }

}
