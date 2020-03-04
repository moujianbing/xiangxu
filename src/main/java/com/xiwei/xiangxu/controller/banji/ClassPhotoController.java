package com.xiwei.xiangxu.controller.banji;

import com.xiwei.xiangxu.dao.classses.IClassAlbumDao;
import com.xiwei.xiangxu.dao.classses.IClassDao;
import com.xiwei.xiangxu.dao.classses.IClassPhotoDao;
import com.xiwei.xiangxu.dao.impl.classimpl.ClassAlbumDaoImpl;
import com.xiwei.xiangxu.dao.impl.classimpl.ClassDaoImpl;
import com.xiwei.xiangxu.dao.impl.classimpl.ClassPhotoDaoImpl;
import com.xiwei.xiangxu.entity.ClassAlbum;
import com.xiwei.xiangxu.entity.ClassPhoto;
import com.xiwei.xiangxu.entity.Classes;
import com.xiwei.xiangxu.entity.Student;
import com.xiwei.xiangxu.utils.RandomTimeString;
import com.xiwei.xiangxu.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/8 14:59
 */
@Controller
public class ClassPhotoController {
    @Autowired
    IClassDao classDao=new ClassDaoImpl();
    @Autowired
    IClassAlbumDao classAlbumDao=new ClassAlbumDaoImpl();
    @Autowired
    IClassPhotoDao classPhotoDao=new ClassPhotoDaoImpl();
    @RequestMapping("/enterClassPhoto")
    public String enterClassAlbum(HttpServletRequest request,@RequestParam("classAlbumId") String classAlbumId, Map<String,Object> map){
        Object student=(Student)request.getSession().getAttribute("student");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        ArrayList<ClassPhoto> photoList=classPhotoDao.getAll(classAlbumId);
        //对照片列表整理后返回
        Map<String,Map<String,ArrayList<ClassPhoto>>> photoMap=new HashMap<>();
        for (int i = 0; i < photoList.size(); i++) {
            String classPhotoPublisher=photoList.get(i).getClassPhotoPublisher();
            String classPhotoTime = new SimpleDateFormat("yyyy年MM月dd日").format(photoList.get(i).getClassPhotoTime());
            if(photoMap.containsKey(classPhotoPublisher.trim())){
                Map<String,ArrayList<ClassPhoto>> timeMap=photoMap.get(classPhotoPublisher.trim());
                if(timeMap.containsKey(classPhotoTime)){
                    ArrayList<ClassPhoto> pList=timeMap.get(classPhotoTime);
                    pList.add(photoList.get(i));
                    timeMap.put(classPhotoTime,pList);
                }else {
                    ArrayList<ClassPhoto> pList=new ArrayList<>();
                    pList.add(photoList.get(i));
                    timeMap.put(classPhotoTime,pList);
                }
                photoMap.put(classPhotoPublisher,timeMap);
            }else {
                Map<String, ArrayList<ClassPhoto>> timeMap=new HashMap<>();
                ArrayList<ClassPhoto> pList=new ArrayList<>();
                pList.add(photoList.get(i));
                timeMap.put(classPhotoTime,pList);
                photoMap.put(classPhotoPublisher,timeMap);
            }
        }
        //获取当前相册
        ClassAlbum classAlbum=classAlbumDao.getOneById(classAlbumId,classes.getClassId(),classes.getClassGradeId());
        map.put("photoMap",photoMap);
        map.put("classAlbum",classAlbum);
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        return "classPhotoView";
    }
    @RequestMapping("/classPhotoAdd")
    public String classPhotoAdd(HttpServletRequest request
            ,@RequestParam("classAlbumId") String classAlbumId
            ,@RequestParam("files") MultipartFile[] files){
        if(files!=null){
            for (int i = 0; i <files.length; i++) {
                Map<String,Object> photoMap= UploadImageUtil.uploadImage(files[i]);
                if(photoMap.get("msg").equals("图片上传成功")){
                    //上传照片的人
                    Object student=(Student)request.getSession().getAttribute("student");
                    String classPhotoPublisher=((Student) student).getStudentName();
                    //照片路径
                    String classPhotoContent=(String) photoMap.get("photoName");
                    //上传照片的时间
                    Date classPhotoTime=new Date();
                    //创建照片ID
                    String time= RandomTimeString.getTimeString();
                    Random random=new Random();
                    int num=random.nextInt(100);
                    String classPhotoId="photo"+((Student) student).getClassId()+time+num;
                    //照片大小
                    String classPhotoSize=(String) photoMap.get("fileSize");
                    //数据组装
                    ClassPhoto classPhoto=new ClassPhoto(classPhotoId,classPhotoSize,classPhotoContent,classPhotoTime,classAlbumId,classPhotoPublisher);
                    classPhotoDao.insertOne(classPhoto);

                }
            }
        }
        return "redirect:/enterClassPhoto?classAlbumId="+classAlbumId;
    }
}
