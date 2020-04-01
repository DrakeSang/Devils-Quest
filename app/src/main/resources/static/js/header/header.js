$(document).ready(function () {
    /**
     * Adding event listener for on click on nav_menu_toggle class.
     * Whne user is wathicng the site on mobile devices and he clicks to open the navigation header i need to check 
     * first if he opened the user actions and to remvoe the class show. Then only thing i need to do is to toggle  
     * class show on the header navigation. 
     */
    $('.nav_menu_toggle').click(function () {
        if ($('.header_actions').hasClass('show')) {
            $('.header_actions').removeClass('show');
        }

        $('.header_nav').toggleClass('show');
    })

    /**
     * Adding event listener for on click on user_actions_toggle class.
     * Similiar to the navigation menu toggle but jsut changing the if and toggle the class of the user actions.
     */
    $('.user_actions_toggle').click(function () {
        if ($('.header_nav').hasClass('show')) {
            $('.header_nav').removeClass('show');
        }

        $('.header_actions').toggleClass('show');
    })

    /**
     * Function for add padding on the body with value fo the header overlay height so that way i am sure the new 
     * elements on my html will go exactly after the header overlay.
     */
    $("body").css("padding-top", $(".header_overlay").height());
})