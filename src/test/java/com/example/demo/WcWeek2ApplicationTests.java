package com.example.demo;

import java.io.File;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.example.demo.bean.Week2;
import com.tzh.utils.IOToFileUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WcWeek2ApplicationTests {
	@Resource
	private RedisTemplate<String, Object>redisTemplate;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test1() {
		File file = new  File(System.getProperty("user.dir")+"/src/test/java/test.txt");
		List<String> readFileByLinesList = IOToFileUtils.readFileByLinesList(file.getPath());
		BoundListOperations<String, Object> boundListOps = redisTemplate.boundListOps("weeklist");
		for (String string : readFileByLinesList) {
			String[] split = string.split("==");
			Week2 week2=new Week2();
			week2.setGid(Integer.parseInt(split[0]));
			week2.setGname(split[1]);
			week2.setAge(split[2]);
			if (split.length<4) {
				week2.setBfb("0");
			}else {
				week2.setBfb(split[3]);
			}
			
			Long leftPush = boundListOps.leftPush(week2);
			System.err.println(leftPush);
		}
		
	}
	@Test
	public void test2() {
		File file = new  File(System.getProperty("user.dir")+"/src/test/java/test.txt");
		List<String> readFileByLinesList = IOToFileUtils.readFileByLinesList(file.getPath());
		BoundZSetOperations<String, Object> boundZSetOps = redisTemplate.boundZSetOps("week2zset");
		for (String string : readFileByLinesList) {
			String[] split = string.split("==");
			Week2 week2=new Week2();
			week2.setGid(Integer.parseInt(split[0]));
			week2.setGname(split[1]);
			week2.setAge(split[2]);
			if (split.length<4) {
				week2.setBfb("0");
			}else {
				week2.setBfb(split[3]);
			}
			
			Long rank = boundZSetOps.rank(week2);
			System.out.println(rank);
		}
		
	}
}
