package com.xiwei.xiangxu.dao;

import com.xiwei.xiangxu.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/18 19:40
 */
@Mapper
public interface IStudentDao {
    public ArrayList<Student> getAll();
    public Student getOneById(String studentId);
    public Student updateOneById(String studentId);
}
