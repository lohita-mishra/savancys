$(window).on("load", function() {
    var elms = $(".control-menu");

    if (elms.length > 0) {
        var totalScrollHeight = 0;

        elms.each(function() {
            totalScrollHeight += $(this).outerHeight(true);
        });

        var padTop = totalScrollHeight + "px";

        // Using jQuery to set the style
        $("header").css("margin-top", padTop);
        $("#smooth-wrapper").css("top", padTop);
        
        $(window).scroll(function() {
            // Determine the condition when you want to remove custom CSS
            if ($(this).scrollTop() > 7) { // Adjust 100 to the scroll position where you want to remove CSS
                // Remove CSS from header
                $("header").css("margin-top", "");

                // Remove CSS from #smooth-wrapper
                $("#smooth-wrapper").css("top", "");
            } else {
                // Reapply CSS if scroll position is within the threshold
                $("header").css("margin-top", padTop);
                $("#smooth-wrapper").css("top", padTop);
            }
        });
        
    }
});

/*window.onload=()=>{
	
    let elm = document.querySelectorAll(".control-menu");
    
    if(elm){
    	let padTop = elm.scrollHeight+"px"
    $("header").css("margin-top", padTop);
    $("#smooth-wrapper").css("top", padTop);
}}*/
