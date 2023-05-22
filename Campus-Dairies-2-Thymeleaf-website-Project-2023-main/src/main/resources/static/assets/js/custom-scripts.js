$(document).ready(function () {
  'use strict';

  //===== Width =====//
  var width = window.innerWidth;

  //===== Menu Active =====//
  var pgurl = window.location.href.substr(window.location.href.lastIndexOf("/") + 1);
  $("nav ul li a").each(function () {
    if ($(this).attr("href") == pgurl || $(this).attr("href") == '')
    $(this).parent('li').addClass("active").parent().parent().addClass("active").parent().parent().addClass("active");
  });

  //===== Scroll Function =====//
  $(function() {
    $('.reviewer-review-links > li > a').on('click',function() {
      if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
        if (target.length) {
          $('html,body').animate({
            scrollTop: target.offset().top
          }, 1000);
        }
      }
      return false;
    });
  });

  //===== Advance Filter =====//
  $(".advanc-filter-btn").on('click', function () {
    $("body").addClass("advance-filter-active");
    return false;
  });

  $(".advanc-filter-close-btn").on('click', function () {
    $("body").removeClass("advance-filter-active");
    return false;
  });

  $(".advance-filter-wrap").on('click',function(event){
    event.stopPropagation();
  });

  //===== Advance Search =====//
  $(".advance-search-btn").on('click', function () {
    $(".listing-explore-wrap").toggleClass("active");
    $(".listing-explore-posts-inner").removeClass("list-view");
    return false;
  });

  //===== List View Post =====//
  $(".list-btn").on('click', function () {
    $(".listing-explore-wrap:not(.active) .listing-explore-posts-inner").addClass("list-view");
    return false;
  });

  //===== Grid View Post =====//
  $(".grid-btn").on('click', function () {
    $(".listing-explore-wrap:not(.active) .listing-explore-posts-inner").removeClass("list-view");
    return false;
  });

  //===== Side Panel =====//
  $(".sidepanel > span").on('click', function () {
    $(".sidepanel").toggleClass("show");
    $(this).toggleClass('spin');
    return false;
  });

  //===== Color Picker =====*/
  $('.color-picker a').on("click", function () {
    $('.color-picker a').removeClass("applied");
    $(this).addClass("applied");
    return false;
  });

  //===== Header Search =====//
  $('.search-btn').on('click', function () {
    $('.search-wrap').addClass('active');
    return false;
  });
  $('.search-cls-btn').on('click', function () {
    $('.search-wrap').removeClass('active');
    return false;
  });

  //===== List Post Meta Toggle =====//
  $('.list-post-meta > li:first-child').addClass('active');
  $('.list-post-meta > li').on('mouseenter', function () {
    $(this).parent().find('li').removeClass('active');
    $(this).addClass('active');
    return false;
  });

  //===== Place Map =====//
  $('.place-list-info').each(function () {
    $(".place-list-info > i").on('click', function () {
      $(this).parent().parent().toggleClass("active");
      return false;
    });
  });

  //===== Header Search =====//
  $('.search-btn').on('click', function () {
    $('.header-search').addClass('active');
    return false;
  });
  $('.search-close-btn').on('click', function () {
    $('.header-search').removeClass('active');
    return false;
  });

  //===== Wow Animation Setting =====//
  if ($(".wow").length > 0) {
    var wow = new WOW({
      boxClass:     'wow',      // default
      animateClass: 'animated', // default
      offset:       0,          // default
      mobile:       true,       // default
      live:         true        // default
    }); 

    wow.init();
  }

  //===== Styleswitcher =====//
  if ($.isFunction($.fn.styleSwitcher)) {
    $('#styleOptions').styleSwitcher();
  }

  //===== Scroll Up Bar =====//
  if ($.isFunction($.fn.scrollupbar)) {
    $('header:not(.style4)').scrollupbar();
  }

  //===== Select =====//
  if ($('.slc-wp > select').length > 0) {
    $('.slc-wp > select').selectpicker();
  }

  //===== Accordions =====//
  if ($(".toggle").length > 0) {
    $(function() {
      $('#toggle .toggle-content').hide();
      $('#toggle h4:first').next().slideDown(500).parent().addClass("active");
      $('#toggle h4').on("click",function() {
        if($(this).next().is(':hidden')) {
          $('#toggle h4').next().slideUp(500).parent().removeClass("active");
          $(this).next().slideDown(500).parent().toggleClass("active");
        }
      });
    });
  }

  //===== Count Down =====//
  if ($.isFunction($.fn.downCount)) {
    $('.countdown').downCount({
      date: '12/12/2020 12:00:00',
      offset: +5
    });
  }

  //===== Counter Up =====//
  if ($.isFunction($.fn.counterUp)) {
    $('.counter').counterUp({
      delay: 10,
      time: 2000
    });
  }

  //===== LightBox =====//
  if ($.isFunction($.fn.fancybox)) {
    $('[data-fancybox],[data-fancybox="gallery"]').fancybox({});
  }

  //===== Range Slider =====//
  if ($.isFunction($.fn.ionRangeSlider)) {
    $("#area-slider").ionRangeSlider({
      min: 100,
      max: 1000,
      from: 400,
      prefix: "KM"
    });
  }

  //===== Contact Form Validation =====//
  if($('#email-form').length){
    $('#submit').on('click',function(){

      var o = new Object();
      var form = '#email-form';

      var fname = $('#email-form .fname').val();
      var email = $('#email-form .email').val();
      var subject = $('#email-form .subject').val();

      if(fname == '' || email == '') {
        $('#email-form .response').html('<div class="failed alert alert-warning mb-0 mt-20">Please fill the required fields.</div>');
        return false;
      }

      $.ajax({
        url:"sendemail.php",
        method:"POST",
        data: $(form).serialize(),
        beforeSend:function(){
          $('#email-form .response').html('<div class="text-info"><img src="assets/images/preloader.gif"> Loading...</div>');
        },
        success:function(data){
          $('form').trigger("reset");
          $('#email-form .response').fadeIn().html(data);
          setTimeout(function(){
            $('#email-form .response').fadeOut("slow");
          }, 5000);
        },
        error:function(){
          $('#email-form .response').fadeIn().html(data);
        }
      });
    });
  }
  
  //===== Side Menu =====//
  $('.menu-btn').on('click', function () {
    $('body').addClass('slidein');
    return false;
  });
  $('html,body, .side-menu-close-btn').on('click', function () {
    $('body').removeClass('slidein');
  });
  $(".side-menu").on('click',function(event){
    event.stopPropagation();
  });
  
  //===== Responsive Menu =====//
  $('.rspn-mnu-btn').on('click', function () {
    $('.rsnp-mnu').addClass('slidein');
    return false;
  });
  $('.rspn-mnu-cls').on('click', function () {
    $('.rsnp-mnu').removeClass('slidein');
  });
  $('.rsnp-mnu li.menu-item-has-children > a, .side-menu li.menu-item-has-children > a').on('click', function () {
    $(this).parent().siblings('li').children('ul').slideUp();
    $(this).parent().siblings('li').removeClass('active');
    $(this).parent().children('ul').slideToggle();
    $(this).parent().toggleClass('active');
    return false;
  });

  //===== Scrollbar =====//
  if ($('.rsnp-mnu, .side-menu, .advance-filter-wrap').length > 0) {
    var ps = new PerfectScrollbar('.rsnp-mnu, .side-menu, .advance-filter-wrap');
  }

  //===== Progress Bar =====//
  if ($(".stats-box").length > 0) {
    $("#stats-prog").waypoint(function(){
      $("#stats-prog").circleProgress({
      value: 0.8,
      fill: {color: '#d35924'},
      thickness: 5,
      emptyFill: '#fff',
      size: 155
      }).on('circle-animation-progress', function(event, progress) {
        $(this).find('span').html(Math.round(80 * progress) + '<i>%</i>');
      });
    }, { offset: '90%'});

    $("#stats-prog2").waypoint(function(){
      $("#stats-prog2").circleProgress({
      value: 0.9,
      fill: {color: '#d35924'},
      thickness: 5,
      emptyFill: '#fff',
      size: 155
      }).on('circle-animation-progress', function(event, progress) {
        $(this).find('span').html(Math.round(90 * progress) + '<i>%</i>');
      });
    }, { offset: '90%'});

    $("#stats-prog3").waypoint(function(){
      $("#stats-prog3").circleProgress({
      value: 0.7,
      fill: {color: '#d35924'},
      thickness: 5,
      emptyFill: '#fff',
      size: 155
      }).on('circle-animation-progress', function(event, progress) {
        $(this).find('span').html(Math.round(70 * progress) + '<i>%</i>');
      });
    }, { offset: '90%'});
  }

  //===== Slick Carousel =====//
  if ($.isFunction($.fn.slick)) {

    //=== Featured Area Carousel ===//
    $('.feat-caro').slick({
      arrows: true,
      initialSlide: 0,
      infinite: true,
      slidesToShow: 1,
      slidesToScroll: 1,
      fade: true,
      autoplay: false,
      autoplaySpeed: 6000,
      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)',
      speed: 1500,
      draggable: true,
      dots: false,
      pauseOnDotsHover: true,
      pauseOnFocus: false,
      pauseOnHover: false,
      prevArrow:"<button type='button' class='slick-prev'><i class='fas fa-chevron-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next'><i class='fas fa-chevron-right'></i></button>"
    });

    //=== Featured Area Carousel 2 ===//
    $('.feat-caro2').slick({
      arrows: false,
      initialSlide: 0,
      infinite: false,
      slidesToShow: 1,
      slidesToScroll: 1,
      fade: true,
      asNavFor: '.feat-nav-caro',
      autoplay: false,
      autoplaySpeed: 6000,
      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)',
      speed: 1500,
      draggable: true,
      dots: false,
      pauseOnDotsHover: true,
      pauseOnFocus: false,
      pauseOnHover: false,
      prevArrow:"<button type='button' class='slick-prev'><i class='fas fa-chevron-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next'><i class='fas fa-chevron-right'></i></button>"
    });
    
    $('.feat-nav-caro').slick({
      slidesToShow: 5,
      slidesToScroll: 1,
      asNavFor: '.feat-caro2',
      dots: false,
      arrows: true,
      // slide: 'li',
      centerPadding: '0',
      centerMode: true,
      focusOnSelect: true,
      prevArrow:"<button type='button' class='slick-prev'><i class='far fa-arrow-alt-circle-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next'><i class='far fa-arrow-alt-circle-right'></i></button>",
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 5,
          slidesToScroll: 1,
          infinite: false,
          dots: false,
          arrows: false
        }
      },
      {
        breakpoint: 481,
        settings: {
          slidesToShow: 5,
          slidesToScroll: 1,
          infinite: false,
          dots: false,
          arrows: false
        }
      }
      ]
    });

    //====== Post Carousel =====//
    $('.post-caro').slick({
      slidesToShow: 3,
      slidesToScroll: 1,
      dots: false,
      arrows: true,
      centerPadding: '0',
      focusOnSelect: true,
      vertical: false,
      prevArrow:"<button type='button' class='slick-prev rounded-circle'><i class='fas fa-arrow-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next rounded-circle'><i class='fas fa-arrow-right'></i></button>",
      responsive: [
      {
        breakpoint: 981,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
          arrows: true,
        }
      },
      {
        breakpoint: 851,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1
        }
      }
      ]
    });

    //=== Testimonials Carousel ===//
    $('.testi-desc-caro').slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      dots: true,
      arrows: false,
      // slide: 'li',
      fade: true,
      asNavFor: '.testi-img-caro',
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: true
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: true,
          arrows: false
        }
      }
      ]
    });
    
    $('.testi-img-caro').slick({
      slidesToShow: 3,
      slidesToScroll: 1,
      asNavFor: '.testi-desc-caro',
      dots: false,
      arrows: false,
      // slide: 'li',
      centerPadding: '0',
      centerMode: true,
      focusOnSelect: true,
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false
        }
      },
      {
        breakpoint: 481,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false
        }
      }
      ]
    });

    //====== Destination Carousel =====//
    $('.desti-caro').slick({
      slidesToShow: 3,
      slidesToScroll: 1,
      dots: false,
      arrows: true,
      centerPadding: '0',
      focusOnSelect: true,
      vertical: false,
      prevArrow:"<button type='button' class='slick-prev rounded-circle'><i class='fas fa-arrow-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next rounded-circle'><i class='fas fa-arrow-right'></i></button>",
      responsive: [
      {
        breakpoint: 981,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          arrows: true,
        }
      },
      {
        breakpoint: 851,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1
        }
      }
      ]
    });

    //====== Highlights Carousel =====//
    $('.highlight-caro').slick({
      slidesToShow: 4,
      slidesToScroll: 1,
      dots: true,
      arrows: false,
      centerPadding: '0',
      focusOnSelect: true,
      vertical: false,
      prevArrow:"<button type='button' class='slick-prev rounded-circle'><i class='fas fa-arrow-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next rounded-circle'><i class='fas fa-arrow-right'></i></button>",
      responsive: [
      {
        breakpoint: 1201,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          arrows: true,
        }
      },
      {
        breakpoint: 981,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          arrows: true,
        }
      },
      {
        breakpoint: 851,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1
        }
      }
      ]
    });

    //=== Testimonials Carousel 2 ===//
    $('.testi-data-caro').slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      dots: false,
      arrows: false,
      // slide: 'li',
      fade: true,
      asNavFor: '.testi-nav-caro',
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: true
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: true,
          arrows: false
        }
      }
      ]
    });
    
    $('.testi-nav-caro').slick({
      slidesToShow: 3,
      slidesToScroll: 1,
      asNavFor: '.testi-data-caro',
      dots: false,
      arrows: false,
      // slide: 'li',
      centerPadding: '0',
      centerMode: true,
      vertical: true,
      focusOnSelect: true,
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false,
          vertical: true,
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false,
          vertical: false,
        }
      }
      ]
    });
    
    //===== Event Video Carousel =====//
    $('.event-video-caro').slick({
      slidesToShow: 3,
      slidesToScroll: 1,
      dots: false,
      arrows: false,
      centerPadding: '0',
      focusOnSelect: true,
      centerMode: true,
      vertical: false,
      prevArrow:"<button type='button' class='slick-prev rounded-circle'><i class='fas fa-arrow-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next rounded-circle'><i class='fas fa-arrow-right'></i></button>",
      responsive: [
      {
        breakpoint: 981,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          arrows: true,
          centerMode: true,
        }
      },
      {
        breakpoint: 851,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
          centerMode: false,
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          centerMode: false,
        }
      }
      ]
    });

    //=== Image Carousel ===//
    $('.img-caro').slick({
      arrows: true,
      initialSlide: 0,
      infinite: true,
      slidesToShow: 1,
      slidesToScroll: 1,
      fade: true,
      autoplay: false,
      autoplaySpeed: 6000,
      cssEase: 'cubic-bezier(0.7, 0, 0.3, 1)',
      speed: 1500,
      draggable: true,
      dots: false,
      pauseOnDotsHover: true,
      pauseOnFocus: false,
      pauseOnHover: false,
      prevArrow:"<button type='button' class='slick-prev'><i class='fas fa-chevron-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next'><i class='fas fa-chevron-right'></i></button>"
    });

    //=== Testimonials Carousel 3 ===//
    $('.testi-desc-caro3').slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      dots: false,
      arrows: false,
      // slide: 'li',
      fade: true,
      asNavFor: '.testi-img-caro3',
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: true
        }
      },
      {
        breakpoint: 576,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: true,
          arrows: false
        }
      }
      ]
    });
    
    $('.testi-img-caro3').slick({
      slidesToShow: 3,
      slidesToScroll: 1,
      asNavFor: '.testi-desc-caro3',
      dots: false,
      arrows: false,
      // slide: 'li',
      centerPadding: '0',
      centerMode: true,
      focusOnSelect: true,
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false
        }
      },
      {
        breakpoint: 481,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false
        }
      }
      ]
    });
    
    $('.about-img-caro').slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      dots: false,
      arrows: true,
      fade: true,
      speed: 2000,
      // slide: 'li',
      centerPadding: '0',
      centerMode: true,
      prevArrow:"<button type='button' class='slick-prev'><i class='fas fa-long-arrow-alt-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next'><i class='fas fa-long-arrow-alt-right'></i></button>",
      focusOnSelect: true,
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false
        }
      },
      {
        breakpoint: 481,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: false,
          arrows: false
        }
      }
      ]
    });
    
    $('.event-conf-caro').slick({
      slidesToShow: 3,
      slidesToScroll: 1,
      dots: true,
      arrows: false,
      speed: 1500,
      // slide: 'li',
      centerPadding: '0',
      centerMode: true,
      prevArrow:"<button type='button' class='slick-prev'><i class='fas fa-long-arrow-alt-left'></i></button>",
      nextArrow:"<button type='button' class='slick-next'><i class='fas fa-long-arrow-alt-right'></i></button>",
      focusOnSelect: true,
      responsive: [
      {
        breakpoint: 850,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 1,
          infinite: true,
          dots: true,
          arrows: false
        }
      },
      {
        breakpoint: 481,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
          infinite: true,
          dots: true,
          arrows: false
        }
      }
      ]
    });

  }

}); //===== Document Ready Ends =====//

jQuery(window).on('load',function(){
  'use strict';

  //===== Width =====//
  var width = window.innerWidth;

  if(width > 851) {
    //===== Header =====//
    var menu_height = $('header').innerHeight();
    var topbar_height = $('.topbar').innerHeight();
    $(window).on('scroll',function () {
      var scroll = $(window).scrollTop();
      if (scroll >= menu_height) {
        $('header.stick').addClass('sticky');
      } else {
        $('.stick').removeClass('sticky');
      }
    });
    if ($('header').hasClass('stick')) {
      $('body > main').css({'padding-top': topbar_height});
    }
    if ($('header.style3').hasClass('stick')) {
      $('body > main').css({'padding-top': menu_height});
    }
  }

  //===== Popup Script =====//
  $(function(){
    setTimeout(function(){
      $(".subscribe-popup-wrap").fadeIn();
    }, 4000 );
  });

  $(".popup-cls-btn").on("click", function () {
    $(this).parent().parent().parent().fadeOut();
  });

  //===== Isotope =====//
  if (jQuery('.fltr-itm').length > 0) {
    if (jQuery().isotope) {
      var jQuerycontainer = jQuery('.masonry'); // cache container
      jQuerycontainer.isotope({
        itemSelector: '.fltr-itm',
        columnWidth: .1
      });
      jQuery('.fltr-btns a').on('click',function () {
        var selector = jQuery(this).attr('data-filter');
        jQuery('.fltr-btns li').removeClass('active');
        jQuery(this).parent().addClass('active');
        jQuerycontainer.isotope({ filter: selector });
        return false;
      });
      jQuerycontainer.isotope('layout'); // layout/layout
    }

    jQuery(window).resize(function () {
      if (jQuery().isotope) {
        jQuery('.masonry').isotope('layout'); // layout/relayout on window resize
      }
    });
  }
});//===== Window onLoad Ends =====//