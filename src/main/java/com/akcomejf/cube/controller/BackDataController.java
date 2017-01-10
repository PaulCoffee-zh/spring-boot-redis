package com.akcomejf.cube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.akcomejf.cube.domain.CampaignBehaviorProfit;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/backData")
public class BackDataController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/chart.html")
	@ResponseBody
	public List<CampaignBehaviorProfit> getChartsData(){
		ValueOperations<String, String> op = stringRedisTemplate.opsForValue();
		op.set("akcomejf", "LeeSun");
		 JSONArray json_test = JSONArray.fromObject(op.get("t_camp_behavior"));
		 List<CampaignBehaviorProfit> list = JSONArray.toList(json_test, CampaignBehaviorProfit.class);
		 return list;
	}
	
}
