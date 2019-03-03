package com.ycw.im.imdistributedzk.thread;

import com.ycw.im.imdistributedzk.util.AppConfiguration;
import com.ycw.im.imdistributedzk.util.SpringBeanFactory;
import com.ycw.im.imdistributedzk.util.ZKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Function:
 *
 * @author ycw
 * @since JDK 1.8
 */
public class RegistryZK implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(RegistryZK.class);

    private ZKit zkUtil;

    private AppConfiguration appConfiguration;

    private String ip;
    private int port;

    public RegistryZK(String ip, int port) {
        this.ip = ip;
        this.port = port;
        zkUtil = SpringBeanFactory.getBean(ZKit.class);
        appConfiguration = SpringBeanFactory.getBean(AppConfiguration.class);
    }

    @Override
    public void run() {

        //创建父节点
        zkUtil.createRootNode();

        //是否要将自己注册到 ZK
        if (appConfiguration.isZkSwitch()) {
            String path = appConfiguration.getZkRoot() + "/ip-" + ip + ":" + port;
            zkUtil.createNode(path, path);
            logger.info("注册 zookeeper 成功，msg=[{}]", path);
        }

        //注册监听服务
        zkUtil.subscribeEvent(appConfiguration.getZkRoot());

    }
}