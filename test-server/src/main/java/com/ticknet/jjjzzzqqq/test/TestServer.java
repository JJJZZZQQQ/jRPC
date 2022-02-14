package com.ticknet.jjjzzzqqq.test;


import com.jjjzzzqqq.rpc.server.RpcServer;
import com.ticknet.jjjzzzqqq.rpc.api.HelloService;

/**
 * 测试用服务提供方（服务端）
 * @author ziyang
 */
public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
        System.out.println("123456789");
    }

}
