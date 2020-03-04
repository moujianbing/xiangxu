package com.xiwei.xiangxu.dao.classses;

import com.xiwei.xiangxu.entity.ClassAlbum;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:52
 */
@Mapper
public interface IClassAlbumDao {
    public ArrayList<ClassAlbum> getAll(String classId, String classGradeId);
    public ClassAlbum getOneById(String classAlbumId, String classId, String classGradeId);
    public int insertOne(ClassAlbum classAlbum);
    public int deleteOne(String classAlbumId);
    public int updateOne(ClassAlbum classAlbum);
}
