package com.ycw.im.imdistributedroute.vo.req;

import com.ycw.im.imdistributedcom.vo.req.BaseRequest;
import lombok.Data;

import javax.annotation.security.DenyAll;

/**
 * @Author yuchunwei
 */
@Data
public class P2pChatMsg extends BaseRequest {
    private long sendUserId;
    private long receiveUserId;
    private String msg;
    private String userName;
}   
