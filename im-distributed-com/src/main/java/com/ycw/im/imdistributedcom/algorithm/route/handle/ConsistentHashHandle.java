package com.ycw.im.imdistributedcom.algorithm.route.handle;

import com.ycw.im.imdistributedcom.algorithm.route.routeHandler;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author yuchunwei
 */
public class ConsistentHashHandle implements routeHandler {

    private TreeMap<Long,String> treeMap = new TreeMap<Long, String>() ;

    //虚拟节点数
    private static final int VIRTUAL_NODE_SIZE = 2 ;

    @Override
    public String getRoute(List<String> ips, String key) {
        for(String ip : ips){
            add(hash(ip),ip);
        }
        return getFirstNodeValue(key);
    }


    private String getFirstNodeValue(String value) {
        long hash = hash(value);
        System.out.println("value=" + value + " hash = " + hash);
        //获取比当前 key 大的部分数据
        SortedMap<Long, String> last = treeMap.tailMap(hash);
        if (!last.isEmpty()) {
            return last.get(last.firstKey());
        }
        return treeMap.firstEntry().getValue();
    }

    private void add(long key,String value){
        for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
            Long hash = hash("vir" + key + i);
            treeMap.put(hash,value);
        }
        treeMap.put(key, value);
    }

    // xxl_job hash算法
    private Long hash(String value){
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
        md5.reset();
        byte[] keyBytes = null;
        try {
            keyBytes = value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unknown string :" + value, e);
        }

        md5.update(keyBytes);
        byte[] digest = md5.digest();

        // hash code, Truncate to 32-bits
        long hashCode = ((long) (digest[3] & 0xFF) << 24)
                | ((long) (digest[2] & 0xFF) << 16)
                | ((long) (digest[1] & 0xFF) << 8)
                | (digest[0] & 0xFF);

        long truncateHashCode = hashCode & 0xffffffffL;
        return truncateHashCode;
    }

}
