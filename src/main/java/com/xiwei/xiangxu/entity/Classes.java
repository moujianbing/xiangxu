package com.xiwei.xiangxu.entity;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/30 15:20
 */
public class Classes {
    private String classId;
    private String classGradeId;
    private String className;
    private String classCounselor;
    public Classes(){

    }

    public Classes(String classId, String classGradeId, String className, String classCounselor) {
        this.classId = classId;
        this.classGradeId = classGradeId;
        this.className = className;
        this.classCounselor = classCounselor;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCounselor() {
        return classCounselor;
    }

    public void setClassCounselor(String classCounselor) {
        this.classCounselor = classCounselor;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId='" + classId + '\'' +
                ", classGradeId='" + classGradeId + '\'' +
                ", className='" + className + '\'' +
                ", classCounselor='" + classCounselor + '\'' +
                '}';
    }
}
