package com.ycw.wechat.service.impl;

import com.ycw.wechat.enums.AddFriendRequstEnum;
import com.ycw.wechat.mapper.FriendsRequestMapper;
import com.ycw.wechat.mapper.MyFriendsMapper;
import com.ycw.wechat.mapper.UsersMapper;
import com.ycw.wechat.plugin.QiNiuApi;
import com.ycw.wechat.plugin.QiniuUploadType;
import com.ycw.wechat.pojo.Users;
import com.ycw.wechat.pojo.bo.AddFriendRequst;
import com.ycw.wechat.pojo.bo.UserBo;
import com.ycw.wechat.pojo.vo.UserVoResult;
import com.ycw.wechat.service.UserService;
import com.ycw.wechat.pojo.DataResult;
import com.ycw.wechat.utils.ImageUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Author yuchunwei
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String IMAGEPATH = "C:\\Users\\yuchunwei\\Desktop\\wechatImage\\";
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private FriendsRequestMapper friendsRequestMapper;
    @Autowired
    private MyFriendsMapper myFriendsMapper;

    @Override
    public DataResult queryUsername(String username) {
        Users users = usersMapper.queryUsername(username);
        if(users != null){
            return DataResult.errorMsg("用户名已经存在");
        }
       return DataResult.ok("ok");
    }

    @Override
    public DataResult login(Users users) {
       UserVoResult userResult = usersMapper.login(users);
       if(userResult == null){
           return DataResult.errorMsg("用户名或密码错误");
       }
        System.out.println(userResult);
       return DataResult.ok(userResult);
    }

    @Override
    public DataResult registor(String username, String password) {
       usersMapper.registor(username,password);
       return DataResult.ok("注册成功");
    }
    @Override
    public DataResult setNickName(UserBo userBo){
        if(userBo.getUserId() !=null && !userBo.getUserId().equals(""))
        {
            usersMapper.updateNickName(userBo);
            return DataResult.ok(usersMapper.getUser(userBo));
        }
        return DataResult.errorMsg("用户还没有登陆");
    }
    @Override
    public DataResult upLoadImage(UserBo userBo) {
        UserVoResult result =null;
        String base64Data = userBo.getFaceData();
        String userId = userBo.getUserId();
        String filename = IMAGEPATH + userId + "\\faceImage";
        try{
            //把base64格式转成file存储到后台服务器中
            File file = ImageUploadUtils.base64ToFile(base64Data,filename);
            //把file转换成为multipartFile
            MultipartFile multipartFile = ImageUploadUtils.fileToMultipart(file);
            //图片名称，例如"20180112.png"
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String dateStr = sdf.format(new Date());
            String ImageName = dateStr+"_80x80" +"." +multipartFile.getOriginalFilename();
            //上传到七牛云,返回值为图片路径eg:faceImage/1.png
            String imageFile = QiNiuApi
                    .getInstance()
                    .withFileName(ImageName,QiniuUploadType.FACEBIGIMAGE)
                    .upload(file);
            if(imageFile !=null) {
                //当上传成功时，更新数据库中图片地址
                userBo.setFaceData(imageFile);
                usersMapper.updateImage(userBo);
                result = usersMapper.getUser(userBo);
                System.out.println("图片处理完成");
                return DataResult.ok(result);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            String messgae = e.getMessage();
            return DataResult.errorMsg("上传图片出错，错误信息:"+messgae);
        }
        return DataResult.errorMsg("未知错误");
    }

    @Override
    public DataResult searchFriend(AddFriendRequst requst){
        if(requst.getMyUserId() !=null && !requst.getMyUserId().equals("")){
             UserVoResult result = usersMapper.selecUserByUserName(requst.getFriendUsername());
             if(result != null){
                 return DataResult.ok(result);
             }
             return DataResult.errorMsg("没有这个用户");
        }
        return DataResult.errorMsg("请先登陆");
    }

    public static void main(String[] args) {

    }
}   
