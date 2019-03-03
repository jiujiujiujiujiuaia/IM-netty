package com.ycw.im.imsingel.Mobilewechat.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FileUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author yuchunwei
 */
public class ImageUploadUtils {

    public static File base64ToFile(String base64Data, String filepath) throws Exception {
        String dataPrix = "";
        String data = "";
        File file;

        if (base64Data == null || "".equals(base64Data)) {
            return null;
        } else {
            String[] d = base64Data.split("base64,");
            if (d != null && d.length == 2) {
                dataPrix = d[0];
                data = d[1];
                file = new File(filepath + "." + dataPrix.split("/")[1].replace(";", ""));
            } else {
                return null;
            }
        }
        byte[] bs = Base64Utils.decodeFromString(data);
        FileUtils.writeByteArrayToFile(file, bs);
        return file;
    }

    public static MultipartFile fileToMultipart(File file) {
        // File转换成MutipartFile
        String filename = file.getName();
        String shuffix = filename.split("\\.")[1].replace(";", "");
        //FileInputStream inputStream = new FileInputStream(file);
        // MultipartFile multipartFile = new MockMultipartFile(filename, shuffix, "image/"+shuffix, inputStream);
        FileItem item = createFileItem(filename, shuffix, file);
        MultipartFile multipartFile = new CommonsMultipartFile(item);
        return multipartFile;
    }

    public static FileItem createFileItem(String filename, String shuffix, File newfile) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        //s1是图片类型 s2是图片上传到七牛后缀
        //例如s1是image/png s2是faceBigImage/20190224203748519_80x80.png
        FileItem item = factory.createItem(filename, "image/" + shuffix, true, "png");
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }


}   
