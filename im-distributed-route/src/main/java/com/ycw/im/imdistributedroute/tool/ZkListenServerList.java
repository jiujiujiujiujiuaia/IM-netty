package com.ycw.im.imdistributedroute.tool;

import com.ycw.im.imdistributedroute.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author yuchunwei
 */
public class ZkListenServerList implements Runnable {

    private Zktool zktool ;
    private AppConfig config;

    public ZkListenServerList() {
        zktool = SpringBeanFactory.getBean(Zktool.class) ;
        config = SpringBeanFactory.getBean(AppConfig.class) ;
    }

    @Override
    public void run() {
        zktool.subscribeEvent(config.getZkRoot());
    }
}
