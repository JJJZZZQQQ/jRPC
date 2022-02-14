package com.jjjzzzqqq.rpc.registry.impl;

import com.jjjzzzqqq.rpc.registry.ServiceRegistry;
import com.ticknet.jjjzzzqqq.enumeration.RpcError;
import com.ticknet.jjjzzzqqq.exception.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultServiceRegistryImpl implements ServiceRegistry {

    private static final Logger logger = LoggerFactory.getLogger(DefaultServiceRegistryImpl.class);
    //本地服务map表 key 为 服务接口名  value为服务实现类对象
    //一个接口只能有一个服务实现类对象
    private final Map<String, Object> serviceMap = new ConcurrentHashMap<>();

    private final Set<String> registeredServiceNameSet = ConcurrentHashMap.newKeySet();

    /**
     * 服务注册方法
     */
    @Override
    public synchronized <T> void register(T service) {
        //服务全类名
        String serviceName = service.getClass().getCanonicalName();
        //存在直接返回
        if(registeredServiceNameSet.contains(serviceName)) return;
        registeredServiceNameSet.add(serviceName);
        Class<?>[] interfaces = service.getClass().getInterfaces();
        if(interfaces.length == 0) {
            throw new RpcException(RpcError.SERVICE_NOT_IMPLEMENT_ANY_INTERFACE);
        }
        //一个服务实现类可能实现多个服务接口
        for(Class<?> i : interfaces) {
            serviceMap.put(i.getCanonicalName(), service);
        }
        logger.info("向接口: {} 注册服务: {}", interfaces, serviceName);
    }

    /**
     * 从map中获取 接口对应的服务实现类
     */
    @Override
    public synchronized Object getService(String serviceName) {
        Object service = serviceMap.get(serviceName);
        if(service == null) {
            throw new RpcException(RpcError.SERVICE_NOT_FOUND);
        }
        return service;
    }
}

