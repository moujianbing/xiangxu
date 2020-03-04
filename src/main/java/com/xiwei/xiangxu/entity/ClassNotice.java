package com.xiwei.xiangxu.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:21
 */

public class ClassNotice {
    private String classNoticeId;
    private String classNoticeTittle;
    private String classNoticeContent;
    private String classNoticePublisher;
    private Date classNoticeTime;
    private String classId;
    private String classGradeId;
    public ClassNotice(){

    }

    public ClassNotice(String classNoticeId, String classNoticeTittle, String classNoticeContent, String classNoticePublisher, Date classNoticeTime, String classId, String classGradeId) {
        this.classNoticeId = classNoticeId;
        this.classNoticeTittle = classNoticeTittle;
        this.classNoticeContent = classNoticeContent;
        this.classNoticePublisher = classNoticePublisher;
        this.classNoticeTime = classNoticeTime;
        this.classId = classId;
        this.classGradeId = classGradeId;
    }

    public String getClassNoticeId() {
        return classNoticeId;
    }

    public void setClassNoticeId(String classNoticeId) {
        this.classNoticeId = classNoticeId;
    }

    public String getClassNoticeTittle() {
        return classNoticeTittle;
    }

    public void setClassNoticeTittle(String classNoticeTittle) {
        this.classNoticeTittle = classNoticeTittle;
    }

    public String getClassNoticeContent() {
        return classNoticeContent;
    }

    public void setClassNoticeContent(String classNoticeContent) {
        this.classNoticeContent = classNoticeContent;
    }

    public String getClassNoticePublisher() {
        return classNoticePublisher;
    }

    public void setClassNoticePublisher(String classNoticePublisher) {
        this.classNoticePublisher = classNoticePublisher;
    }

    public Date getClassNoticeTime() {
        return classNoticeTime;
    }

    public void setClassNoticeTime(Date classNoticeTime) {
        this.classNoticeTime = classNoticeTime;
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

    @Override
    public String toString() {
        return "ClassNotice{" +
                "classNoticeId='" + classNoticeId + '\'' +
                ", classNoticeTittle='" + classNoticeTittle + '\'' +
                ", classNoticeContent='" + classNoticeContent + '\'' +
                ", classNoticePublisher='" + classNoticePublisher + '\'' +
                ", classNoticeTime=" + classNoticeTime +
                ", classId='" + classId + '\'' +
                ", classGradeId='" + classGradeId + '\'' +
                '}';
    }
}
