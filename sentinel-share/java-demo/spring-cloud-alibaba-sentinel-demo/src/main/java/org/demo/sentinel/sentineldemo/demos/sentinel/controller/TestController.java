package org.demo.sentinel.sentineldemo.demos.sentinel.controller;

import org.demo.sentinel.sentineldemo.demos.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yoda1990
 * @Description //TODO
 * @CreateTime 2021/10/22 17:49
 **/

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/hello-world")
    public String helloWorld(){
        return testService.helloWorld();
    }

}
