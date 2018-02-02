package com.lbh.Controller;

import com.lbh.Config.HelloConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Advancer on 2017/12/17 16:02.
 * auth: lbh
 */
@RestController
public class HelloController {

    @Autowired
    private HelloConfiguration configuration;

   // @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String hello(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        return "属性： "+ configuration.getAge()+": "+configuration.getName() + ", id: "+ id;
    }

}
