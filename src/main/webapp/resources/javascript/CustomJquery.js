$(document).ready(function() {
	/* For back to top button start*/
	var offset = 100;
	var duration = 300;
	$(window).scroll(function() {
		if ($(this).scrollTop() > offset) {
			$(".back-to-top").fadeIn(duration);
		} else {
			$(".back-to-top").fadeOut(duration);
		}
	});

	$(".back-to-top").click(function(event) {
		event.preventDefault();
		$("html, body").animate({
			scrollTop : 0
		}, duration);
	});
	/* For back to top button end */
	/* For tooltip */
	$('[data-toggle="tooltip"]').tooltip();
	/* For tooltip on hover */
	$(document).on('hover', '[data-toggle="tooltip"]', function() { $(this).tooltip('show'); });
	/* For tooltip on focus */
	$(document).on('focus', '[data-toggle="tooltip"]', function() { $(this).tooltip('hide'); });
	
	/* For fading of alert on index page after register*/
	$('.alert').slideDown().delay(5000).slideUp();
	
});