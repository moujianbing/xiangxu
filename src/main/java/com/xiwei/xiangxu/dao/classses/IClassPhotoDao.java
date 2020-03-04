package com.xiwei.xiangxu.dao.classses;

import com.xiwei.xiangxu.entity.ClassPhoto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:52
 */
@Mapper
public interface IClassPhotoDao {
    public ArrayList<ClassPhoto> getAll(String classAlbumId);
    public ClassPhoto getOneById(String classPhotoId);
    public int insertOne(ClassPhoto classPhoto);
    public int deletePhoto(String classAlbumId);
}
