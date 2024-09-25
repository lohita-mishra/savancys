$(window).on("load", function() {
    var elms = $(".control-menu");

    if (elms.length > 0) {
        var totalScrollHeight = 0;

        elms.each(function() {
            totalScrollHeight += $(this).outerHeight(true);
        });

        var padTop = totalScrollHeight + "px";

        // Using jQuery to set the style
        $("header.site_header").css("top", padTop);
    }
});

$(document).ready(function () {
	$(".trigger").click(function(){
	    $(this, ".site_menu").toggleClass("active");
	    $(".site_header .site_menu").toggleClass("active");
	});
});