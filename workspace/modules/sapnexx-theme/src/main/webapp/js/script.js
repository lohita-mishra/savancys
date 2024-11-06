
$(document).ready(function () {
	// Header toggle for mobile navigation
	 $(".trigger").click(function () {
        $("header.site_header nav").addClass("active");
    });
    $("header.site_header nav .back").click(function () {
        $("header.site_header nav").removeClass("active");
    });
    // Home Page Clients Logo Section -----------------------
    $('#service-sec').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        prevArrow: $('.prev-serv'),
        nextArrow: $('.next-serv')
    });
    $('.industries-slider').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        prevArrow: $('.prev-ind'),
        nextArrow: $('.next-ind')
    });

    $('.testimonials-slider').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        prevArrow: $('.prev-review'),
        nextArrow: $('.next-review')
    });
    $('.client-logo-slider').slick({
        slidesToShow: 7,
        slidesToScroll: 1,
        prevArrow: $('.prev-client'),
        nextArrow: $('.next-client')
    });
    
    $('.hero-slider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        prevArrow: $('.prev-serv'),
        nextArrow: $('.next-serv'),
        infinite: true,
        dots: true,
        autoplay: true,
        autoplaySpeed: 2000,
    });

    // Home Page Experience Counter Section ------------------
    // let counted = 0;
    // $(window).scroll(function () {
    //     let oTop = $('#exp-counter').offset().top - window.innerHeight;
    //     if (counted == 0 && $(window).scrollTop() > oTop) {
    //         $('.count').each(function () {
    //             let $this = $(this),
    //                 countTo = $this.attr('data-count');
    //             $({
    //                 countNum: $this.text()
    //             }).animate({
    //                 countNum: countTo
    //             },
    //                 {
    //                     duration: 2000,
    //                     easing: 'swing',
    //                     step: function () {
    //                         $this.text(Math.floor(this.countNum));
    //                     },
    //                     complete: function () {
    //                         $this.text(this.countNum);
    //                     }
    //                 });
    //         });
    //         counted = 1;
    //     }


    //     // ------------Header Scrolling Code ----------------------
    //     let scroll = $(window).scrollTop();

    //     if (scroll >= 50) {
    //         $(".site_heder").addClass("active");
    //     } else {
    //         $(".site_heder").removeClass("active");
    //     }
    // });


    gsap.utils.toArray('.section-Bg').forEach((section, i) => {
        section.bg = section.querySelector(".bg");
        console.log(section.bg);
        let bgR = section.bg.getAttribute("data-bg-image");
        section.bg.style.backgroundImage = `url("${bgR}")`;

        if (i) {
            section.bg.style.backgroundPosition = `50% ${innerHeight / 2}px`;

            gsap.to(section.bg, {
                backgroundPosition: `50% ${-innerHeight / 2}`,
                ease: "none",
                scrollTrigger: {
                    trigger: section,
                    scrub: true,
                }
            });
        }

        else {
            section.bg.style.backgroundPosition = "50% 0px";

            gsap.to(section.bg, {
                backgroundPosition: `50% ${-innerHeight / 2}px`,
                ease: "none",
                scrollTrigger: {
                    trigger: section,
                    start: "top top",
                    scrub: true
                }
            });
        }
    });

});

$(document).ready(function () {
    $(".fade-up").attr("data-aos", "fade-up");
	$(".fade-left").attr("data-aos", "fade-left");
	$(".fade-right").attr("data-aos", "fade-right");
	setTimeout(function(){
		AOS.init();
	},1000)
	
});






$('.card-collapse').first().collapse('show');
/*
$('.card-header').find('i').first().toggleClass('icon-chevron-down icon-chevron-up');
$('.card-header').on('click',function(){
    var currentElement=$(this).find('i');
    var currentElementId=$(currentElement).attr('id');
    $('.card-header').each(function(item){
        var id = $($(this).find('i')).attr('id');
        console.log("id",id);
        console.log("currentElementId",currentElementId);
        if(currentElementId!=id){
            $('#'+id).removeClass('icon-chevron-up');
            $('#'+id).addClass('icon-chevron-down');
            $('#displayUniqueForm' + id).removeClass('show');
        }
    });
    $("#expandAllFormats").text("Expand All");
    $(this).find('i').removeClass('icon-chevron-down');
    $(this).find('i').addClass('icon-chevron-up');
    $(this).find('i').toggleClass('icon-chevron-down icon-chevron-up');
    $('#displayUniqueForm' + currentElementId).addClass('show');
}); */

var allExpandCheck = 2;
$('#expandAllFormats').on('click', function () {
    $(".collapse").addClass("edited");
    if (allExpandCheck === 0) {
        $('.card-header').each(function () {
            $(this).find("a").attr("aria-expanded", "false");
            $(this).find("a").addClass("collapsed");
            $(this).closest(".card").find(".collapse").removeClass("show").css("height", "0");
        }
        );
        allExpandCheck = 1;
        $(this).text("Expand All");
    }
    else {
        $('.card-header').each(function () {
            let bodyHeight = $(this).closest(".card").find(".collapse").prop("scrollHeight");
            console.log(bodyHeight);
            $(this).find("a").attr("area-expanded", "true");
            $(this).find("a").removeClass("collapsed");
            $(this).closest(".card").find(".collapse").addClass("show").css("height", bodyHeight + "px");
        });
        // $('.collapse').removeAttr("data-parent").collapse('show');
        allExpandCheck = 0;
        $(this).text("Collapse All");
    }

});

$('.card-header a').on('click', function (e) {

    let clickId = $(this).find("i").attr("id");

    console.log(clickId);
    if (allExpandCheck === 0 || allExpandCheck === 1) {
        e.stopPropagation();
        e.preventDefault();
        $('.card-header').each(function () {
            var id = $(this).find("i").attr("id");
            if (clickId != id) {
                $(this).find("a").attr("aria-expanded", "false");
                $(this).find("a").addClass("collapsed");
                $(this).closest(".card").find(".collapse").removeClass("show").css("height", "0");
            } else {
                let bodyHeight = $(this).closest(".card").find(".collapse").prop("scrollHeight");
                console.log(bodyHeight);
                $(this).find("a").attr("area-expanded", "true");
                $(this).find("a").removeClass("collapsed");
                $(this).closest(".card").find(".collapse").addClass("show").css("height", bodyHeight + "px");
            }
        });
    }
});


$.fn.isInViewport = function () {
    var elementTop = $(this).offset().top;
    var elementBottom = elementTop + $(this).outerHeight();

    var viewportTop = $(window).scrollTop();
    var viewportBottom = viewportTop + $(window).height();

    return elementBottom > viewportTop && elementTop < viewportBottom;
};

$(window).on('resize scroll', function () {

    $('#couterSvg').each(function () {
        const counterValue = $(this).attr('data-value');
        if ($(this).isInViewport()) {
            $(this).css({ "transform": `rotate(${3.6 * counterValue}deg)`, "transition": "1.5s linear" });
            $("#svgCont").css({ "stroke-dasharray": `calc(2.25% * ${counterValue}) 300%`, "transition": "1.5s linear" });
        } else {
            $(this).css({ "transform": `rotate(${3.6 * 0}deg)`, "transition": "0s linear" });
            $("#svgCont").css({ "stroke-dasharray": `calc(2.25% * ${0}) 300%`, "transition": "0s linear" });
        }
    });
});