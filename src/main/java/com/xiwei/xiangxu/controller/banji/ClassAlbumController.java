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
import com.xiwei.xiangxu.utils.FileUtils;
import com.xiwei.xiangxu.utils.ImageDeleteUtil;
import com.xiwei.xiangxu.utils.RandomTimeString;
import com.xiwei.xiangxu.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/1 12:34
 */
@Controller
public class ClassAlbumController {
    @Autowired
    IClassDao classDao=new ClassDaoImpl();
    @Autowired
    IClassAlbumDao classAlbumDao=new ClassAlbumDaoImpl();
    @Autowired
    IClassPhotoDao classPhotoDao=new ClassPhotoDaoImpl();
    @RequestMapping("/enterClassAlbum")
    public String enterClassAlbum(HttpServletRequest request, Map<String,Object> map){
        Object student=(Student)request.getSession().getAttribute("student");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        ArrayList<ClassAlbum> albumArrayList=classAlbumDao.getAll(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        map.put("result","album");
        map.put("classAlbum",albumArrayList);
        return "classView";
    }
    @RequestMapping("/albumAdd")
    public String albumAdd(HttpServletRequest request,
                           @RequestParam("classAlbumName") String classAlbumName,
                           @RequestParam("classAlbumDesc") String classAlbumDesc,
                           @RequestParam("classAlbumImage") MultipartFile file,
                           Map<String,Object> map) throws Exception{
        if(classAlbumDesc.equals("")||classAlbumDesc==null){
            classAlbumDesc="描述我的相册……";
        }
        Map<String ,Object> uploadImageMap= UploadImageUtil.uploadImage(file);
        Date classAlbumTime=new Date();//相册创建时间
        //创建相册的人
        Object student=(Student)request.getSession().getAttribute("student");
        String classNoticePublisher=((Student) student).getStudentName();
        //所属班级和年级
        String classId=((Student) student).getClassId();
        String classGradeId=((Student) student).getClassGradeId();
        //创建相册ID
        String time=RandomTimeString.getTimeString();
        Random random=new Random();
        int num=random.nextInt(100);
        String classAlbumId="album"+((Student) student).getClassId()+time+num;
        //获取相册封面图片的路径保存到数据库
        String classAlbumImage= (String) uploadImageMap.get("photoName");
        //数据组装
        ClassAlbum classAlbum=new ClassAlbum(classAlbumId,classAlbumName,classAlbumDesc,classAlbumTime,classId,classGradeId,classNoticePublisher,classAlbumImage);
        String msg= (String) uploadImageMap.get("msg");
        if(msg.equals("图片上传成功")){
            int result=classAlbumDao.insertOne(classAlbum);
        }else {
            map.put("albumMsg",msg);
        }
        map.put("result","album");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        ArrayList<ClassAlbum> albumArrayList=classAlbumDao.getAll(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("classAlbum",albumArrayList);
        return "redirect:/enterClassAlbum";
    }
    @RequestMapping("/albumModify")
    public String albumModify(HttpServletRequest request,
                           @RequestParam("classAlbumId") String classAlbumId,
                           @RequestParam("classAlbumName") String classAlbumName,
                           @RequestParam("classAlbumDesc") String classAlbumDesc,
                           @RequestParam("inputFile") MultipartFile file,
                           Map<String,Object> map) throws Exception{
        Object student=(Student)request.getSession().getAttribute("student");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        if(classAlbumDesc.equals("")||classAlbumDesc==null){
            classAlbumDesc="描述我的相册……";
        }
        //如果没有上传照片，说明还是之前的封面
        //获取相册封面图片的路径保存到数据库
        String msg="";
        String classAlbumImage="";
        if(file.isEmpty()){
            ClassAlbum classAlbum=classAlbumDao.getOneById(classAlbumId,classes.getClassId(),classes.getClassGradeId());
             classAlbumImage=classAlbum.getClassAlbumImage();
        }else {
            Map<String ,Object> uploadImageMap= UploadImageUtil.uploadImage(file);
             classAlbumImage= (String) uploadImageMap.get("photoName");
             msg= (String) uploadImageMap.get("msg");
        }
        //数据组装
        ClassAlbum classAlbum=new ClassAlbum(classAlbumId,classAlbumName,classAlbumDesc,classAlbumImage);
        if(msg.equals("图片上传成功")||msg.equals("")){
            int result=classAlbumDao.updateOne(classAlbum);
        }else {
            map.put("albumMsg",msg);
        }
        map.put("result","album");
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        ArrayList<ClassAlbum> albumArrayList=classAlbumDao.getAll(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("classAlbum",albumArrayList);
        return "redirect:/enterClassAlbum";
    }
    @RequestMapping("/enterAlbumModify")
    public String enterAlbumModify(HttpServletRequest request,
                           @RequestParam("classAlbumId") String classAlbumId,
                           Map<String,Object> map) throws Exception{
        Object student=(Student)request.getSession().getAttribute("student");
        ClassAlbum classAlbum=classAlbumDao.getOneById(classAlbumId,((Student) student).getClassId(),((Student) student).getClassGradeId());
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        map.put("classAlbum",classAlbum);
        return "/classes/modifyAlbum";
    }
    @RequestMapping("/albumDelete")
    public String albumDelete(HttpServletRequest request,
                           @RequestParam("classAlbumId") String classAlbumId,
                           Map<String,Object> map) throws Exception{
        Object student=(Student)request.getSession().getAttribute("student");
        String classNoticePublisher=((Student) student).getStudentName();
        //先删除文件
        ClassAlbum classAlbum=classAlbumDao.getOneById(classAlbumId,((Student) student).getClassId(),((Student) student).getClassGradeId());
        String fileName=classAlbum.getClassAlbumImage();
        ImageDeleteUtil.deleteImage(fileName);
        //删除数据库记录
        classAlbumDao.deleteOne(classAlbumId);

        //删除相册的同时要删除该相册下的所有图片
        ArrayList<ClassPhoto> photoList=classPhotoDao.getAll(classAlbumId);
        for (int i = 0; i <photoList.size(); i++) {
            String name=photoList.get(i).getClassPhotoContent();
            ImageDeleteUtil.deleteImage(name);
        }
        classPhotoDao.deletePhoto(classAlbumId);
        return "redirect:/enterClassAlbum";
    }
}
