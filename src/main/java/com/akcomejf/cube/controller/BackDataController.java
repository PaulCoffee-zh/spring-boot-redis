package com.akcomejf.cube.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.akcomejf.cube.domain.ChartRegEntity;
import com.akcomejf.cube.domain.EchartsData;
import com.akcomejf.cube.enums.ChannelTypeEnum;
import com.akcomejf.cube.enums.SourceTypeEnum;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/backData")
public class BackDataController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/charts.html")
//	@ResponseBody
	public ModelAndView getChartsData(ModelAndView view) {
		ValueOperations<String, String> op = stringRedisTemplate.opsForValue();
		String val = op.get("t_chart_reg_info");
		JSONArray json_test = JSONArray.fromObject(val);
		List<ChartRegEntity> list = JSONArray.toList(json_test, ChartRegEntity.class);
		view.addObject("list", json_test);
		ChannelTypeEnum[] activities = ChannelTypeEnum.values();
		List<String> actList = new ArrayList<String>();
		for(ChannelTypeEnum _enum: activities){
			actList.add(_enum.getName());
		}
		view.addObject("acts", actList);
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		for (ChannelTypeEnum _enum: activities) {
			List<Object> _list = new ArrayList<Object>();
			for(int i = 0; i < list.size(); i++){
				ChartRegEntity entity = list.get(i);
				if(_enum.getCode().equals(entity.getChannelType())){
					_list.add(entity.getRegCount());
				}
			}
			map.put(_enum.getName(), _list);
		}
		EchartsData data =new EchartsData();
		data.setLegend(actList);
		data.setSeries(map);
//		data.setxAxis(xAxis);
		view.addObject("data", data);
		JSONObject js = JSONObject.fromObject(data);
		view.addObject("jsdata", js);
		view.setViewName("charts");
		return view;
	}
	

}
