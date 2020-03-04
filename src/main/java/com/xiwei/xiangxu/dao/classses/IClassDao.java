package com.xiwei.xiangxu.dao.classses;

import com.xiwei.xiangxu.entity.Classes;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 15:46
 */
@Mapper
public interface IClassDao {
    public ArrayList<Classes> getAll();
    public Classes getOneById(String classId,String classGradeId);
}
