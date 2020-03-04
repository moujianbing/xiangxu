package com.xiwei.xiangxu.controller;

import com.xiwei.xiangxu.dao.IStudentDao;
import com.xiwei.xiangxu.dao.impl.StudentDaoImpl;
import com.xiwei.xiangxu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/15 14:52
 */
@Controller
public class LoginController {
    @Autowired
    IStudentDao studentDao=new StudentDaoImpl();
    @RequestMapping("/login")
    public String login(@RequestParam("studentId") String studentId,
                        @RequestParam("studentPassword") String studentPassword,
                        Map<String,Object> map, HttpSession session){
        System.out.println(studentId);
        Student student=studentDao.getOneById(studentId);
        Logger.getLogger(student.getStudentName());
        if(StringUtils.isEmpty(studentId) ||StringUtils.isEmpty(studentPassword)){
            map.put("msg","用户名或密码错误");
            return "login";
        }else {
            //防止表单多次提交，可以重定向到主页面
            session.setAttribute("student",student);
            return "redirect:/main.html";
        }

    }
}
