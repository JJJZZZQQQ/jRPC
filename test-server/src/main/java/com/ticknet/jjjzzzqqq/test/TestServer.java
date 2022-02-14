package com.ticknet.jjjzzzqqq.test;


import com.jjjzzzqqq.rpc.registry.ServiceRegistry;
import com.jjjzzzqqq.rpc.registry.impl.DefaultServiceRegistryImpl;
import com.jjjzzzqqq.rpc.server.RpcServer;
import com.ticknet.jjjzzzqqq.rpc.api.HelloService;

/**
 * 测试用服务提供方（服务端）
 * @author ziyang
 */
public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistryImpl();
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        try {
            rpcServer.register(helloService);
        } catch (Exception e) {
        //start方法要最后执行,因为会阻塞导致下面的方法无法运行
        } finally {
            rpcServer.start(9000);
        }

    }

}
