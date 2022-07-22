package com.example.sentineldemo.service;

/**
 * @Author yoda1990
 * @Description //TODO
 * @CreateTime 2022/2/15 15:46
 **/
public interface TestService {


    void test();

    String hello(long s);

    String helloAnother(String name);

    String degrade();

    String paramFlow(String param,String param1);
}
