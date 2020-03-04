package com.xiwei.xiangxu.entity;

import java.util.Date;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 17:25
 */
public class ClassActivity {
    private String classActivityId;
    private String classActivityName;
    private String classActivityDesc;
    private String classActivityTime;//活动举办时间
    private String classActivityAddr;//活动地点
    private String classActivityPublisher;//发布者
    private String classActivityImag;
    private String classId;
    private String classGradeId;
    public ClassActivity(){

    }

    public ClassActivity(String classActivityId, String classActivityName, String classActivityDesc, String classActivityTime, String classActivityAddr, String classActivityPublisher, String classActivityImag, String classId, String classGradeId) {
        this.classActivityId = classActivityId;
        this.classActivityName = classActivityName;
        this.classActivityDesc = classActivityDesc;
        this.classActivityTime = classActivityTime;
        this.classActivityAddr = classActivityAddr;
        this.classActivityPublisher = classActivityPublisher;
        this.classActivityImag = classActivityImag;
        this.classId = classId;
        this.classGradeId = classGradeId;
    }

    public String getClassActivityId() {
        return classActivityId;
    }

    public void setClassActivityId(String classActivityId) {
        this.classActivityId = classActivityId;
    }

    public String getClassActivityName() {
        return classActivityName;
    }

    public void setClassActivityName(String classActivityName) {
        this.classActivityName = classActivityName;
    }

    public String getClassActivityDesc() {
        return classActivityDesc;
    }

    public void setClassActivityDesc(String classActivityDesc) {
        this.classActivityDesc = classActivityDesc;
    }

    public String getClassActivityTime() {
        return classActivityTime;
    }

    public void setClassActivityTime(String classActivityTime) {
        this.classActivityTime = classActivityTime;
    }

    public String getClassActivityAddr() {
        return classActivityAddr;
    }

    public void setClassActivityAddr(String classActivityAddr) {
        this.classActivityAddr = classActivityAddr;
    }

    public String getClassActivityPublisher() {
        return classActivityPublisher;
    }

    public void setClassActivityPublisher(String classActivityPublisher) {
        this.classActivityPublisher = classActivityPublisher;
    }

    public String getClassActivityImag() {
        return classActivityImag;
    }

    public void setClassActivityImag(String classActivityImag) {
        this.classActivityImag = classActivityImag;
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
        return "ClassActivity{" +
                "classActivityId='" + classActivityId + '\'' +
                ", classActivityName='" + classActivityName + '\'' +
                ", classActivityDesc='" + classActivityDesc + '\'' +
                ", classActivityTime=" + classActivityTime +
                ", classActivityAddr='" + classActivityAddr + '\'' +
                ", classActivityPublisher='" + classActivityPublisher + '\'' +
                ", classActivityImag='" + classActivityImag + '\'' +
                ", classId='" + classId + '\'' +
                ", classGradeId='" + classGradeId + '\'' +
                '}';
    }
}
