package com.example.demo.controller;

import com.example.demo.entity.JsonResult;
import com.example.demo.entity.User;
import com.example.demo.enums.ErrCode;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/demo")
@RestController
public class UserController {
    //    测试MyException
    //    @PostMapping("/users")
    //    public JsonResult<Object> home() throws Exception {
    //        return ResponseHelper.ResponseOK();
    //    }
    @Autowired
    private UserService userService;

    //增加用户
    @PostMapping("/users")
    public JsonResult<List<User>> list() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三", 20));
        list.add(new User(2, "李四", 25));
        list.add(new User(3, "王五", 23));
        return new JsonResult<>(ErrCode.OK, list);
    }

    //新增用户
    @PostMapping
    @ResponseBody
    public JsonResult<User> saveUser(User user) {
            this.userService.save(user);
        return new JsonResult<>();
    }

    //通过ID删除用户
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public JsonResult<User> deleteUser(@PathVariable("id") int id) {
        this.userService.removeById(id);
        return new JsonResult<>();
    }

    //通过ID查询
    @GetMapping("/users/{id}")
    @ResponseBody
    public JsonResult<User> queryUserById(@PathVariable("id") int id) {
        Optional<User> opt1 = Optional.ofNullable(this.userService.getById(id));
        return new JsonResult<>(ErrCode.OK, opt1.get());
    }

    //更新用户信息
    @PutMapping("/users/{id}")
    @ResponseBody
    public JsonResult<User> updateUser(User user) {
            this.userService.updateById(user);
            return new JsonResult<>();
    }

}
