React + d3.js to create a simple bar chart

I used the create-react-app function to get my application started:
<code>create-react-app chart-app</code>

I then installed d3.js to create the graph
<code>npm i --save d3</code> 

and ReactFauxDOM to creat a DOM-like structure within this app
<code>npm i --save react-faux-dom</code>

followed by starting the development server on my localhost
<code>npm run start</code>

I created a components folder for the bar chart itself (labled BarChart.js) while I set the initial state in the App.js file in the src folder.

The data an of course be changed in any way, as can the styling of the mouseover options to show the data.

This was just a simple app to demonstrate using React with d3. Another data visualation language, p5.js looks interesting, and I will play around with that some time in the future. I suggest watching videos by [The Coding Train](https://www.youtube.com/user/shiffman/featured) for more information on p5.js.

Happy Trails

-T