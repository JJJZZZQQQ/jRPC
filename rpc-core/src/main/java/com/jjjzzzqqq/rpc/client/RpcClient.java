package com.jjjzzzqqq.rpc.client;

import com.ticknet.jjjzzzqqq.entity.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 远程方法调用的消费者（客户端）
 * @author jjjzzzqqq
 * 采用Socket实现
 */
public class RpcClient {

    private static final Logger logger = LoggerFactory.getLogger(RpcClient.class);

    public Object sendRequest(RpcRequest rpcRequest, String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            //socket输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            //socket输入流
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            //输出流写入rpcRequest
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            //返回输入流中返回的结果
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error("调用时有错误发生：", e);
            return null;
        }
    }

}
