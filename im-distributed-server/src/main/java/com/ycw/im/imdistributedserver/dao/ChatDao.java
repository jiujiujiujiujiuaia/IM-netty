package com.ycw.im.imdistributedserver.dao;

import com.ycw.im.imdistributedcom.pojo.ChatMsg;
import org.springframework.stereotype.Repository;

/**
 * @Author yuchunwei
 */
@Repository
public interface ChatDao {
    void insertMsg(ChatMsg msg);
}   
