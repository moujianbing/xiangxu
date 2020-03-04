package com.xiwei.xiangxu.dao.classses;

import com.xiwei.xiangxu.entity.ClassActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/10 16:52
 */
@Mapper
public interface IClassActivityDao {
    public ArrayList<ClassActivity> getAll(String classId, String classGradeId);
    public ClassActivity getOneById(String classActivityId);
    public int insertOne(ClassActivity classActivity);
    public int deleteOne(String classActivityId);
}
