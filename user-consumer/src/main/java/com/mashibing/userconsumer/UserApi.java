package com.mashibing.userconsumer;

import com.mashibing.userapi.RegisterApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "user-provider")
public interface UserApi extends RegisterApi {

    @GetMapping("alive")
    public String alive();

    @PostMapping("getById")
    public String getById(@RequestParam("id") Integer id);

    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);
    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);

}
