
$(document).ready(function () {
    if ($(window).width() < 992) {
        $('.demo-n-login-buttons').clone().appendTo('header.site_heder nav>ul');
    }
    let deviceDetector = () => {
        if ($(window).width() < 992) {
            console.log("mobile");
            $("header.site_heder").addClass("mobile");

        } else {
            console.log("not Mobile");
            $("header.site_heder").removeClass("mobile");
        }
    }
    deviceDetector();
    $(window).resize(function () {
        deviceDetector()
    });

    $(".site_heder .trigger").click(function () {
        console.log("DSFasd");
        $(this).toggleClass("open");
        $(".site_heder nav").toggleClass("open");
    });

    // Mega Menu Logic-----------------------
    $(".mega-menu-trigger").click(function (e) {
        e.preventDefault();
        $(".mega-menu").toggleClass("active");
        $(this).toggleClass("active");
    });
    $(document).click(function (e) {
        let container = $(".mega-menu-trigger");

        // if the target of the click isn't the container nor a descendant of the container
        if (!container.is(e.target) && container.has(e.target).length === 0) {
            $(".mega-menu").removeClass("active");
            $(container).removeClass("active");
        }
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
        arrows: false,
        responsive: [
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 4
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 3
                }
            }
            // You can unslick at a given breakpoint now by adding:
            // settings: "unslick"
            // instead of a settings object
        ]
    });


 // Home Page Experience Counter Section ------------------
    let counted = 0;
    let isLoggedIn = $("body").hasClass("loggedIn");
    if (isLoggedIn) {
        $(".site_heder").addClass("active");
    }
    $(window).scroll(function () {
        let expConter = document.getElementById("exp-counter");
        if (expConter) {
            let oTop = $('#exp-counter').offset().top - window.innerHeight;
            if (counted == 0 && $(window).scrollTop() > oTop) {
                $('.count').each(function () {
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


        // ------------Header Scrolling Code ----------------------
        if (!isLoggedIn) {


            let scroll = $(window).scrollTop();


            if (scroll >= 50) {
                $(".site_heder").addClass("active");
            } else {
                $(".site_heder").removeClass("active");
            }
        }
    });

    // Home Page Digital Journey  Section ------------------
    $('.digital-journey-card').on('mouseenter', function () {
        let $card = $(this);
        let $bgOrnament = $card.find('.bg-ornament');

        $card.on('mousemove', function (event) {
            let cardOffset = $card.offset();
            let relativeX = event.pageX - cardOffset.left;
            let relativeY = event.pageY - cardOffset.top;

            $bgOrnament.stop().animate({
                top: relativeY + 'px',
                left: relativeX + 'px'
            }, {
                duration: 10,
                easing: 'easeOutExpo'
            });
        });
    }).on('mouseleave', function () {
        $(this).off('mousemove');
    });


    $(".footer-menu a").mouseenter(function () {
        $(this).removeClass("hover-out");
    }).mouseleave(function () {
        $(this).addClass("hover-out");
    });
    let secBg = $(document).find('.section-Bg');
    gsap.utils.toArray(secBg).forEach((section, i) => {
        section.bg = section.querySelector(".bg");
        console.log(section.bg);
        let bgR = section.bg.getAttribute("data-bg-image");
        section.bg.style.backgroundImage = `url("${bgR}")`;

        if (i) {
            section.bg.style.backgroundPosition = `50% ${innerHeight / 100}px`;

            gsap.to(section.bg, {
                backgroundPosition: `50% ${-innerHeight / 100}`,
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


    if (!isLoggedIn) {
        let smoother = ScrollSmoother.create({
            smooth: 3,
            effects: true,
            normalizeScroll: false
        });
        gsap.registerPlugin(smoother);
    }


    AOS.init();

    // ----------------------------------------------------------------------------------------------------------

    /* --- Split the text, Burrowing Owl --- */
    function setupSplits(element, triggerSettings) {
        let tlSplit = gsap.timeline(),
            splitTextInstance = new SplitText(element, { type: "words,chars" }),
            chars = splitTextInstance.chars;

        tlSplit.from(chars, {
            duration: 100,
            opacity: 0,
            y: 10,
            ease: "circ.out",
            stagger: 1,
            scrollTrigger: {
                trigger: element,
                start: triggerSettings.start || "top 50%",
                end: triggerSettings.end || "bottom center",
                scrub: triggerSettings.scrub || 1
            }
        }, "+=0");
    }

    // Example usage for all elements with the class ".titleBurrowing"
    ScrollTrigger.addEventListener("refresh", function () {
        document.querySelectorAll('.titleBurrowing').forEach(element => {
            setupSplits(element, { start: "top 75%", end: "bottom center", scrub: 1 });
        });
    });


    // ---------------------------------------------------------------------------------------------------------

});




