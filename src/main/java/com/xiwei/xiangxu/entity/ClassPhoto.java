package com.xiwei.xiangxu.entity;

import java.util.Date;

/**
 * @author limq7
 * @version 1.0
 * @date 2020/1/8 13:58
 */
public class ClassPhoto {

    private String classPhotoId;
    private String classPhotoSize;
    private String classPhotoContent;
    private Date classPhotoTime;
    private String classAlbumId;
    private String classPhotoPublisher;
    public ClassPhoto(){

    }

    public ClassPhoto(String classPhotoId, String classPhotoSize, String classPhotoContent, Date classPhotoTime, String classAlbumId, String classPhotoPublisher) {
        this.classPhotoId = classPhotoId;
        this.classPhotoSize = classPhotoSize;
        this.classPhotoContent = classPhotoContent;
        this.classPhotoTime = classPhotoTime;
        this.classAlbumId = classAlbumId;
        this.classPhotoPublisher = classPhotoPublisher;
    }

    public String getClassPhotoId() {
        return classPhotoId;
    }

    public void setClassPhotoId(String classPhotoId) {
        this.classPhotoId = classPhotoId;
    }

    public String getClassPhotoSize() {
        return classPhotoSize;
    }

    public void setClassPhotoSize(String classPhotoSize) {
        this.classPhotoSize = classPhotoSize;
    }

    public String getClassPhotoContent() {
        return classPhotoContent;
    }

    public void setClassPhotoContent(String classPhotoContent) {
        this.classPhotoContent = classPhotoContent;
    }

    public Date getClassPhotoTime() {
        return classPhotoTime;
    }

    public void setClassPhotoTime(Date classPhotoTime) {
        this.classPhotoTime = classPhotoTime;
    }

    public String getClassAlbumId() {
        return classAlbumId;
    }

    public void setClassAlbumId(String classAlbumId) {
        this.classAlbumId = classAlbumId;
    }

    public String getClassPhotoPublisher() {
        return classPhotoPublisher;
    }

    public void setClassPhotoPublisher(String classPhotoPublisher) {
        this.classPhotoPublisher = classPhotoPublisher;
    }

    @Override
    public String toString() {
        return "ClassPhoto{" +
                "classPhotoId='" + classPhotoId + '\'' +
                ", classPhotoSize='" + classPhotoSize + '\'' +
                ", classPhotoContent='" + classPhotoContent + '\'' +
                ", classPhotoTime=" + classPhotoTime +
                ", classAlbumId='" + classAlbumId + '\'' +
                ", classPhotoPublisher='" + classPhotoPublisher + '\'' +
                '}';
    }
}
