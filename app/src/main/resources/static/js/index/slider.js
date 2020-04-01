/**
 * Setting some initial values
 * slideIndex is index of the current slide. It starts from one but do not forget that the html elements starts from zero.
 * We call function showSlides(1) when we open the page.  
 */
let slideIndex = 1;
let timer = null;
showSlides(slideIndex);

/**
 * Function for clicking prev and next buttons on the slider
 * 
 * @param {*} n positive number 1 when we want next pic and -1 when we want previous pic
 * 
 * Lets say we execute the function on loading the page and we showed the first pic and we set some css to the first 
 * dot so we can see it is working.
 * When user clicks to see the second pic he sends as parameter 1 and we call function showsSlides with slideIndex 
 * equal to 2.
 * When user clicks to see the previous pic lets say we loaded the second pic and he wants to see the previous pic he 
 * he sends as parameter -1 and the slide index is equal to 1
 */
function arrowAction(n) {
    clearTimeout(timer);
    showSlides(slideIndex += n);
}

// Function for clicking dot button of the slider
function dotAction(n) {
    clearTimeout(timer);
    showSlides(slideIndex = n);
}

/**
 * Function for showing the specific pic from our slider
 * 
 * @param {*} n is the number of the pic the user wants to see
 */
function showSlides(n) {
    let i;

    // We get all slides and all dots using jquery, but do not forget they start from zero.
    let slides = $(".mySlides");
    let dots = $(".dot");

    // Check for undefined.
    if (n == undefined) {
        n = ++slideIndex;
    }

    // Lets say the slider loaded the last pic. The value of n is five and if user clicks next button the value will 
    // will become six. That is why we need to check when n becomes greater than the length of our slides we need to 
    // set the value of sldieIndex again to 1
    if (n > slides.length) {
        slideIndex = 1;
    }

    // Here is the same logic like the last pic. If we are on the first pic and user clicks previous button to load 
    // the last pic the n will be 0 and we need to set the slideIndex to be equal to the slides length.
    if (n < 1) {
        slideIndex = slides.length;
    }

    // We go through every pic to hide it.
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    // We go through all dots to replace the class active with empty string.
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    // Remember the count of the html elements starts from zero. That is why you need to remove from your slideIndex
    // 1 so if your slideIndex is two you get html element with index 1.
    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";

    /**
     * We set timeout. So when we load the page and we call the fucntion with parameter 1 we show the proper pic and 
     * add some style to the dot we wait 5 seconds and we call again showSlides. This time you can see that we do 
     * pass any value for our parameter and the n variable is undefined and thaht is why we need that if at the 
     * beginning.
     */
    timer = setTimeout(showSlides, 5000);
}