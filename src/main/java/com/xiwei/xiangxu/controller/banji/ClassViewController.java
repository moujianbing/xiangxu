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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 15:16
 */
@Controller
public class ClassViewController {
    @Autowired
    IClassDao classDao=new ClassDaoImpl();
    @Autowired
    IClassNoticeDao classNoticeDao=new ClassNoticeDaoImpl();
    //进入班级界面
    @RequestMapping("/classView")
    public String enterClassView(HttpServletRequest request, Map<String,Object> map){
        Object student=(Student)request.getSession().getAttribute("student");
        Classes classes=classDao.getOneById(((Student) student).getClassId(),((Student) student).getClassGradeId());
        ArrayList<ClassNotice> classNoticeArrayList=classNoticeDao.getAll(((Student) student).getClassId(),((Student) student).getClassGradeId());
        if(null!=classes){
            map.put("className",classes.getClassGradeId()+classes.getClassName());
            map.put("result","notice");
            map.put("classNotice",classNoticeArrayList);
            return "classView";
        }else {
            return "/classView.html";
        }
    }
}
