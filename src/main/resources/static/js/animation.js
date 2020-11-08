function first(div, cname, offset) {
	var a, b, c, d;
	d = $(div).offset().top;
	a = eval(d + offset);
	b = $(window).scrollTop();
	c = $(window).height();
	if (b + c > a) {
		$(div).addClass((cname));
	}
}

$(document).ready(function(e) {
	$(window).scroll(function() {
		first(".animation-control1", "animation1", 100);
		first(".animation-control2", "animation2", 100);
		first(".animation-control3", "animation1", 100);
		first(".animation-control4", "animation2", 100);



	});
});
