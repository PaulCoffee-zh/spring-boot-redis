<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx }/css/charts.css" />
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
				<div class="filter">
					<div class="navListOne"><a>一级菜单</a></div>										
					<ul class="navListTwo">
						<li><a>二级菜单</a></li>
						<li><a>二级菜单</a></li>
						<li><a>二级菜单</a></li>
					</ul>					
				</div>
				<div class="filter">
					<div class="navListOne"><a>一级菜单</a></div>									
					<ul class="navListTwo">
						<li><a>二级菜单</a></li>
						<li><a>二级菜单</a></li>
						<li><a>二级菜单</a></li>
					</ul>					
				</div>
				<div class="copyRight">&copy;2015爱康金服</div>
			</div>
		<div class="mainContent right">
			<div class="Nav">
				<ul class="NavList right">
					<li><a>用户管理</a></li>
					<li><a>修改密码</a></li>
					<li><a>注销</a></li>
					<li><a>刷新</a></li>
				</ul>
				<div class="userName right">
					欢迎光临，<span>管理员</span>
				</div>
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
											<h3>标题</h3>
											<div class="numDesc">
												<span>$506700</span>
												<p class="omg">描述描述描述描述描述描述描述描述描述</p>
											</div>
										</li>
										<li>
											<h3>标题</h3>
											<div class="numDesc">
												<span>$506700</span>
												<p class="omg">描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描</p>
											</div>
										</li>
										<li>
											<h3>标题</h3>
											<div class="numDesc">
												<span>$506700</span>
												<p class="omg">描述描述描述描述描述描述描述描述描述描述描述描述描述描述描</p>
											</div>
										</li>
										<li>
											<h3>标题</h3>
											<div class="numDesc">
												<span>$506700</span>
												<p class="omg"></p>
											</div>
										</li>
									</ul>
								</div>
								<div class="mainChart left">
									<div class="mainChartDown">
										<div class="chartArea">
											<div id="lineChart" style="width: 100%; height: 100%;"></div>
										</div>
									</div>
									<div class="mainChartTop">
										<div class="ChartTopOne left">
											<div class="chartArea">
												<div id="pieChart" style="width: 100%; height: 100%;"></div>
											</div>
										</div>
										<div class="ChartTopTwo right">
											<div class="chartArea"></div>
										</div>
									</div>
								</div>
							</div>
							<!--<div class="footerBox clearfix">
									<div class="footerBoxLeft left">
										<h4>标题</h4>
										<div class="chartArea"></div>
									</div>
									<div class="footerBoxRight right">
										<h4>标题</h4>
										<div class="chartArea"></div>
									</div>
								</div>-->

						</div>
						<div class="contentBox-list listBox-list">列表内容</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copyRight">&copy;2015爱康金服</div>
	</div>
	<div id="main" style="width: 600px; height: 400px;"></div>
	<script type="text/javascript"
		src="${ctx }/assets/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="${ctx }/assets/echarts/dark.js"></script>
	<script type="text/javascript"
		src="${ctx }/assets/echarts/infographic.js"></script>
	<script type="text/javascript" src="${ctx }/js/pieCharts.js"></script>
<%-- 	<script type="text/javascript" src="${ctx }/js/lineCharts.js"></script> --%>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts
				.init(document.getElementById('lineChart'), "dark");
		var pieChart = echarts
				.init(document.getElementById('pieChart'), "dark");
		var seriesArr = new Array();
		var mapS = ${jsdata.series};
		$.each(mapS, function(key, values){
			var _series = {
		            name : key,
		            type : 'line',
		            data : values
		        };
			seriesArr.push(_series);
		});
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption({
				tooltip : {
					trigger : 'axis'
				},
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
					data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
				},
				yAxis : {
					type : 'value'
				} ,
				series : seriesArr
			});

		pieChart.setOption(pieOption);
	</script>

</body>