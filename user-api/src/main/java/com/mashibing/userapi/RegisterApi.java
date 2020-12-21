package com.mashibing.userapi;

import org.springframework.web.bind.annotation.*;

public interface RegisterApi {

    //@GetMapping("alive")
    public String alive();

    //@RequestMapping(value = "getById",method = RequestMethod.POST)
    //public String getById(@RequestParam("id") Integer id);
    public String getById(Integer id);
}
