package com.ticknet.jjjzzzqqq.test;


import com.jjjzzzqqq.rpc.client.RpcClientProxy;
import com.ticknet.jjjzzzqqq.rpc.api.HelloObject;
import com.ticknet.jjjzzzqqq.rpc.api.HelloService;

/**
 * 测试用消费者（客户端）
 * @author ziyang
 */
public class TestClient {

    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }

}
