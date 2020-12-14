package com.mashibing.eureka.consumer.contoller;

import com.google.inject.internal.cglib.core.$CollectionUtils;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    DiscoveryClient client;

    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient client2;

    @Autowired
    LoadBalancerClient lb;

    @GetMapping("/client")
    public String client(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        return "hi";
    }

    @GetMapping("/client2")
    public String client2(){
        List<InstanceInfo> instanceInfos = client2.getInstancesByVipAddress("provider", false);
        if (instanceInfos.size() > 0) {
            InstanceInfo instanceInfo = instanceInfos.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getHi";
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
                return responseEntity.getBody();
            }
        }
        return "client2";
    }

    @GetMapping("/client3")
    public String client3(){
        ServiceInstance instance = lb.choose("provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println("client3");
        return responseEntity.getBody();
    }
}
