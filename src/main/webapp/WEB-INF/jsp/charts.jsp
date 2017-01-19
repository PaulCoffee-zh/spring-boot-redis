<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx }/css/charts.css" />
<%@ include file="/common/header.jsp"%>
<style>
.tooltip {
	position: absolute;
	font-size: 12px;
	border: 1px solid #e3eaf0;
	padding: 3px;
	display: none;
	color: #597a96;
	border-radius: 5px;
	max-width: 200px;
}

body {
	background-color: #191a2c;
}
</style>
<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
</head>
<body>
	<div class="ysmf-mainWrap clearfix">
		<div class="sideNav left">
			<h1>易数魔方</h1>
			<div class="filter current">
				<div class="navListOne">
					<a>数据分析</a>
				</div>
				<ul class="navListTwo">
					<li><a href="${ctx }/regData/regChart.html ">推广汇总</a></li>
<!-- 					<li><a>二级菜单</a></li> -->
<!-- 					<li><a>二级菜单</a></li> -->
				</ul>
			</div>
<!-- 			<div class="filter"> -->
<!-- 				<div class="navListOne"> -->
<!-- 					<a>一级菜单</a> -->
<!-- 				</div> -->
<!-- 				<ul class="navListTwo"> -->
<!-- 					<li><a>二级菜单</a></li> -->
<!-- 					<li><a>二级菜单</a></li> -->
<!-- 					<li><a>二级菜单</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
		</div>
		<div class="mainContent right">
			<div class="Nav">
				<ul class="NavList right">
					<li><a href="<c:url value='/logout' />">注销</a></li>
					<li><a>刷新</a></li>
				</ul>
				<div class="userName right">
					欢迎光临，<span><sec:authentication property="principal.fullname"/></span>
				</div>
			</div>
			<div class="prefilter">
				<h2>筛选项</h2>
				<div class="item1">
					<span style="display: inline;">开始时间</span>
					<div class="date form_datetime" data-date-format="yyyymmdd"
						style="display: inline-block">
						<input size="50" type="text" value="" id="startDate"> <span
							class="add-on" style="display: inline-block"><i
							class="icon-th"></i></span>&nbsp;&nbsp;
					</div>
				</div>
				<div class="item1">
					<span style="display: inline;">结束时间</span>
					<div class="controls input-append date form_datetime"
						data-date-format="yyyymmdd" style="display: inline-block">
						<input size="50" type="text" value="" id="endDate"> <span
							class="add-on" style="display: inline-block"><i
							class="icon-th"></i></span>&nbsp;&nbsp;
					</div>
				</div>
				<button class="searchBtn" onclick="reloadCharts()">查询</button>
			</div>
			<div class="chartlistCon">
				<div class="tabItem">
					<ul class="tabItemList">
						<li class="active">图表</li>
						<li>列表</li>
					</ul>
					<div class="contentBox">
						<div class="contentBox-list contentShow charBox-list">
							<div class="topBox clearfix">
								<div class="sidebarNum left">
									<ul class="numItemList">
										<li>
											<h3>注册总量</h3>
											<div class="numDesc regCount">
												<span ></span>
												<p class="omg"></p>
											</div>
										</li>
										<li>
											<h3>投资总量</h3>
											<div class="numDesc investCount">
												<span>￥506700</span>
												<p class="omg"></p>
											</div>
										</li>
<!-- 										<li> -->
<!-- 											<h3>标题</h3> -->
<!-- 											<div class="numDesc"> -->
<!-- 												<span>$506700</span> -->
<!-- 												<p class="omg">描述描述描述描述描述描述描述描述描述描述描述描述描述描述描</p> -->
<!-- 											</div> -->
<!-- 										</li> -->
<!-- 										<li> -->
<!-- 											<h3>标题</h3> -->
<!-- 											<div class="numDesc"> -->
<!-- 												<span>$506700</span> -->
<!-- 												<p class="omg">描述描述描述描述描述描述描述描述描述</p> -->
<!-- 											</div> -->
<!-- 										</li> -->
									</ul>
								</div>
								<div class="mainChart left">
									<div class="mainChartDown">
										<div class="chartArea">
											<div id="lineRegChart" style="width: 100%; height: 100%;"></div>
										</div>
									</div>
									<div class="mainChartDown">
										<div class="chartArea">
											<div id="lineInvestChart" style="width: 100%; height: 100%;"></div>
										</div>
									</div>
									<div class="mainChartTop" style="height:100%">
										<div class="ChartTopOne left" >
											<div class="chartArea" style="height:100%">
												<div id="pieChart" style="width: 100%; height: 100%;"></div>	
											</div>
										</div>
										<div class="ChartTopTwo right"  style="height:100%">
											<div class="chartArea">
													<div id="investPieChart" style="width: 100%; height: 100%;"></div>	
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="contentBox-list listBox-list">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx }/assets/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="${ctx }/assets/echarts/dark.js"></script>
	<script type="text/javascript" src="${ctx }/assets/echarts/infographic.js"></script>
	<script type="text/javascript" src="${ctx }/js/jsonsql-0.1.js"></script>
	<script src="${ctx }/assets/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="${ctx }/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script src="${ctx }/assets/js/date-time/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script src="${ctx }/assets/js/date-time/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<%-- 	<script type="text/javascript" src="${ctx }/js/lineCharts.js"></script> --%>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var mapS = ${jsdata.map};
		var dateArr = ${jsdata.xAxis}
		var legendArr = new Array();
		var seriesArr = new Array();
		var allRegSum = 0;
		$.each(mapS,function(key,values){
			var dataSrr = new Array();
			var _subSum = 0;
			for(var date = 0; date < dateArr.length; date++){
				var sum = 0;
				$.each(values,function(_key,_values){
					sum += _values[date];
					_subSum += _values[date];
				});
				dataSrr.push(sum);
			}
			allRegSum += _subSum;
			var _series = {
	            name : key,
	            type : 'line',
	            data : dataSrr
	        };
			seriesArr.push(_series);
			legendArr.push(key);
		});
		$(".regCount > span").html(allRegSum);
		
		var mapI = ${investData.investMap};
		var legendInvestArr = new Array();
		var seriesInvestArr = new Array();
		var allInvestSum = 0;
		$.each(mapI,function(key,values){
			var dataSrr = new Array();
			var _subSum = 0;
			for(var date = 0; date < dateArr.length; date++){
				var sum = 0;
				$.each(values,function(_key,_values){
					sum += _values[date];
					_subSum += _values[date];
				});
				dataSrr.push(sum);
			}
			allInvestSum += _subSum;
			var _series = {
	            name : key,
	            type : 'line',
	            data : dataSrr
	        };
			seriesInvestArr.push(_series);
			legendInvestArr.push(key);
		});
		$(".investCount > span").html("￥"+allInvestSum);
		jQuery(function ($) {
			 $.fn.datetimepicker.dates['zh-CN'] = {
			            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
			            daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
			            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
			            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
			            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "11月", "12月"],
			            today: "今天",
			            suffix: [],
			            meridiem: ["上午", "下午"]
	        };
			$('.form_datetime').datetimepicker({
	            language: 'zh-CN',
	            weekStart: 1,
	            todayBtn: 1,
	            autoclose: 1,
	            todayHighlight: 1,
	            startView: 2,
	            minView: 2,
	            forceParse: 0
	        });
			
		});
		//查询
		function reloadCharts(){
			var startDate = $("#startDate").val();
			var endDate = $("#endDate").val();
			$.post("${ctx}/regData/findByDate.json", {startDate:startDate,endDate:endDate}, function(msg){
				if(msg.code == 200){
					initLineCharts(msg.data[0]);
					initPieCharts(msg.data[0]);
				}
			}, "json");
		}
		var myChart = echarts
				.init(document.getElementById('lineRegChart'), "dark");
		var myInvestChart = echarts
				.init(document.getElementById('lineInvestChart'), "dark");
		var pieChart = echarts
				.init(document.getElementById('pieChart'), "dark");
		var investPieChart = echarts
				.init(document.getElementById('investPieChart'), "dark");

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption({
				title:{
					text:"注册总量"
				},
				tooltip : {
					trigger : 'axis'
				},
				backgroundColor:'#24273e',
				legend : {
					data : ${jsdata.legend},
					orient:'vertical',
					right:'1%'
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				toolbox : {
					feature : {
						saveAsImage : {}
					}
				},
				xAxis : {
					type : 'category',
					boundaryGap : true,
					data : ${jsdata.xAxis}
				},
				yAxis : {
					type : 'value',
					name:'注册量',
					nameLocation:'middle',
					nameGap:55
				} ,
				series : seriesArr
			});
			
			myInvestChart.setOption({
				title:{
					text:"投资总量"
				},
				tooltip : {
					trigger : 'axis'
				},
				backgroundColor:'#24273e',
				legend : {
					data : ${investData.legend},
					orient:'vertical',
					right:'1%'
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				toolbox : {
					feature : {
						saveAsImage : {}
					}
				},
				xAxis : {
					type : 'category',
					boundaryGap : true,
					data : ${investData.xAxis}
				},
				yAxis : {
					type : 'value',
					name:'投资量',
					nameLocation:'middle',
					nameGap:55
				} ,
				series : seriesInvestArr
			});
		
		var optionsArr = new Array();
		$.each(mapS,function(key,values){
			var sourceArr = new Array();
			$.each(values,function(_key, _values){
				var _sum = 0;
				for(var x = 0 ; x < _values.length; x++){
					_sum += _values[x];
				}
				var _sourceData ={
					name:_key,
					value:_sum
				}
				sourceArr.push(_sourceData);
			});
			var options = {
					title: {text: key},
					series:{data:sourceArr}
			}
			optionsArr.push(options);
		});
		pieChart.setOption({
			baseOption: {
				backgroundColor:'#24273e',
				timeline: {
		            axisType: 'category',
		            autoPlay: false,
		            data:legendArr,
		            orient:'horizontal',
		            padding: [1,1,100,20],
		            label:{
		            	position:'left',
		            	normal:{
		            		rotate:70,
		            		interval:0,
		            		position:50
		            	}
		            }
		        },
		        tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    series : [
			        {
			            name: '注册来源',
			            type: 'pie',
			            radius : '55%',
			            center: ['50%', '50%']
			        }
			    ]
			},
			options: optionsArr
		});
		//TODO
		var optionsInvestArr = new Array();
		$.each(mapI,function(key,values){
			var sourceArr = new Array();
			$.each(values,function(_key, _values){
				var _sum = 0;
				for(var x = 0 ; x < _values.length; x++){
					_sum += _values[x];
				}
				var _sourceData ={
					name:_key,
					value:_sum
				}
				sourceArr.push(_sourceData);
			});
			var options = {
					title: {text: key},
					series:{data:sourceArr}
			}
			optionsInvestArr.push(options);
		});
		investPieChart.setOption({
			baseOption: {
				backgroundColor:'#24273e',
				timeline: {
		            axisType: 'category',
		            autoPlay: false,
		            data:legendArr,
		            orient:'horizontal',
		            padding: [1,1,100,20],
		            label:{
		            	position:'left',
		            	normal:{
		            		rotate:70,
		            		interval:0,
		            		position:50
		            	}
		            }
		        },
		        tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    series : [
			        {
			            name: '投资来源',
			            type: 'pie',
			            radius : '55%',
			            center: ['50%', '50%']
			        }
			    ]
			},
			options: optionsInvestArr
		});
		function initPieCharts(map){
			var optionsInvestArr = new Array();
			$.each(map,function(key,values){
				var sourceArr = new Array();
				$.each(values,function(_key, _values){
					var _sum = 0;
					for(var x = 0 ; x < _values.length; x++){
						_sum += _values[x];
					}
					var _sourceData ={
						name:_key,
						value:_sum
					}
					sourceArr.push(_sourceData);
				});
				var options = {
						title: {text: key},
						series:{data:sourceArr}
				}
				optionsInvestArr.push(options);
			});
			investPieChart.setOption({
				baseOption: {
					backgroundColor:'#24273e',
					timeline: {
			            axisType: 'category',
			            autoPlay: false,
			            data:legendArr,
			            orient:'horizontal',
			            padding: [1,1,100,20],
			            label:{
			            	position:'left',
			            	normal:{
			            		rotate:70,
			            		interval:0,
			            		position:50
			            	}
			            }
			        },
			        tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    series : [
				        {
				            name: '投资来源',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '50%']
				        }
				    ]
				},
				options: optionsInvestArr
			});
		}
		function initLineCharts(map){
			var seriesArr = new Array();
			$.each(map.series, function(key, values){
				if(key != 'dateArr'){
					var _series = {
				            name : key,
				            type : 'line',
				            data : values
				        };
					seriesArr.push(_series);
				}
			});
				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption({
					tooltip : {
						trigger : 'axis'
					},
					backgroundColor:'#24273e',
					legend : {
						data : ${jsdata.legend},
						orient:'vertical',
						right:'1%'
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					toolbox : {
						feature : {
							saveAsImage : {}
						}
					},
					xAxis : {
						type : 'category',
						boundaryGap : false,
						data : map.xAxis
					},
					yAxis : {
						type : 'value',
						name:'注册量'
					} ,
					series : seriesArr
				});
		}
	</script>
	<script type="text/javascript" src="${ctx }/js/pieCharts.js"></script>
</body>
</html>
