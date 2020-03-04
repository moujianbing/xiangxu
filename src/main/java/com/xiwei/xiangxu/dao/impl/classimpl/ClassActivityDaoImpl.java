package com.xiwei.xiangxu.dao.impl.classimpl;

import com.xiwei.xiangxu.dao.classses.IClassActivityDao;
import com.xiwei.xiangxu.dao.classses.IClassNoticeDao;
import com.xiwei.xiangxu.entity.ClassActivity;
import com.xiwei.xiangxu.entity.ClassNotice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:57
 */
public class ClassActivityDaoImpl implements IClassActivityDao {
    @Autowired
    public IClassActivityDao activityDao;

    @Override
    public ArrayList<ClassActivity> getAll(String classId, String classGradeId) {
        return activityDao.getAll(classId,classGradeId);
    }

    @Override
    public ClassActivity getOneById(String classActivityId) {
        return activityDao.getOneById(classActivityId);
    }

    @Override
    public int insertOne(ClassActivity classActivity) {
        return activityDao.insertOne(classActivity);
    }

    @Override
    public int deleteOne(String classActivityId) {
        return activityDao.deleteOne(classActivityId);
    }
}
