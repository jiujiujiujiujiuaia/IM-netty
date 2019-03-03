package com.ycw.im.imdistributedroute.tool;

import com.ycw.im.imdistributedroute.config.AppConfig;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @Author yuchunwei
 */
@Component
public class Zktool {
    private static Logger logger = LoggerFactory.getLogger(Zktool.class);

   @Autowired
   private AppConfig config;

    @Autowired
    private ZkClient buildZKClient;

    @Autowired
    private ServerRouteCache cache;

    public void subscribeEvent(String path){
        buildZKClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                //一旦zookeeper列表发生变化，就要更新本地路由缓存
                cache.updateCache(list);
                logger.info("【{}】路径下可用服务器列表更新为【{}】",path,list.toString());
            }
        });
    }

    public List<String> getAllNode(){
        List<String> list = buildZKClient.getChildren(config.getZkRoot());
        logger.info("查询可用服务器节点【{}】",list);
        return list ;
    }
}   
