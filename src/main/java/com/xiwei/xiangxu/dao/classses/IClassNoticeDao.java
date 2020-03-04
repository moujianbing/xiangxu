package com.xiwei.xiangxu.dao.classses;

import com.xiwei.xiangxu.entity.ClassNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:52
 */
@Mapper
public interface IClassNoticeDao {
    public ArrayList<ClassNotice> getAll(String classId,String classGradeId);
    public ClassNotice getOneById(String classNoticeId,String classId,String classGradeId);
    public int insertOne(ClassNotice classNotice);
    public int deleteOne(String classNoticeId);
}
