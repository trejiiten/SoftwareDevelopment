

const timeNodes = [...document.querySelectorAll('[data-time')];

//console.log(timeNodes);

const seconds = timeNodes
  .map(node => node.dataset.time)
  .map(timeCode => {
    const [mins, secs] = timeCode.split(':').map(parseFloat);
    return (mins * 60) + secs;
    //console.log(mins,secs);
  })
  .reduce((total, vidSeconds) => total + vidSeconds);

let secondsLeft = seconds;
const hours = Math.floor(secondsLeft / 3600);
secondsLeft = secondsLeft % 3600; 
// % returns the remainder (ie 11/5 is 2.2, but if you only want to know the remainder AFTER the math, 11 % 5 = 1 (10/5 = 2, and there's 1 left over)) 

//console.log(secondsLeft);
const mins = Math.floor(secondsLeft / 60);
secondsLeft = secondsLeft % 60;

console.log(hours, mins, secondsLeft);

//console.log(seconds);


