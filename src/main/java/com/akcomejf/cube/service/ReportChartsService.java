package com.akcomejf.cube.service;

import java.util.List;
import java.util.Map;

public interface ReportChartsService {

	Map<String, Map<String, List<Long>>> initRegChartData(List<String> dateList);

	Map<String, Map<String, List<Double>>> initInvestChartData(List<String> dateList);

}
