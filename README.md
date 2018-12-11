# netty学习记录

## [cs结构](https://github.com/jiujiujiujiujiuaia/IM-netty/tree/master/src/main/java/com/ycw/im/ClientAndServer)

### 项目结构及逻辑
![](1.png)
![](2.png)

### 目前完成的功能
- 一对一单聊
- 群聊
- 服务器向所有在线用户推送系统消息（如那个用户登陆成功了，那个用户在线）
## [B/S结构](https://github.com/jiujiujiujiujiuaia/IM-netty/tree/master/src/main/java/com/ycw/im/BrowserAndClient)
- 简单的通过浏览器作客户端向服务器发起请求
- 使用websocket

## [仿照wechat](https://github.com/jiujiujiujiujiuaia/IM-netty/tree/master/src/main/java/com/ycw/wechat)
- 前端使用mui
- 后端整合springboot+netty+mybatis
12/11 整合完毕，开始登陆注册功能