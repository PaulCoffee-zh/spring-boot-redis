package com.akcomejf.cube.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class EchartsData {

	private Set<String> legend;

	private List<String> xAxis;

	private List<Object> yAxis;

	private Map<String, List<Object>> series;

	private Map<String, Map<String, List<Long>>> map;
	
	private Map<String, Map<String, List<Double>>> investMap;

	private Integer sum;
	
	public Map<String, Map<String, List<Double>>> getInvestMap() {
		return investMap;
	}

	public void setInvestMap(Map<String, Map<String, List<Double>>> investMap) {
		this.investMap = investMap;
	}

	public Map<String, Map<String, List<Long>>> getMap() {
		return map;
	}

	public void setMap(Map<String, Map<String, List<Long>>> map) {
		this.map = map;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Set<String> getLegend() {
		return legend;
	}

	public void setLegend(Set<String> legend) {
		this.legend = legend;
	}

	public List<String> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}

	public List<Object> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<Object> yAxis) {
		this.yAxis = yAxis;
	}

	public Map<String, List<Object>> getSeries() {
		return series;
	}

	public void setSeries(Map<String, List<Object>> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return "EchartsData [legend=" + legend + ", xAxis=" + xAxis + ", yAxis=" + yAxis + ", series=" + series + "]";
	}

}
