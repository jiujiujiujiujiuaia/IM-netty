package com.ycw;

import com.ycw.wechat.netty.Server;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author yuchunwei
 * 在springboot上下文启动期间，启动netty服务器
 */
@Component
public class NettyBoots implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            try {
                Server.getInstance().start(8088);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
