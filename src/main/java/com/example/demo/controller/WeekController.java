package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.utils.PageUtils;

@Controller
public class WeekController {
	@Resource
	private RedisTemplate<String, Object>redisTemplate;
	@RequestMapping("list")
	public Object list(Model model,@RequestParam(defaultValue="1")long cpage) {
		BoundListOperations<String,Object> boundListOps = redisTemplate.boundListOps("weeklist");
		Map<String, Long> pageUtils = PageUtils.pageUtils(boundListOps.size(), cpage);
		List<Object> list = boundListOps.range(pageUtils.get("start"), pageUtils.get("end"));
		System.err.println(list);
		model.addAttribute("list", list);
		model.addAttribute("page", pageUtils);
		return "list";
	}
}
