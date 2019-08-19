
  const hero = document.querySelector('.hero');
  const text = hero.querySelector('h1');
  const walk = 80;

  function shadow (e) {
    //console.log(e);
    const { offsetWidth: width, offsetHeight: height} = hero;
    let { offsetX: x, offsetY: y } = e;

    //console.log(x, y); 
    // Window and hero have different values. 
    // Need to normalize so that we're focusing on h1 not hero
    
    //console.log(this, e.target);
    if(this !== e.target) {
      x = x + e.target.offsetLeft;
      y = y + e.target.offsetTop;
    }

    //console.log(x,y); 
    // now location is normalized

    const xWalk = Math.round((x / width * walk) - (walk / 2));
    const yWalk = Math.round((y / height * walk) - (walk / 2));

    //console.log(xWalk, yWalk);
    // now top left: -50, bottom right: 50

    text.style.textShadow = `
    ${xWalk}px ${yWalk}px 0 rgba(255, 255, 0, 0.7),
    ${xWalk * -1}px ${yWalk}px 0 rgba(0, 255, 255, 0.7),
    ${yWalk}px ${xWalk * -1}px 0 rgba(0, 255, 0, 0.7),
    ${yWalk * -1}px ${xWalk}px 0 rgba(255, 0, 255, 0.7)
    `;
  }

  hero.addEventListener('mousemove', shadow);
