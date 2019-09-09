const arrow = document.querySelector(".arrow");
const speed = document.querySelector(".speed-value");

navigator.geolocation.watchPosition(
  data => {
    // console.log(data);
    speed = Math.round(data.coords.speed);
    arrow.style.transform = `rotate(${data.coords.heading}deg)`;
  },
  err => {
    console.err(err);
    alert("You need to allow for functionality");
  }
);
