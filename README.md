 # jRPC-Framework

[![Build Status](https://travis-ci.com/CN-GuoZiyang/My-RPC-Framework.svg?branch=master)](https://travis-ci.com/CN-GuoZiyang/My-RPC-Framework)
![GitHub](https://img.shields.io/github/license/CN-GuoZiyang/My-RPC-Framework)
![jdk](https://img.shields.io/static/v1?label=oraclejdk&message=8&color=blue)

jRPC-Framework-V1.0

## 架构

消费者调用提供者的方式取决于消费者的客户端选择，如选用原生 Socket 则该步调用使用 BIO，如选用 Netty 方式则该步调用使用 NIO。如该调用有返回值，则提供者向消费者发送返回值的方式同理。

## 计划

-  V2.0 采用 Netty实现通信
-   V3.0 实现多种序列化算法
-   V4.0 基于Nacos实现服务注册与发现
-   v5.0 实现负载均衡算法
-  v6.0 基于注解实现服务注册(类似Dubbo)


## 项目模块概览

- **roc-api**	——	通用接口
- **rpc-common**	——	实体对象、工具类等公用类
- **rpc-core**	——	框架的核心实现
- **test-client**	——	测试用消费侧
- **test-server**	——	测试用提供侧

## LICENSE

My-RPC-Framework is under the MIT license. See the [LICENSE](https://github.com/CN-GuoZiyang/My-RPC-Framework/blob/master/LICENSE) file for details.
