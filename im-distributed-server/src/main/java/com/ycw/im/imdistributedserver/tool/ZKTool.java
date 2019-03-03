package com.ycw.im.imdistributedserver.tool;

import com.ycw.im.imdistributedserver.config.AppConfiguration;
import javafx.application.Application;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author yuchunwei
 */
@Component
public class ZKTool {

    @Autowired
    private ZkClient zkClient;

    @Autowired
    private AppConfiguration config;


    //写根节点
    public void createRootNode() {
        boolean exits = zkClient.exists(config.getZkRoot());
        if (exits) {
            return;
        }
        zkClient.createPersistent(config.getZkRoot());
    }

    //创建临时节点
    public void createNode(String path) {
        zkClient.createEphemeral(path);
    }
}   
