import React, { Component } from 'react';
import $ from 'jquery';
import './App.css';
import Header from './Components/Header';
import About from './Components/About';
import Resume from './Components/Resume';

import Footer from './Components/Footer';

class App extends Component {

  constructor(props){
  super(props);
    this.state = {
      foo: 'bar',
      resumeData: {}
    }
  }

  getResumeData(){
    $.ajax({
      url: './resumeData.json',
      dataType: 'json',
      cache: false,
      success: function(data){
        this.setState({resumeData: data});
      }.bind(this),
      error: function(xhr, status, err){
        console.log(err);
        alert(err);
      }
    })
  }

  componentDidMount(){
    this.getResumeData();
  }

  render() {

    console.log(this.state.resumeData);
    return (
      <div className="App">
      <Header data={this.state.resumeData.main} />
      <About data={this.state.resumeData.main} />
      <Resume data={this.state.resumeData.resume} />
      
      <Footer />
      </div>
    );
  }
}

export default App;
