package com.ycw.im.imdistributedcom.pojo;

import lombok.Data;

/**
 * @Author yuchunwei
 */
@Data
public class UserInfo {
    private Long userId;
    private String userName;

    public UserInfo(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

}   
