package com.lbh.Controller;

import com.lbh.Dao.UserRepository;
import com.lbh.Service.UserService;
import com.lbh.entity.User;
import com.lbh.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Advancer on 2017/12/29 10:36.
 * auth: lbh
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 查询用户的全部列表
     * @return
     */
    @GetMapping(value = "/getUsers")
    public List<User> getUserList(){
        logger.info("getUserList()");
       return userRepository.findAll();
    }

    /**
     * 新增一条记录
     * @param user
     * @return
     */
        @PostMapping(value = "/addUser")
    public Object addUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
           return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        user.setAge(user.getAge());
        user.setMoney(user.getMoney());

        return ResultUtils.success(userRepository.save(user));
    }

    /**
     * 查询一个用户
     * @param id
     * @return
     */
    @GetMapping(value = "/getUser/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userRepository.findOne(id);
    }

    /**
     * 更新一个用户
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/updUser/{id}")
    public User updUser(@PathVariable("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("age") String age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping(value = "/delUser/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userRepository.delete(id);
    }

    /**
     * 通过年龄来查询用户
     * @param age
     * @return
     */
    @GetMapping(value = "/findUserByAge/{age}")
    public List<User> findUserByAge(@PathVariable("age") String age){
        return userRepository.findUserByAge(age);
    }

    /**
     * 事务测试 写入两条数据
     */
    @PostMapping("/insertUserTwo")
    public void insertUserTwo(){
        userService.insertUsers();
    }

    /**
     * 根据id 查年龄
     * @param id
     */
    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        userService.getAge(id);
    }


    /**
     * 使用thymeleaf模板
     * @param model
     * @return
     *//*
    @RequestMapping("/")
    public String index(Model model){
        List<User> userlist = userRepository.findAll();
        User user = userRepository.findOne(3);
        model.addAttribute("user", user);
        model.addAttribute("users", userlist);
        return "index";
    }*/

    /*========================================================================*/



}
