package com.mashibing.userconsumer.hystrix;

import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserProviderFallbackFactory implements FallbackFactory<UserApi> {
    @Override
    public UserApi create(Throwable throwable) {
        return new UserApi() {
            @Override
            public String alive() {
                System.out.println(throwable);
                throwable.printStackTrace();
                System.out.println(ToStringBuilder.reflectionToString(throwable));
                return "UserProviderFallbackFactory";
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
        };
    }
}
