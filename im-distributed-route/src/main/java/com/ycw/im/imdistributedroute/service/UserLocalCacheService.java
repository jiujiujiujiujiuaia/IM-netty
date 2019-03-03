package com.ycw.im.imdistributedroute.service;

import com.ycw.im.imdistributedcom.pojo.UserInfo;
import com.ycw.im.imdistributedroute.vo.req.OffLoginReq;

/**
 * @Author yuchunwei
 */
public interface UserLocalCacheService {

    boolean isAlreadLogin(Long userId);

    boolean cacheLogin(UserInfo userInfo);

    boolean cacheOffLogin(OffLoginReq req);

    UserInfo getUserInfoById(Long userId);

}   
