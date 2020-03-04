package com.xiwei.xiangxu.entity;

import java.util.Date;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/18 19:32
 */
public class Student {
    private String studentId;
    private String studentName;
    private String studentPassword;
    private String studentRoleId;
    private String studentRoleName;
    private int studentSex;
    private Date studentBirth;
    private String studentPhoneNumber;
    private String studentImage;
    private int studentScore;
    private String universityId;
    private String universityName;
    private String collegeId;
    private String collegeName;
    private String classId;
    private String classGradeId;
    private String className;

    public Student(String studentId, String studentName, String studentPassword, String studentRoleId, String studentRoleName, int studentSex, Date studentBirth, String studentPhoneNumber, String studentImage, int studentScore, String universityId, String universityName, String collegeId, String collegeName, String classId, String classGradeId, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPassword = studentPassword;
        this.studentRoleId = studentRoleId;
        this.studentRoleName = studentRoleName;
        this.studentSex = studentSex;
        this.studentBirth = studentBirth;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentImage = studentImage;
        this.studentScore = studentScore;
        this.universityId = universityId;
        this.universityName = universityName;
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.classId = classId;
        this.classGradeId = classGradeId;
        this.className = className;
    }

    public Student(){

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentRoleId() {
        return studentRoleId;
    }

    public void setStudentRoleId(String studentRoleId) {
        this.studentRoleId = studentRoleId;
    }

    public String getStudentRoleName() {
        return studentRoleName;
    }

    public void setStudentRoleName(String studentRoleName) {
        this.studentRoleName = studentRoleName;
    }

    public int getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(int studentSex) {
        this.studentSex = studentSex;
    }

    public Date getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(Date studentBirth) {
        this.studentBirth = studentBirth;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentRoleId='" + studentRoleId + '\'' +
                ", studentRoleName='" + studentRoleName + '\'' +
                ", studentSex=" + studentSex +
                ", studentBirth=" + studentBirth +
                ", studentPhoneNumber='" + studentPhoneNumber + '\'' +
                ", studentImage='" + studentImage + '\'' +
                ", studentScore=" + studentScore +
                ", universityId='" + universityId + '\'' +
                ", universityName='" + universityName + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", classId='" + classId + '\'' +
                ", classGradeId='" + classGradeId + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
