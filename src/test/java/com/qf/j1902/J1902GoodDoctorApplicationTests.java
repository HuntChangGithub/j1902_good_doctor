package com.qf.j1902;

import com.qf.j1902.pojo.TDepartment;
import com.qf.j1902.service.TDepartmentService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class J1902GoodDoctorApplicationTests {
	@Autowired
	private TDepartmentService departmentService;
	@Test
	public void contextLoads() {
		Date date = new Date();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		String  startime =  time.format(date);
		System.out.println("----"+startime+"======");
	}

	@Test
	public void test1(){
		Md5Hash md5Hash = new Md5Hash("123boss",null,1024);
		String md5str = md5Hash.toString();
		System.out.println(md5str);
	}
	@Test
	public void test222(){
		List<TDepartment> departmentList = departmentService.getDepts();
		//departmentList.remove("其他");
		System.out.println(departmentList);
	}

}
