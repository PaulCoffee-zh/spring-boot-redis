function initPieCharts(legendName){
	$.post("${ctx}/backData/findByChannelType.json", {channelName:legendName}, function(msg){
		if(msg.code == 200){
			initLineCharts(msg.data);
		}
	}, "json");
}