package com.example.sentineldemo.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentineldemo.service.TestService;
import com.example.sentineldemo.util.ExceptionUtil;
import org.springframework.stereotype.Service;

/**
 * @Author yoda1990
 * @Description //TODO
 * @CreateTime 2022/2/15 15:47
 **/
@Service
public class TestServiceImpl implements TestService {

    @Override
    @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public void test() {
        System.out.println("Test");
    }

    @Override
    @SentinelResource(value = "hello", fallback = "helloFallback")
    public String hello(long s) {
        if (s < 0) {
            throw new IllegalArgumentException("invalid arg");
        }
        return String.format("Hello at %d", s);
    }

    @Override
    @SentinelResource(value = "helloAnother", defaultFallback = "defaultFallback",
            exceptionsToIgnore = {IllegalStateException.class})
    public String helloAnother(String name) {
        if (name == null || "bad".equals(name)) {
            throw new IllegalArgumentException("oops");
        }
        if ("foo".equals(name)) {
            throw new IllegalStateException("oops");
        }
        return "Hello, " + name;
    }

    @Override
    @SentinelResource(value = "degrade",blockHandler = "doOnBlock")
    public String degrade() {
        try {
            Thread.sleep(1); //为演示平均响应时间，让他睡500毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("oops");
        //return "degrade";
    }


    @Override
    @SentinelResource("paramFlow")
    public String paramFlow(String param,String param1) {
        return param;
    }

    public String doOnBlock(BlockException exception){
        return "降级了！";
    }

    public String helloFallback(long s, Throwable ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }

    public String defaultFallback() {
        System.out.println("Go to default fallback");
        return "default_fallback";
    }

}
