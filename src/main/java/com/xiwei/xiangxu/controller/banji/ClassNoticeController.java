package com.xiwei.xiangxu.controller.banji;

import com.xiwei.xiangxu.dao.classses.IClassDao;
import com.xiwei.xiangxu.dao.classses.IClassNoticeDao;
import com.xiwei.xiangxu.dao.impl.classimpl.ClassDaoImpl;
import com.xiwei.xiangxu.dao.impl.classimpl.ClassNoticeDaoImpl;
import com.xiwei.xiangxu.entity.ClassNotice;
import com.xiwei.xiangxu.entity.Classes;
import com.xiwei.xiangxu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/31 13:14
 */
@Controller
public class ClassNoticeController {
    @Autowired
    IClassNoticeDao classNoticeDao=new ClassNoticeDaoImpl();
    @Autowired
    IClassDao classDao=new ClassDaoImpl();
    //新增一个通知
    @RequestMapping("/noticeAdd")
    public String noticeAdd(@RequestParam("classNoticeTittle") String classNoticeTittle,
                                 @RequestParam("classNoticeContent") String classNoticeContent,
                                 HttpServletRequest request, Map<String,Object> map){
        if(classNoticeTittle.equals("")||classNoticeContent.equals("")){
            return "redirect:/classView";
        }
        Object student=(Student)request.getSession().getAttribute("student");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        //varchar(25)  'notice'+学校编码+学院编码+班级编码+时间+2位
        Date classNoticeTime=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
        String time=format.format(classNoticeTime);
        Random random=new Random();
        int num=random.nextInt(100);
        String classNoticeId="notice"+((Student) student).getClassId()+time+num;
        String classId=((Student) student).getClassId();
        String classGradeId=((Student) student).getClassGradeId();
        String classNoticePublisher=((Student) student).getStudentName();
        ClassNotice classNotice=new ClassNotice(classNoticeId,classNoticeTittle,
                classNoticeContent,classNoticePublisher,classNoticeTime,classId,classGradeId);
        int result=classNoticeDao.insertOne(classNotice);
        ArrayList<ClassNotice> classNoticeArrayList=classNoticeDao.
                getAll(((Student) student).getClassId(),((Student) student).getClassGradeId());
        map.put("className",classes.getClassGradeId()+classes.getClassName());
        map.put("result","notice");
        map.put("classNotice",classNoticeArrayList);
        if(result==1){
            map.put("msg","ok");
        }else {
            map.put("msg","error");

        }
        return "classView";



    }
    @RequestMapping("/noticeDelete")
    public String noticeDelete(@RequestParam("classNoticeId") String classNoticeId){
        int result=classNoticeDao.deleteOne(classNoticeId);
        return "redirect:/classView";
    }

}
