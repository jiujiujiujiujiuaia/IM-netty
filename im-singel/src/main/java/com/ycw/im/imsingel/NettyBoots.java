package com.ycw.im.imsingel;

import com.ycw.im.imsingel.Mobilewechat.netty.Server;
import com.ycw.im.imsingel.Webwechat.web.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author yuchunwei
 * 在springboot上下文启动期间，启动netty服务器
 */
@Component
public class NettyBoots implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private WebSocketServer webNettyServer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            try {
                Server.getInstance().start(8088);
//                webNettyServer.build(3333);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
