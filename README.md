

## 一·[仿照wechat](https://github.com/jiujiujiujiujiuaia/IM-netty/tree/master/src/main/java/com/ycw/wechat)
- 前端使用mui（写前端太麻烦了，所以前端就使用了集成度很高框架，使用现成api）
- 后端整合springboot+netty+mybatis
12/11 整合完毕，开始登陆注册功能
12/19 完成照片上传下载功能，但是碰到大图就会有明显卡顿，后台做一下处理，图片过大就缩小保存


## 二·脚手架(学习准备)
### （一）[cs结构](https://github.com/jiujiujiujiujiuaia/IM-netty/tree/master/src/main/java/com/ycw/im/ClientAndServer)

### 项目结构及逻辑
![](image/1.png)
![](image/2.png)

### 目前完成的功能
- 一对一单聊
- 群聊
- 服务器向所有在线用户推送系统消息（如那个用户登陆成功了，那个用户在线）
### （二）[B/S结构](https://github.com/jiujiujiujiujiuaia/IM-netty/tree/master/src/main/java/com/ycw/im/BrowserAndClient)
- 简单的通过浏览器作客户端向服务器发起请求
- 使用websocket

