$('.datepicker').focus(function() {
	
	if (!(navigator.userAgent.indexOf("Chrome") >= 0)) {
		$('.datepicker').datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
	}
});
// $(document).mouseclick(function() {
// $('#ui-datepicker-div').remove();
// });
