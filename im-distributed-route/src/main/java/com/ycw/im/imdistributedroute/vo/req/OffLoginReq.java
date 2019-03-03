package com.ycw.im.imdistributedroute.vo.req;

import com.ycw.im.imdistributedcom.vo.req.BaseRequest;
import lombok.Data;

/**
 * @Author yuchunwei
 */
@Data
public class OffLoginReq extends BaseRequest {
    private long userId;
}   
