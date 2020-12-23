package com.mashibing.userconsumer;

import org.springframework.stereotype.Component;

import java.util.Map;

public class UserApiFallback implements UserApi {
    @Override
    public String alive() {
        return "服务降级了";
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }

}
