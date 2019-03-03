package com.ycw.im.imdistributedcom.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author yuchunwei
 */
@Data
public class BaseRequest {

    @ApiModelProperty(required = false, value = "唯一请求号", example = "1234567890")
    private String reqNo;

    @ApiModelProperty(required = false, value = "当前请求的时间戳", example = "0")
    private int timeStamp;

    public BaseRequest() {
        this.setTimeStamp((int) System.currentTimeMillis() / 1000);
    }

    private void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }


}   
