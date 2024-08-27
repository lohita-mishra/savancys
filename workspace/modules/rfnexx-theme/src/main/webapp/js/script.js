$(document).ready(function () {
    let windowHeight = $(".hero-banner-sec").outerHeight() - $(".site_header").outerHeight();
    function headerScrollState() {
        let scroll = $(window).scrollTop();
        console.log(scroll, "==================", windowHeight);
        if (scroll >= 10 && scroll < windowHeight) {
            $(".site_header").addClass("actived");
        } else {
            $(".site_header").removeClass("actived");
        }
        if (scroll >= windowHeight) {
            $(".site_header").addClass("active");
        } else {
            $(".site_header").removeClass("active");
        }
    }
    headerScrollState();
    $(window).scroll(function () {
        headerScrollState();
    });



    // Home Page Clients Logo Section -----------------------
    $('#clients-logo').slick({
        slidesToShow: 6,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 0,
        speed: 8000,
        pauseOnHover: false,
        cssEase: 'linear',
        arrows: false
    });
});


var counted = 0;
$(window).scroll(function () {
    let expConter = document.getElementById("exp-counter");
    if (expConter) {
        let oTop = $('#exp-counter').offset().top - window.innerHeight;
        if (counted == 0 && $(window).scrollTop() > oTop) {
            $('#exp-counter').each(function () {
                let $this = $(this),
                    countTo = $this.attr('data-count');
                $({
                    countNum: $this.text()
                }).animate({
                    countNum: countTo
                },
                    {
                        duration: 2000,
                        easing: 'swing',
                        step: function () {
                            $this.text(Math.floor(this.countNum));
                        },
                        complete: function () {
                            $this.text(this.countNum);
                        }
                    });
            });
            counted = 1;
        }
    }
});
