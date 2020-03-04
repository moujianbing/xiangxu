package com.xiwei.xiangxu.entity;

import java.util.Date;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/1 13:07
 */
public class ClassAlbum {
    private String classAlbumId;
    private String classAlbumName;
    private String classAlbumDesc;
    private Date classAlbumTime;
    private String classId;
    private String classGradeId;
    private String classAlbumPublisher;
    private String classAlbumImage;
    public ClassAlbum(){

    }

    public ClassAlbum(String classAlbumId, String classAlbumName, String classAlbumDesc, Date classAlbumTime, String classId, String classGradeId, String classAlbumPublisher, String classAlbumImage) {
        this.classAlbumId = classAlbumId;
        this.classAlbumName = classAlbumName;
        this.classAlbumDesc = classAlbumDesc;
        this.classAlbumTime = classAlbumTime;
        this.classId = classId;
        this.classGradeId = classGradeId;
        this.classAlbumPublisher = classAlbumPublisher;
        this.classAlbumImage = classAlbumImage;
    }
    public ClassAlbum(String classAlbumId,String classAlbumName,String classAlbumDesc,String classAlbumImage){
        this.classAlbumId = classAlbumId;
        this.classAlbumName = classAlbumName;
        this.classAlbumDesc = classAlbumDesc;
        this.classAlbumImage = classAlbumImage;
    }
    public String getClassAlbumId() {
        return classAlbumId;
    }

    public void setClassAlbumId(String classAlbumId) {
        this.classAlbumId = classAlbumId;
    }

    public String getClassAlbumName() {
        return classAlbumName;
    }

    public void setClassAlbumName(String classAlbumName) {
        this.classAlbumName = classAlbumName;
    }

    public String getClassAlbumDesc() {
        return classAlbumDesc;
    }

    public void setClassAlbumDesc(String classAlbumDesc) {
        this.classAlbumDesc = classAlbumDesc;
    }

    public Date getClassAlbumTime() {
        return classAlbumTime;
    }

    public void setClassAlbumTime(Date classAlbumTime) {
        this.classAlbumTime = classAlbumTime;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassGradeId() {
        return classGradeId;
    }

    public void setClassGradeId(String classGradeId) {
        this.classGradeId = classGradeId;
    }

    public String getClassAlbumPublisher() {
        return classAlbumPublisher;
    }

    public void setClassAlbumPublisher(String classAlbumPublisher) {
        this.classAlbumPublisher = classAlbumPublisher;
    }

    public String getClassAlbumImage() {
        return classAlbumImage;
    }

    public void setClassAlbumImage(String classAlbumImage) {
        this.classAlbumImage = classAlbumImage;
    }

    @Override
    public String toString() {
        return "ClassAlbum{" +
                "classAlbumId='" + classAlbumId + '\'' +
                ", classAlbumName='" + classAlbumName + '\'' +
                ", classAlbumDesc='" + classAlbumDesc + '\'' +
                ", classAlbumTime=" + classAlbumTime +
                ", classId='" + classId + '\'' +
                ", classGradeId='" + classGradeId + '\'' +
                ", classAlbumPublisher='" + classAlbumPublisher + '\'' +
                ", classAlbumImage='" + classAlbumImage + '\'' +
                '}';
    }
}
