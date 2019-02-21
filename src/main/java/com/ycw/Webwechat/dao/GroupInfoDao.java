package com.ycw.Webwechat.dao;


import com.ycw.Webwechat.model.po.GroupInfo;

public interface GroupInfoDao {

    void loadGroupInfo();
    
    GroupInfo getByGroupId(String groupId);
}
