package com.akcomejf.cube.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.akcomejf.cube.domain.CharInvesEntity;
import com.akcomejf.cube.domain.ChartRegEntity;
import com.akcomejf.cube.enums.ChannelTypeEnum;
import com.akcomejf.cube.enums.SourceTypeEnum;
import com.akcomejf.cube.service.ReportChartsService;

import net.sf.json.JSONArray;

@Service
public class ReportChartsServiceImpl implements ReportChartsService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public Map<String, Map<String, List<Long>>> initRegChartData(List<String> dateList) {
		List<ChartRegEntity> dataList = getList("t_chart_reg_info");
		ChannelTypeEnum[] channelTypes = ChannelTypeEnum.values();
		SourceTypeEnum[] activities = SourceTypeEnum.values();
		// 组织数据结构：渠道-》活动-》数据集合
		Map<String, Map<String, List<ChartRegEntity>>> dateMap = new HashMap<String, Map<String, List<ChartRegEntity>>>();
		for (ChannelTypeEnum _enum : channelTypes) {
			Map<String, List<ChartRegEntity>> sourceMap = new HashMap<String, List<ChartRegEntity>>();
			for (SourceTypeEnum sourceType : activities) {
				List<ChartRegEntity> _list = new ArrayList<ChartRegEntity>();
				for (int i = 0; i < dataList.size(); i++) {
					ChartRegEntity entity = dataList.get(i);
					if (_enum.getCode().equals(entity.getChannelType())
							&& sourceType.getCode().equals(entity.getActivitySource())) {
						_list.add(entity);
					}
				}
				sourceMap.put(sourceType.getDesc(), _list);
			}
			dateMap.put(_enum.getName(), sourceMap);
		}

		// 组织数据结构：渠道->活动->时间序列集合
		Map<String, Map<String, List<Long>>> resMap = new HashMap<String, Map<String, List<Long>>>();
		Iterator<Entry<String, Map<String, List<ChartRegEntity>>>> iterator = dateMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Map<String, List<ChartRegEntity>>> _ma = iterator.next();
			Iterator<Entry<String, List<ChartRegEntity>>> sourceIt = _ma.getValue().entrySet().iterator();
			Map<String, List<Long>> _sourceMap = new HashMap<String, List<Long>>();
			while (sourceIt.hasNext()) {
				List<Long> regList = new ArrayList<Long>();
				Entry<String, List<ChartRegEntity>> sourceEntry = sourceIt.next();
				List<ChartRegEntity> list = sourceEntry.getValue();
				if (list.size() == 0) {
					for (int i = 0; i < dateList.size(); i++) {
						regList.add(0L);
					}
					_sourceMap.put(sourceEntry.getKey(), regList);
					continue;
				}

				for (String date : dateList) {
					Long regCount = 0L;
					for (ChartRegEntity reg : list) {
						if (date.equals(reg.getYearMonDay())) {
							regCount = reg.getRegCount();
						}
					}
					regList.add(regCount);
				}
				_sourceMap.put(sourceEntry.getKey(), regList);
			}
			resMap.put(_ma.getKey(), _sourceMap);
		}
		return resMap;
	}

	private List<ChartRegEntity> getList(String key) {
		ValueOperations<String, String> op = stringRedisTemplate.opsForValue();
		String val = op.get(key);
		JSONArray json_test = JSONArray.fromObject(val);
		List<ChartRegEntity> list = JSONArray.toList(json_test, ChartRegEntity.class);
		return list;
	}
	
	private List<CharInvesEntity> getInvestList(String key) {
		ValueOperations<String, String> op = stringRedisTemplate.opsForValue();
		String val = op.get(key);
		JSONArray json_test = JSONArray.fromObject(val);
		List<CharInvesEntity> list = JSONArray.toList(json_test, CharInvesEntity.class);
		return list;
	}

	@Override
	public Map<String, Map<String, List<Double>>> initInvestChartData(List<String> dateList) {
		List<CharInvesEntity> dataList = getInvestList("t_chart_inves_info");
		ChannelTypeEnum[] channelTypes = ChannelTypeEnum.values();
		SourceTypeEnum[] activities = SourceTypeEnum.values();
		// 组织数据结构：渠道-》活动-》数据集合
		Map<String, Map<String, List<CharInvesEntity>>> dateMap = new HashMap<String, Map<String, List<CharInvesEntity>>>();
		for (ChannelTypeEnum _enum : channelTypes) {
			Map<String, List<CharInvesEntity>> sourceMap = new HashMap<String, List<CharInvesEntity>>();
			for (SourceTypeEnum sourceType : activities) {
				List<CharInvesEntity> _list = new ArrayList<CharInvesEntity>();
				for (int i = 0; i < dataList.size(); i++) {
					CharInvesEntity entity = dataList.get(i);
					if (_enum.getCode().equals(entity.getChannelType())
							&& sourceType.getCode().equals(entity.getActivitySource())) {
						_list.add(entity);
					}
				}
				sourceMap.put(sourceType.getDesc(), _list);
			}
			dateMap.put(_enum.getName(), sourceMap);
		}

		// 组织数据结构：渠道->活动->时间序列集合
		Map<String, Map<String, List<Double>>> resMap = new HashMap<String, Map<String, List<Double>>>();
		Iterator<Entry<String, Map<String, List<CharInvesEntity>>>> iterator = dateMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Map<String, List<CharInvesEntity>>> _ma = iterator.next();
			Iterator<Entry<String, List<CharInvesEntity>>> sourceIt = _ma.getValue().entrySet().iterator();
			Map<String, List<Double>> _sourceMap = new HashMap<String, List<Double>>();
			while (sourceIt.hasNext()) {
				List<Double> regList = new ArrayList<Double>();
				Entry<String, List<CharInvesEntity>> sourceEntry = sourceIt.next();
				List<CharInvesEntity> list = sourceEntry.getValue();
				if (list.size() == 0) {
					for (int i = 0; i < dateList.size(); i++) {
						regList.add(0.0);
					}
					_sourceMap.put(sourceEntry.getKey(), regList);
					continue;
				}

				for (String date : dateList) {
					Double regCount = 0.0;
					for (CharInvesEntity reg : list) {
						if (date.equals(reg.getYearMonDay())) {
							regCount = reg.getInvesAmout();
						}
					}
					regList.add(regCount);
				}
				_sourceMap.put(sourceEntry.getKey(), regList);
			}
			resMap.put(_ma.getKey(), _sourceMap);
		}
		return resMap;
	}
}
