package com.xiwei.xiangxu.dao.impl.classimpl;

import com.xiwei.xiangxu.dao.classses.IClassNoticeDao;
import com.xiwei.xiangxu.entity.ClassNotice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:57
 */
public class ClassNoticeDaoImpl implements IClassNoticeDao{
    @Autowired
    public IClassNoticeDao noticeDao;

    @Override
    public ArrayList<ClassNotice> getAll(String classId, String classGradeId) {
        return noticeDao.getAll(classId,classGradeId);
    }

    @Override
    public ClassNotice getOneById(String classNoticeId, String classId, String classGradeId) {
        return noticeDao.getOneById(classNoticeId,classId,classGradeId);
    }

    @Override
    public int insertOne(ClassNotice classNotice) {
        return noticeDao.insertOne(classNotice);
    }

    @Override
    public int deleteOne(String classNoticeId) {
        return noticeDao.deleteOne(classNoticeId);
    }
}
