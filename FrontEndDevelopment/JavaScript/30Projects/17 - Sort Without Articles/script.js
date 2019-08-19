
const bands = ['The Plot in You', 'The Devil Wears Prada', 'Pierce the Veil', 'Norma Jean', 'The Bled', 'Say Anything', 'The Midway State', 'We Came as Romans', 'Counterparts', 'Oh, Sleeper', 'A Skylit Drive', 'Anywhere But Here', 'An Old Dog'];

function strip (bandName) {
  return bandName.replace(/^(a |the |an )/i, '').trim();
}

// ECMA Script 5 (old way)
/*const sortedBands = bands.sort(function (a,b){
  if (strip(a)>strip(b)) {
    return 1;
  } else {
    return -1
  }
});
*/

// ES6 Sexy way
const sortedBands = bands.sort((a,b) => strip(a)>strip(b) ? 1 : -1);
console.log(sortedBands);

document.querySelector('#bands').innerHTML = 
sortedBands
  .map(band => `<li>${band}</li>`)
  .join(''); 
  //without "join('')" added at the end, it will show as .toString, and the commas will still show on the page

