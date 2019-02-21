package com.ycw.Webwechat.service;

import org.springframework.web.multipart.MultipartFile;
import com.ycw.Webwechat.model.vo.ResponseJson;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {

    ResponseJson upload(MultipartFile file, HttpServletRequest request);
}
