package com.ycw.im.imsingel.Webwechat.dao;


import com.ycw.im.imsingel.Webwechat.model.po.GroupInfo;

public interface GroupInfoDao {

    void loadGroupInfo();
    
    GroupInfo getByGroupId(String groupId);
}
