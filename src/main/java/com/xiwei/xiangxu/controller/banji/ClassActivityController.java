package com.xiwei.xiangxu.controller.banji;

import com.xiwei.xiangxu.dao.classses.IClassActivityDao;
import com.xiwei.xiangxu.dao.classses.IClassDao;
import com.xiwei.xiangxu.dao.impl.classimpl.ClassActivityDaoImpl;
import com.xiwei.xiangxu.dao.impl.classimpl.ClassDaoImpl;
import com.xiwei.xiangxu.entity.ClassActivity;
import com.xiwei.xiangxu.entity.ClassAlbum;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/10 17:15
 */
@Controller
public class ClassActivityController {
    @Autowired
    IClassDao classDao=new ClassDaoImpl();
    @Autowired
    IClassActivityDao activityDao=new ClassActivityDaoImpl();
    @RequestMapping("/enterClassActivity")
    public String enterClassActivity(HttpServletRequest request, Map<String,Object> map){
        Object student=(Student)request.getSession().getAttribute("student");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        ArrayList<ClassActivity> activityList=activityDao.getAll(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        map.put("result","activity");
        map.put("classActivity",activityList);
        return "classView";
    }
    @RequestMapping("/classActivityAdd")
    public String classActivityAdd(HttpServletRequest request,
                                   @RequestParam("activityName") String classActivityName,
                                   @RequestParam("activityDesc") String classActivityDesc,
                                   @RequestParam("activityTime") String classActivityTime,
                                   @RequestParam("activityAddr") String classActivityAddr,
                                   @RequestParam("activityPublisher") String classActivityPublisher,
                                   @RequestParam("activityImag") MultipartFile file,
                                   Map<String,Object> map
                                   ){
        Map<String ,Object> uploadImageMap= UploadImageUtil.uploadImage(file);
        Date classAlbumTime=new Date();//相册创建时间
        //创建相册的人
        Object student=(Student)request.getSession().getAttribute("student");
        //所属班级和年级
        String classId=((Student) student).getClassId();
        String classGradeId=((Student) student).getClassGradeId();
        //活动ID
        String time= RandomTimeString.getTimeString();
        Random random=new Random();
        int num=random.nextInt(100);
        String classActivityId="activity"+((Student) student).getClassId()+time+num;
        //获取相册封面图片的路径保存到数据库
        String classActivityImag= (String) uploadImageMap.get("photoName");
        //数据组装
        ClassActivity classActivity=new ClassActivity(classActivityId,classActivityName,classActivityDesc,classActivityTime,classActivityAddr,classActivityPublisher,classActivityImag,classId,classGradeId);
        String msg= (String) uploadImageMap.get("msg");
        if(msg.equals("图片上传成功")){
            int result=activityDao.insertOne(classActivity);
        }else {
            map.put("activityMsg",msg);
        }
        map.put("result","activity");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        ArrayList<ClassActivity> activityList=activityDao.getAll(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("classActivity",activityList);
        return "classView";
    }
}
