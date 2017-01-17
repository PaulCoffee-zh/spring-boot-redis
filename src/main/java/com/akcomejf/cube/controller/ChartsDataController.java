package com.akcomejf.cube.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.common.utils.bean.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.akcomejf.cube.domain.EchartsData;
import com.akcomejf.cube.service.ReportChartsService;
import com.akcomejf.cube.utils.DateUtil;
import com.akcomejf.cube.utils.JsonResultHelper;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/regData")
public class ChartsDataController {

	@Autowired
	private JsonResultHelper jsonResultHelper;
	
	@Autowired
	private ReportChartsService reportChartsService;


	@RequestMapping("/regChart.html")
	public ModelAndView getChartsData(ModelAndView view) {
		Date date = new Date();
		Date startDate = DateUtils.addMonths(date, -2);
		String startDateStr = DateUtil.formatDate(startDate.getTime(), "yyyyMMdd");
		String endDateStr = DateUtil.formatDate(date.getTime(), "yyyyMMdd");
		List<String> dateList = DateUtil.getBetweenDate(startDateStr, endDateStr, 5);
		Map<String, Map<String,List<Long>>> map = reportChartsService.initRegChartData(dateList);
		EchartsData reg = new EchartsData();
		reg.setLegend(map.keySet());
		reg.setMap(map);
		reg.setxAxis(dateList);
		JSONObject js = JSONObject.fromObject(reg);
		
		Map<String, Map<String,List<Double>>> investMap = reportChartsService.initInvestChartData(dateList);
		EchartsData invest = new EchartsData();
		invest.setLegend(map.keySet());
		invest.setInvestMap(investMap);
		invest.setxAxis(dateList);
		JSONObject investJs = JSONObject.fromObject(invest);
		view.addObject("jsdata", js);
		view.addObject("investData", investJs);
		view.setViewName("/charts");
		return view;
	}

	@RequestMapping("/findByDate")
	@ResponseBody
	public JsonResult findByDate(String startDate, String endDate) {
		List<String> dateList = DateUtil.getBetweenDate(startDate, endDate, 5);
		Map<String, Map<String,List<Long>>> map = reportChartsService.initRegChartData(dateList);
		EchartsData data = new EchartsData();
		data.setLegend(map.keySet());
		data.setMap(map);
		data.setxAxis(dateList);
		JSONObject js = JSONObject.fromObject(data);
		return jsonResultHelper.buildSuccessJsonResult(js);
	}

	@RequestMapping("/findByChannelType")
	@ResponseBody
	public JsonResult findByChannelType(String channelType) {
		Date date = new Date();
		Date startDate = DateUtils.addMonths(date, -2);
		String startDateStr = DateUtil.formatDate(startDate.getTime(), "yyyyMMdd");
		String endDateStr = DateUtil.formatDate(date.getTime(), "yyyyMMdd");
		List<String> dateList = DateUtil.getBetweenDate(startDateStr, endDateStr, 5);
		Map<String, Map<String,List<Long>>> map = reportChartsService.initRegChartData(dateList);
		EchartsData data = new EchartsData();
		data.setLegend(map.keySet());
		data.setMap(map);
		data.setxAxis(dateList);
		JSONObject js = JSONObject.fromObject(data);
		return jsonResultHelper.buildSuccessJsonResult(js);
	}

}
