package com.xiwei.xiangxu.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/1 17:41
 */
public class UploadImageUtil {
    public static Map<String,Object> uploadImage(MultipartFile file){
        Map<String ,Object> map=new HashMap<>();
        String msg="";
        String fileSize="";
        if(file.getSize()/1000>10000){
            msg="所传图片大小不能超过10M";
        }else {
            fileSize=file.getSize()/1000+"M";
            map.put("fileSize",fileSize);
            //判断上传文件格式
            String fileType = file.getContentType();
            if (fileType.equals("image/jpg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                String localUrl="D:\\MyStudy\\xiweiproject\\xiangxu01\\target\\classes\\static\\img";
                //获取文件名
                String fileName=file.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID()+suffixName;
                if (FileUtils.upload(file, localUrl, fileName)) {
                    //文件存放的相对路径(一般存放在数据库用于img标签的src)
                    String classAlbumImage="img/"+fileName;
                    map.put("photoName",classAlbumImage);
                    msg="图片上传成功";
                }
                else{
                    msg="图片上传失败";
                }

            }else {
                msg="图片格式不正确";
            }
        }
        if(file.isEmpty()){
            msg="图片上传成功";
            map.put("photoName","img/myalbum.png");
        }
        map.put("msg",msg);
        return map;
    }
}
