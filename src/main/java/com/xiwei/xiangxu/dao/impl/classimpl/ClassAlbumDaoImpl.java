package com.xiwei.xiangxu.dao.impl.classimpl;

import com.xiwei.xiangxu.dao.classses.IClassAlbumDao;
import com.xiwei.xiangxu.dao.classses.IClassNoticeDao;
import com.xiwei.xiangxu.entity.ClassAlbum;
import com.xiwei.xiangxu.entity.ClassNotice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:57
 */
public class ClassAlbumDaoImpl implements IClassAlbumDao {
    @Autowired
    public IClassAlbumDao albumDao;

    @Override
    public ArrayList<ClassAlbum> getAll(String classId, String classGradeId) {
        return albumDao.getAll(classId,classGradeId);
    }

    @Override
    public ClassAlbum getOneById(String classAlbumId, String classId, String classGradeId) {
        return albumDao.getOneById(classAlbumId,classId,classGradeId);
    }

    @Override
    public int insertOne(ClassAlbum classAlbum) {
        return albumDao.insertOne(classAlbum);
    }

    @Override
    public int deleteOne(String classAlbumId) {
        return albumDao.deleteOne(classAlbumId);
    }

    @Override
    public int updateOne(ClassAlbum classAlbum) {
        return albumDao.updateOne(classAlbum);
    }
}
