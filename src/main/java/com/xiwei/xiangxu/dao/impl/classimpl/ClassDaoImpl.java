package com.xiwei.xiangxu.dao.impl.classimpl;

import com.xiwei.xiangxu.dao.IStudentDao;
import com.xiwei.xiangxu.dao.classses.IClassDao;
import com.xiwei.xiangxu.entity.Classes;
import com.xiwei.xiangxu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 15:59
 */
public class ClassDaoImpl implements IClassDao {
    @Autowired
    public IClassDao classDao;

    @Override
    public ArrayList<Classes> getAll() {
        return classDao.getAll();
    }

    @Override
    public Classes getOneById(String classId, String classGradeId) {
        return classDao.getOneById(classId,classGradeId);
    }
}
