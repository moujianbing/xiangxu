package com.xiwei.xiangxu.dao.impl.classimpl;

import com.xiwei.xiangxu.dao.classses.IClassPhotoDao;
import com.xiwei.xiangxu.entity.ClassPhoto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/8 14:19
 */
public class ClassPhotoDaoImpl implements IClassPhotoDao {
    @Autowired
    IClassPhotoDao classPhotoDao;
    @Override
    public ArrayList<ClassPhoto> getAll(String classAlbumId) {
        return classPhotoDao.getAll(classAlbumId);
    }

    @Override
    public ClassPhoto getOneById(String classPhotoId) {
        return classPhotoDao.getOneById(classPhotoId);
    }

    @Override
    public int insertOne(ClassPhoto classPhoto) {
        return classPhotoDao.insertOne(classPhoto);
    }

    @Override
    public int deletePhoto(String classAlbumId) {
        return classPhotoDao.deletePhoto(classAlbumId);
    }
}
