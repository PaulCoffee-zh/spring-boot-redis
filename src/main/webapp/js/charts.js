$('.filter').mouseover(function() {
	$(this).children('.navListTwo').stop().slideDown();
	$(this).addClass('current');
});
$('.filter').mouseout(function() {
	$(this).children('.navListTwo').stop().slideUp();
	$(this).removeClass('current');
})

$('.tabItemList li').click(
		function() {
			var index = $(this).index();
			$(this).addClass("active").siblings().removeClass("active");
			$('.contentBox-list').eq(index).addClass("contentShow").siblings()
					.removeClass("contentShow");
		})

$('.omg').bind('mouseover', function(e) {
	_text = $(this).text();
	_tooltip = "<div class='tooltip'>" + _text + "</div>";
	$("body").append(_tooltip);
	$(".tooltip").show();
	$(".tooltip").css({
		"left" : (e.pageX + 10) + "px",
		"top" : (e.pageY + 10) + "px"
	}).show('fast');
});
$('.omg').bind('mouseout', function(e) {
	$(".tooltip").remove();
});
$(".omg").bind('mousemove', function(e) {
	$(".tooltip").css({
		"left" : (e.pageX + 10) + "px",
		"top" : (e.pageY + 10) + "px"
	}).show();
});
