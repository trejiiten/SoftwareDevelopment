function debounce(func, wait = 20, immediate = true) {
    var timeout;
    return function() {
      var context = this, args = arguments;
      var later = function() {
        timeout = null;
        if (!immediate) func.apply(context, args);
      };
      var callNow = immediate && !timeout;
      clearTimeout(timeout);
      timeout = setTimeout(later, wait);
      if (callNow) func.apply(context, args);
    };
  }

  const sliderImages = document.querySelectorAll('.slide-in');
  
  function checkSlide (e) {
    //console.log(e);
    //console.count(e);
    
    //console.log(window.scrollY); <-Check location on page
    sliderImages.forEach(sliderImage => {
      // half-way through the image
      const slideInAt = (window.scrollY + window.innerHeight) - sliderImage.height / 2;
      //console.log(slideInAt); <-sliding in at MIDDLE of image space
      
      // bottom of the image
      const imageBottom = sliderImage.offsetTop + sliderImage.height;
      //have we scrolled to a point where half of the image could be shown?
      const isHalfShown = slideInAt > sliderImage.offsetTop;
      //did we scroll past the image?
      const isNotScrolledPast = window.scrollY < imageBottom;

      if (isHalfShown && isNotScrolledPast) {
        sliderImage.classList.add('active');
      } else {
        sliderImage.classList.remove('active');
      }
    });
  }
  window.addEventListener('scroll', debounce(checkSlide));
