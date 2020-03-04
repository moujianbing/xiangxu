package com.xiwei.xiangxu;

import com.xiwei.xiangxu.dao.IStudentDao;
import com.xiwei.xiangxu.dao.classses.*;
import com.xiwei.xiangxu.dao.impl.StudentDaoImpl;
import com.xiwei.xiangxu.dao.impl.classimpl.*;
import com.xiwei.xiangxu.entity.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class XiangxuApplicationTests {
	@Autowired
	DataSource dataSource;
	@Autowired
	IStudentDao studentDao=new StudentDaoImpl();
	@Autowired
	IClassDao classDao=new ClassDaoImpl();
	@Autowired
	IClassNoticeDao noticeDao=new ClassNoticeDaoImpl();
	@Autowired
	IClassAlbumDao albumDao=new ClassAlbumDaoImpl();
	@Autowired
	IClassPhotoDao photoDao=new ClassPhotoDaoImpl();
	@Autowired
	IClassActivityDao activityDao=new ClassActivityDaoImpl();
	@Test
	void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection=dataSource.getConnection();
	}
	@Test
	void getStudentById(){
		String studentId="10383010001".trim();
		Student student=studentDao.getOneById(studentId);
		System.out.println(student);
	}
	@Test
	void getClasses(){
		ArrayList<Classes> classes=classDao.getAll();
		System.out.println(classes);
	}
	@Test
	void getClassesById(){
		String classId="103830100";
		String classGradeId="15";
		Classes classes=classDao.getOneById(classId,classGradeId);
		System.out.println(classes);
	}
	@Test
	void getClassNotice(){
		String classId="103830100";
		String classGradeId="15";
		ArrayList<ClassNotice> noticeArrayList=noticeDao.getAll(classId,classGradeId);
		System.out.println(noticeArrayList);
	}
	@Test
	void getClassNoticeById(){
		String classId="103830100";
		String classGradeId="15";
		String classNoticeId="notice1038301002019123001";
		ClassNotice classNotice=noticeDao.getOneById(classNoticeId,classId,classGradeId);
		System.out.println(classNotice);
	}
	@Test
	void getClassActivity(){
		String classId="103830100";
		String classGradeId="15";
		ArrayList<ClassActivity> activityList=activityDao.getAll(classId,classGradeId);
		System.out.println(activityList);
	}
	@Test
	void getClassActivityById(){
		String classActivityId="activity1038301002020010902291425";
		ClassActivity classActivity=activityDao.getOneById(classActivityId);
		System.out.println(classActivity);
	}
	@Test
	void insertOneActivity(){
		String classActivityId="activity1038301002020010902291427";
		 String classActivityName="班干选举";
		 String classActivityDesc="今天进行班干选举";
		 String classActivityTime="2020年1月11日16时20分";//活动举办时间
		 String classActivityAddr="B栋教学楼201";//活动地点
		 String classActivityPublisher="卞和龙";//发布者
		 String classActivityImag="class_01.png";
		String classId="103830100";
		String classGradeId="15";
		ClassActivity classActivity=new ClassActivity(classActivityId,classActivityName,classActivityDesc,classActivityTime,classActivityAddr,classActivityPublisher,classActivityImag,classId,classGradeId);
		int x=activityDao.insertOne(classActivity);
		Assert.assertEquals(1,x);
	}
	/*@Test
	void insertClassNotice(){
		//varchar(25)  'notice'+学校编码+学院编码+班级编码+时间+2位
		String classNoticeId="notice1038301002019123100";
		String classNoticeTittle="元旦晚会";
		String classNoticeContent="今天晚上将举行元旦晚会，希望大家届时光临！";
		Date classNoticeTime=new Date();
		String classId="103830100";
		String classGradeId="15";
		String classNoticePublisher="李旻琦";
		ClassNotice classNotice=new ClassNotice();
		classNotice.setClassGradeId(classGradeId);
		classNotice.setClassId(classId);
		classNotice.setClassNoticeContent(classNoticeContent);
		classNotice.setClassNoticeId(classNoticeId);
		classNotice.setClassNoticePublisher(classNoticePublisher);
		classNotice.setClassNoticeTittle(classNoticeTittle);
		classNotice.setClassNoticeTime(classNoticeTime);
		int result=noticeDao.insertOne(classNotice);
		Assert.assertEquals(result,1);
	}*/
	/*@Test
	void deleteClassNotice(){
		String classNoticeId="notice1038301002020010111071217".trim();
		int reslut=noticeDao.deleteOne(classNoticeId);
		Assert.assertEquals(1,reslut);
	}*/
	@Test
	void queryAllClassAlbum(){
		String classAlbumId="album1038301002020010111071217";
		String classId="103830100";
		String classGradeId="15";
		ArrayList<ClassAlbum> albumArrayList=albumDao.getAll(classId,classGradeId);
		System.out.println(albumArrayList);
	}
	@Test
	void queryOneClassAlbum(){
		String classAlbumId="album1038301002020010111071217";
		String classId="103830100";
		String classGradeId="15";
		ClassAlbum classAlbum=albumDao.getOneById(classAlbumId,classId,classGradeId);
		System.out.println(classAlbum);
	}
	@Test
	void queryClassPhoto(){
		String classAlbumId="album1038301002020010408431743";
		ArrayList<ClassPhoto> photoList=photoDao.getAll(classAlbumId);
		System.out.println(photoList);
	}
	/*@Test
	void addClassAlbum(){
		String classAlbumId="album1038301002020010111071217";
		String classAlbumName="朋友";
		String classAlbumImage="class_01.png";
		String classAlbumDesc="";
		String classAlbumPublisher="李旻琦";
		Date classAlbumTime=new Date();
		String classId="103830100";
		String classGradeId="15";
		ClassAlbum classAlbum=new ClassAlbum(classAlbumId,
				classAlbumName,classAlbumDesc,classAlbumTime,
				classId,classGradeId,classAlbumPublisher,classAlbumImage);
		int result=albumDao.insertOne(classAlbum);
		Assert.assertEquals(1,result);
	}*/
	public static void main(String[] args) {
		/*Random random=new Random();
		for (int i = 0; i <4 ; i++) {
			int x=random.nextInt(100);
			System.out.println(x);
		}*/
		Date date=new Date();
		Date date1=new Date();
		String time2=date1.getTime()+"";
		long time=date.getTime();
		String times = new SimpleDateFormat("yyyyMMdd").format(new Date());
		System.out.println(times);
		System.out.println(time2);
	}
}
