package com.akcomejf.cube.domain;

import java.util.List;
import java.util.Map;

public class EchartsData {
	
	private List<String> legend;
	
	private List<Object> xAxis;
	
	private List<Object> yAxis;
	
	private Map<String,List<Object>> series;

	public List<String> getLegend() {
		return legend;
	}

	public void setLegend(List<String> legend) {
		this.legend = legend;
	}

	public List<Object> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<Object> xAxis) {
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
