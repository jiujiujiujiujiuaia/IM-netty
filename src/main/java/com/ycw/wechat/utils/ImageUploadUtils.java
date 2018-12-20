package com.ycw.wechat.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author yuchunwei
 */
public class ImageUploadUtils {

    public static File base64ToFile(String base64Data,String filepath)throws Exception{
        String dataPrix = "";
        String data = "";
        File file;

        if(base64Data == null || "".equals(base64Data)){
            return null;
        }else{
            String [] d = base64Data.split("base64,");
            if(d != null && d.length == 2){
                dataPrix = d[0];
                data = d[1];
                file = new File(filepath+ "."+dataPrix.split("/")[1].replace(";",""));
            }else{
                return null;
            }
        }
        byte[] bs = Base64Utils.decodeFromString(data);
        FileUtils.writeByteArrayToFile(file,bs);
        return file;
    }

    public static MultipartFile fileToMultipart(File file) {
        try {
            // File转换成MutipartFile
            String filename = file.getName();
            String shuffix = filename.split("\\.")[1].replace(";","");
            FileInputStream inputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(filename, shuffix, "image/"+shuffix, inputStream);
            return multipartFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}   
