package com.ycw.im.imdistributedroute.tool;

import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yuchunwei
 */
//本地缓存存放可用路由信息
@Component
public class ServerRouteCache {
    @Autowired
    private LoadingCache<String,String> cache;

    @Autowired
    private Zktool zktool;

    private AtomicInteger index = new AtomicInteger(0);

    public void updateCache(List<String> strings){
        //删除所有
        cache.invalidateAll();

        for(String str : strings){
            add(str.split("-")[1]);
        }
    }

    private void add(String str){
        cache.put(str,str);
    }

    //如果cache中没有任何服务器，则添加节点至cache中
    private List<String> getAll(){
        List<String> list = new ArrayList<>(3);
        List<String> nodes = zktool.getAllNode();
        if(cache.size() == 0){
            for(String str : nodes){
                String key = str.split("-")[1];
                add(key);
            }
        }
        for(String str : nodes){
            list.add(str.split("-")[1]);
        }
        return list;
    }

    public String select(){
        List<String> allIp = getAll();
        if(allIp.size() == 0){
            throw new RuntimeException("后台服务器全部没有启动！！");
        }
        int size = allIp.size();

        //负载均衡算法，有时间可以改成负载均衡随机算法
        return allIp.get(index.incrementAndGet() % size);
    }



}   
