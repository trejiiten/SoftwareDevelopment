import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class Navbar extends React.Component({
  render(){
    return(
      <nav className="navbar navbar-default">
        <div className="container">
          <div className="navbar-header">
            <a className="navbar-brand" href="#">ReactStrap</a>
          </div>
          <div id="navbar">
            <ul className="nav navbar-nav">
              <li className="active"><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
        </div>
      </nav>
    );
  }
});

class Jumbotron extends React.Component({
  render(){
    return(
      <div>
      <div className="jumbotron">
        <div className="container">
          <h1>Hello, world!</h1>
          <p className="lead">This is a Bootstrap theme that uses React.js components</p>
          <p><a className="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
        </div>
      </div>
      </div>
    );
  }
});

class Page extends React.Component({
  render(){
    return(
      <div>
        <div className="container">
          This is the home page
        </div>
      </div>
    );
  }
});
class Theme extends React.Component({
  render(){
    return(
      <div>
        <Navbar />
        <Jumbotron />
        <Page />
      </div>
    );
  }
});

ReactDOM.render(
  <div>
    <Theme />
  </div>,
  document.getElementById('root'));
