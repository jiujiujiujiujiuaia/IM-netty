package com.ycw.im.imdistributedroute.service.impl;

import com.ycw.im.imdistributedcom.pojo.UserInfo;
import com.ycw.im.imdistributedroute.service.UserLocalCacheService;
import com.ycw.im.imdistributedroute.vo.req.OffLoginReq;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yuchunwei
 */
@Service
public class UserLocalCacheImpl implements UserLocalCacheService {
    //本地缓存用户在线用户表
    private final Map<Long,UserInfo> USER_INFO_MAP = new ConcurrentHashMap<Long,UserInfo>(128);

    @Override
    public boolean cacheLogin(UserInfo userInfo) {
        USER_INFO_MAP.put(userInfo.getUserId(),userInfo);
        return true ;
    }

    @Override
    public boolean isAlreadLogin(Long userId) {
        if(USER_INFO_MAP.containsKey(userId)){
            return false ;
        }
        else return true;
    }

    @Override
    public boolean cacheOffLogin(OffLoginReq req) {
        if (USER_INFO_MAP.containsKey(req.getUserId())){
            USER_INFO_MAP.remove(req.getUserId());
        }
        return true;
    }

    @Override
    public UserInfo getUserInfoById(Long userId) {
        return USER_INFO_MAP.get(userId);
    }
}
