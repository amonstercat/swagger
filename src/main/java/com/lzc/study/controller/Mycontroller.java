package com.lzc.study.controller;


import com.lzc.study.annotation.Annotation4Swagger;
import com.lzc.study.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = "controller类测试") //用在请求类上 表示对类的说明
@RestController
public class Mycontroller {
    @ApiOperation("测试get方法")  //用在请求方法上，表示对方法的说明
    @GetMapping("/gettt")
    public String get()
    {
            return  "get";
    }
    @RequestMapping ("/reqqq")
    public String req()
    {
        return  "req";
    }
    @PostMapping("/posttt")
    @Annotation4Swagger
    public String post()
    {
        return  "post";
    }

    @RequestMapping("/testImplicitParam")
    @ApiImplicitParams(
            {
   @ApiImplicitParam(name = "name",value = "姓名",required = true,paramType = "query"),
   @ApiImplicitParam(name = "age",value = "年龄",required = true,paramType = "query",dataType ="Integer")

            }
    ) //用在请求方法上，表示对一组参数的说明
    public  String testImplicitParam(String name ,Integer age)
    {
     return  name+"————"+age;
    }

    @PostMapping("/adduser")
    @ApiOperation("测试实体类添加")
    public String addUser(User user)
    {
         return  user.getUname()+"——"+user.getUage();
    }

    @GetMapping("/user/{uid}")
    @ApiOperation("根据uid获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户编号",required = true,paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数未填好"),
            @ApiResponse(code = 404,message = "请求路径没有或跳转路径不对")
    })
    //URL中的 {xxx} 占位符可以通过@PathVariable(“xxx“) 绑定到操作方法的入参userid中。
    public  User load(@PathVariable("uid") Integer userid)
    {
      return  new User(userid,"mbappe",24);
    }

}
