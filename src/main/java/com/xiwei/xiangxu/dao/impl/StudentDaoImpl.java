package com.xiwei.xiangxu.dao.impl;

import com.xiwei.xiangxu.dao.IStudentDao;
import com.xiwei.xiangxu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/18 19:44
 */
public class StudentDaoImpl implements IStudentDao {
    @Autowired
    IStudentDao studentDao;
    @Override
    public ArrayList<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student getOneById(String studentId) {
        return studentDao.getOneById(studentId);
    }

    @Override
    public Student updateOneById(String studentId) {
        return null;
    }
}
