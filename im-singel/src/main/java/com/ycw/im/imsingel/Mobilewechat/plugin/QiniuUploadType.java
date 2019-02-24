package com.ycw.im.imsingel.Mobilewechat.plugin;

public enum QiniuUploadType {
    FACEBIGIMAGE("faceBigImage/", FileConst.DEFAULT_IMG_WIDTH, FileConst.DEFAULT_IMG_HEIGHT, FileConst.DEFAULT_IMG_SIZE),
    FACEIMAGE("faceImage/", FileConst.DEFAULT_IMG_WIDTH, FileConst.DEFAULT_IMG_HEIGHT, FileConst.DEFAULT_IMG_SIZE),
    QRCODE("qrcode/", FileConst.DEFAULT_IMG_WIDTH, FileConst.DEFAULT_IMG_HEIGHT, FileConst.DEFAULT_IMG_SIZE);

    private String path;
    /**
     * 上传图片的宽度
     */
    private int[] width;
    /**
     * 上传图片的高度
     */
    private int[] height;
    /**
     * 上传图片的大小
     */
    private int[] size;

    QiniuUploadType(String path, int[] width, int[] height, int[] size) {
        this.path = path;
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public String getPath() {

        return path;
    }

    public int[] getWidth() {
        return width;
    }

    public int[] getHeight() {
        return height;
    }

    public int[] getSize() {
        return size;
    }
}
