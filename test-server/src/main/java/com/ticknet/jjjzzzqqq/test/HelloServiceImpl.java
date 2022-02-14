package com.ticknet.jjjzzzqqq.test;

import com.ticknet.jjjzzzqqq.rpc.api.HelloObject;
import com.ticknet.jjjzzzqqq.rpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务端接口实现类
 */
public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
    @Override
    public String hello(HelloObject object) {
        logger.info("接收到：{}", object.getMessage());
        return "这是掉用的返回值，id=" + object.getId();
    }
}

