package com.xiwei.xiangxu.utils;

import java.io.File;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/9 11:54
 */
public class ImageDeleteUtil {
    public static void deleteImage(String fileName){
        File file=new File("D:\\MyStudy\\xiweiproject\\xiangxu01\\target\\classes\\static\\"+fileName);
        if(file.exists()){
            if(!fileName.equals("img/myalbum.png")){
                file.delete();
            }

        }
    }
}
