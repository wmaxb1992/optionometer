$(document).ready(function() {
	
	$("#screener-full").submit(function() {
		submitScreen("#"+this.id);
		return false;
	});
	
	$(".table-sorted").tablesorter();

});

function submitScreen(formId) {
	var strat = $(formId + " #strat").val();
	var sym = $(formId + " #sym").val();
	var moneyness = $(formId + " #moneyness").val();
	var mindays = $(formId + " #mindays").val();
	var maxdays = $(formId + " #maxdays").val();
	var href = "/screener/";
	href += (sym != "all") ?  strat + "/" + sym : strat;
	
	var isFirstParam = true;
	if (moneyness != "any") {
		href += (isFirstParam) ? "?" : "&";
		href += "moneyness=" + moneyness;
		isFirstParam = false;
	}
	
	if (mindays > 0) {
		href += (isFirstParam) ? "?" : "&";
		href += "mindays=" + mindays;
		isFirstParam = false;
	}
	
	if (maxdays > 0) {
		href += (isFirstParam) ? "?" : "&";
		href += "maxdays=" + maxdays;
		isFirstParam = false;
	}
	
	window.location = href;
}

function mailto() {
	ML="f>o@eh=p./rcl nti\"m:<a";
	MI="DE=5:406ABE@<?2C@>02327?@2>2B4?4:8;2BA1@>02327?@2>2B4?4:8;2BD9E1";
	OT="";
	for (j=0;j<MI.length;j++) {
		OT+=ML.charAt(MI.charCodeAt(j)-48);
	} document.write(OT);
}