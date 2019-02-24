package com.ycw.im.imsingel.Mobilewechat.plugin;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.io.File;
import java.io.IOException;

/**
 * @Author yuchunwei
 */
public class QiNiuApi {
    private static final Object LOCK = new Object();
    private String key;
    private Auth auth;
    private UploadManager uploadManager;
    private static final String AK ="Miz3fGhzz7mzW4cVapwS4KtZLxY0olmNqdXUd_La";
    private static final String SK="C-12V0QS0IAE9aloOClMd9H97XXOBkhdr7RqvSUK";
    private static final String bucket="netty-chat3";

    private QiNiuApi(){
        auth = Auth.create(AK,SK);
        uploadManager = new UploadManager();
    }
    public static QiNiuApi getInstance(){
        synchronized (LOCK){
            return new QiNiuApi();
        }
    }

    public QiNiuApi withFileName(String key, QiniuUploadType type) {
        return withFileName(key,type.getPath());
    }

    private QiNiuApi withFileName(String key, String path) {
        this.key =path + key;
        System.out.println(this.key);
        return this;
    }

    private String getUpToken() {
        return this.auth.uploadToken(bucket, this.key, 3600L, new StringMap().put("insertOnly", Integer.valueOf(1)));
    }
    public String upload(byte[] byteArr) throws IOException {
        Response res = this.uploadManager.put(byteArr, this.key, getUpToken());
        return upload(res);
    }

    public String upload(File fileByte) throws IOException {
        Response res = this.uploadManager.put(fileByte, this.key, getUpToken());
        return upload(res);
    }
    private String upload(Response res) throws IOException {
        try {
            int status = res.statusCode;
            if (status == 200) {
                StringMap map = res.jsonToMap();
                System.out.println(String.valueOf(map.get("key")));
                return String.valueOf(map.get("key"));
            }
        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r);
        }
        return null;
    }


    public static void main(String[] args) {

    }
}   
