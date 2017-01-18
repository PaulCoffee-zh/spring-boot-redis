package com.akcomejf.cube.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		Map<String, Map<String, List<Long>>> map = reportChartsService.initRegChartData(dateList);
		EchartsData reg = new EchartsData();
		reg.setLegend(map.keySet());
		reg.setMap(map);
		reg.setRegSumMap(calLongSum(map));
		reg.setxAxis(dateList);
		JSONObject js = JSONObject.fromObject(reg);

		Map<String, Map<String, List<Double>>> investMap = reportChartsService.initInvestChartData(dateList);
		EchartsData invest = new EchartsData();
		invest.setLegend(map.keySet());
		invest.setInvestMap(investMap);
		invest.setxAxis(dateList);
		invest.setInvestSumMap(calSum(investMap));
		JSONObject investJs = JSONObject.fromObject(invest);
		view.addObject("jsdata", js);
		view.addObject("investData", investJs);
		view.setViewName("/charts");
		return view;
	}

	public Map<String, Map<String, Double>> calSum(Map<String, Map<String, List<Double>>> map) {
		Map<String, Map<String, Double>> resMap = new HashMap<String, Map<String, Double>>();
		Iterator<Entry<String, Map<String, List<Double>>>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map<String, Double> _resMap = new HashMap<String, Double>();
			Entry<String, Map<String, List<Double>>> entry = it.next();
			Map<String, List<Double>> _map = entry.getValue();
			Iterator<Entry<String, List<Double>>> _it = _map.entrySet().iterator();
			while (_it.hasNext()) {
				Entry<String, List<Double>> _entry = _it.next();
				List<Double> nums = _entry.getValue();
				Double sum = 0.0;
				for (Double num : nums) {
					sum += num;
				}
				_resMap.put(_entry.getKey(), sum);
			}
			resMap.put(entry.getKey(), _resMap);
		}
		return resMap;
	}
	public Map<String, Map<String, Long>> calLongSum(Map<String, Map<String, List<Long>>> map) {
		Map<String, Map<String, Long>> resMap = new HashMap<String, Map<String, Long>>();
		Iterator<Entry<String, Map<String, List<Long>>>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map<String, Long> _resMap = new HashMap<String, Long>();
			Entry<String, Map<String, List<Long>>> entry = it.next();
			Map<String, List<Long>> _map = entry.getValue();
			Iterator<Entry<String, List<Long>>> _it = _map.entrySet().iterator();
			while (_it.hasNext()) {
				Entry<String, List<Long>> _entry = _it.next();
				List<Long> nums = _entry.getValue();
				Long sum = 0L;
				for (Long num : nums) {
					sum += num;
				}
				_resMap.put(_entry.getKey(), sum);
			}
			resMap.put(entry.getKey(), _resMap);
		}
		return resMap;
	}

	@RequestMapping("/findByDate")
	@ResponseBody
	public JsonResult findByDate(String startDate, String endDate) {
		List<String> dateList = DateUtil.getBetweenDate(startDate, endDate, 5);
		Map<String, Map<String, List<Long>>> map = reportChartsService.initRegChartData(dateList);
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
		Map<String, Map<String, List<Long>>> map = reportChartsService.initRegChartData(dateList);
		EchartsData data = new EchartsData();
		data.setLegend(map.keySet());
		data.setMap(map);
		data.setxAxis(dateList);
		JSONObject js = JSONObject.fromObject(data);
		return jsonResultHelper.buildSuccessJsonResult(js);
	}

}
