package org.demo.sentinel.sentineldemo.demos.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author yoda1990
 * @Description //TODO
 * @CreateTime 2021/10/22 17:47
 **/
@Service
public class TestService {

    @SentinelResource("world")
    public String helloWorld() {
        // 资源中的逻辑
        return "hello world";
    }

}
