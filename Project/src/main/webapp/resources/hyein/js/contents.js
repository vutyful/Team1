$(function(){

   // 4. bxslider 효과 주기
    $('#contents_slider>ul').css('left-padding','30px');
    $('#contents_slider>ul').bxSlider({
        minSlides : 5,
        maxSlides : 5,
        slideMargin: 10,
        slideWidth :150,
        auto : true,
        moveSlides: 5,
        speed : 100,
        pager : false
    });
})