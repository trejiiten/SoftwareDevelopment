const video = document.querySelector('.player');
const canvas = document.querySelector('.photo');
const ctx = canvas.getContext('2d');
const strip = document.querySelector('.strip');
const snap = document.querySelector('.snap');

function getVideo(){
    navigator.mediaDevices.getUserMedia({video: true, audio: false})
        .then(localMediaStream =>{
            console.log(localMediaStream);
            //video.src = window.URL.createObjectURL(localMediaStream); is Depreciated
            video.srcObject = localMediaStream;
            video.play();
        })
        .catch(err=>{
            console.err('OH NO! NOTHING SHOWING', err);
        })
}

function paintToCanvas(){
    const width = video.videoWidth;
    const height = video.videoHeight;
    //console.log(width, height);
    canvas.width = width;
    canvas.height = height;

    return setInterval(()=>{
        ctx.drawImage(video, 0, 0, width, height);
        // Play with the pixels
        let pixels = ctx.getImageData(0,0,width,height);
        //console.log(pixels);
    
        //pixels = redEffect(pixels);
        //pixels = rgbSplit(pixels);
        //pixels = greenScreen(pixels);
        //ctx.globalAlpha = 0.1;
        //debugger;
        // put them back in place
        ctx.putImageData(pixels,0,0);
    }, 16);
}

function takePhoto(){
    // played the sound
    snap.currentTime=0;
    snap.play();

    // Remove data from canvas
    const data = canvas.toDataURL('image/jpeg');
    //console.log(data);
    const link = document.createElement('a');
    link.href = data;
    link.setAttribute('download', 'bald');
    //link.textContent = 'Download Image';
    link.innerHTML=`<img src="${data}" alt="Bald Fraud" />`;
    strip.insertBefore(link, strip.firstChild);
}

function redEffect(pixels){
    for(i=0; i<pixels.data.length;i=i+=4){
        pixels.data[i + 0] = pixels.data[i + 0] + 100; // RED value
        pixels.data[i + 1] = pixels.data[i + 1] - 50; // GREEN value
        pixels.data[i + 2] = pixels.data[i + 2] * 2.5; // BLUE value
    }
    return pixels;
}

function rgbSplit(pixels){
    for(i=0; i<pixels.data.length;i=i+=4){
        pixels.data[i - 150] = pixels.data[i + 0]; // RED value
        pixels.data[i + 100] = pixels.data[i + 1]; // GREEN value
        pixels.data[i - 150] = pixels.data[i + 2]; // BLUE value
    }
    return pixels;
}

function greenScreen(pixels) {
    const levels = {};
  
    document.querySelectorAll('.rgb input').forEach((input) => {
      levels[input.name] = input.value;
    });
  
    for (i = 0; i < pixels.data.length; i = i + 4) {
      red = pixels.data[i + 0];
      green = pixels.data[i + 1];
      blue = pixels.data[i + 2];
      alpha = pixels.data[i + 3];
  
      if (red >= levels.rmin
        && green >= levels.gmin
        && blue >= levels.bmin
        && red <= levels.rmax
        && green <= levels.gmax
        && blue <= levels.bmax) {
        // take it out!
        pixels.data[i + 3] = 0;
      }
    }
  
    return pixels;
  }
  

getVideo();

video.addEventListener('canplay', paintToCanvas);