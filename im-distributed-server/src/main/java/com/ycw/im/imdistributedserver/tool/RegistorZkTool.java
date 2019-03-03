package com.ycw.im.imdistributedserver.tool;

import com.ycw.im.imdistributedserver.config.AppConfiguration;
import com.ycw.im.imdistributedserver.util.SpringFactory;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Author yuchunwei
 */
public class RegistorZkTool implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(RegistorZkTool.class);

    private String ip;
    private int nettyPort;
    private int httpPort;


    private AppConfiguration config;

    private ZKTool zkTool;

    public RegistorZkTool(String ip, int nettyPort, int httpPort) {
        this.ip = ip;
        this.httpPort = httpPort;
        this.nettyPort = nettyPort;
        config = SpringFactory.getBean(AppConfiguration.class);
        zkTool = SpringFactory.getBean(ZKTool.class);
    }


    @Override
    public void run() {
        zkTool.createRootNode();
        if (config.isZkSwitch()) {
            String path = config.getZkRoot() + "/ip-" + ip + ":" + httpPort + ":" + nettyPort;
            zkTool.createNode(path);
            logger.info("服务端注册到zookeeper成功，节点信息为{}", path);
        }
    }
}
