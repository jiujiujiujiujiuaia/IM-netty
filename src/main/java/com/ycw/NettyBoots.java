package com.ycw;

import com.ycw.wechat.netty.Server;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author yuchunwei
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
