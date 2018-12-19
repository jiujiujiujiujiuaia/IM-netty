package com.ycw.wechat.pojo;

/**
 * @Description: 自定义响应数据结构
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 */
public class DataResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    private String ok;	// 不使用

    public static DataResult build(Integer status, String msg, Object data) {
        return new DataResult(status, msg, data);
    }

    public static DataResult ok(Object data) {
        return new DataResult(data);
    }

    public static DataResult ok() {
        return new DataResult(null);
    }
    
    public static DataResult errorMsg(String msg) {
        return new DataResult(500, msg, null);
    }
    
    public static DataResult errorMap(Object data) {
        return new DataResult(501, "error", data);
    }
    
    public static DataResult errorTokenMsg(String msg) {
        return new DataResult(502, msg, null);
    }
    
    public static DataResult errorException(String msg) {
        return new DataResult(555, msg, null);
    }

    public DataResult() {

    }

//    public static LeeJSONResult build(Integer status, String msg) {
//        return new LeeJSONResult(status, msg, null);
//    }

    public DataResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public DataResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

}
