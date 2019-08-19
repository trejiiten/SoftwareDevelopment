import React, { Component } from 'react';
import './App.css';
var uuid = require('uuid');
var firebase = require('firebase');


var config = {
  apiKey: "AIzaSyBgig7-SFHlH8BFpUjZVP00iKakfC7j0PA",
  authDomain: "simple-survey-f689b.firebaseapp.com",
  databaseURL: "https://simple-survey-f689b.firebaseio.com",
  projectId: "simple-survey-f689b",
  storageBucket: "simple-survey-f689b.appspot.com",
  messagingSenderId: "1516337105"
};
firebase.initializeApp(config);


class App extends Component {
  constructor(props){
    super(props);
    this.state={
      id: uuid.v1(),
      name:'',
      answers: {
        q1:'',
        q2:'',
        q3:'',
        q4:''
      },
      submitted: false
    }
    this.handleQuestionChange = this.handleQuestionChange.bind(this);
  }

  handleNameSubmit(event){
    var name = this.refs.name.value;
    this.setState({name:name}, ()=>{
      console.log(this.state);
    });
    event.preventDefault();
  }

  handleQuestionSubmit(event){
    firebase.database().ref('surveys/'+this.state.id).set({
      name: this.state.name,
      answers: this.state.answers
    });
    this.setState({submitted:true},()=>{
      console.log('Questions Submitted!'); 
    });
    event.preventDefault();
  }

  handleQuestionChange(event){
    var answers = this.state.answers;
    //console.log(event.target.value);
    if(event.target.name === 'q1'){
      answers.q1 = event.target.value;
    } else if(event.target.name === 'q2'){
      answers.q2 = event.target.value;
    } else if(event.target.name === 'q3'){
      answers.q3 = event.target.value;
    } else if(event.target.name === 'q4'){
      answers.q4 = event.target.value;
    }
    this.setState({answers:answers}, ()=>{
      console.log(this.state);
    });
  }

  render() {
    var user;
    var questions;
    if(this.state.name && this.state.submitted === false){
      user = <h2>Welcome {this.state.name}</h2>;
      questions =
      <span>
        <h3>Survey Questions</h3>
          <form onSubmit = {this.handleQuestionSubmit.bind(this)}>
            <div>
              <label>What is your favorite OS (Operating System)?</label><br />
                <input type="radio" name="q1" value="Windows" onChange = {this.handleQuestionChange} /> Windows <br />
                <input type="radio" name="q1" value="OSX" onChange = {this.handleQuestionChange} /> OSX <br />
                <input type="radio" name="q1" value="Linux" onChange = {this.handleQuestionChange} /> Linux <br />
                <input type="radio" name="q1" value="Solaris" onChange = {this.handleQuestionChange} /> Solaris <br />
                <input type="radio" name="q1" value="Other" onChange = {this.handleQuestionChange} /> Other <br />
            </div>
            <div>
              <label>What is your favorite brand of TV?</label><br />
                <input type="radio" name="q2" value="Sony" onChange = {this.handleQuestionChange} /> Sony <br />
                <input type="radio" name="q2" value="Samsung" onChange = {this.handleQuestionChange} /> Samsung <br />
                <input type="radio" name="q2" value="Panasonic" onChange = {this.handleQuestionChange} /> Panasonic <br />
                <input type="radio" name="q2" value="Vizio" onChange = {this.handleQuestionChange} /> Vizio <br />
                <input type="radio" name="q2" value="Other" onChange = {this.handleQuestionChange} /> Other <br />
            </div>
            <div>
              <label>What is your favorite Smartphone Brand?</label><br />
                <input type="radio" name="q3" value="Apple" onChange = {this.handleQuestionChange} /> Apple <br />
                <input type="radio" name="q3" value="Android" onChange = {this.handleQuestionChange} /> Android <br />
                <input type="radio" name="q3" value="Hwawei" onChange = {this.handleQuestionChange} /> Hwawei <br />
                <input type="radio" name="q3" value="Nexus" onChange = {this.handleQuestionChange} /> Nexus <br />
                <input type="radio" name="q3" value="Other" onChange = {this.handleQuestionChange} /> Other <br />
            </div>
            <div>
              <label>What is your favorite 90s K-Pop IDOL Group?</label><br />
                <input type="radio" name="q4" value="HOT" onChange = {this.handleQuestionChange} /> H.O.T <br />
                <input type="radio" name="q4" value="Sechskies" onChange = {this.handleQuestionChange} /> Sechskies <br />
                <input type="radio" name="q4" value="SES" onChange = {this.handleQuestionChange} /> S.E.S <br />
                <input type="radio" name="q4" value="Finkl" onChange = {this.handleQuestionChange} /> FinKL <br />
                <input type="radio" name="q4" value="Other" onChange = {this.handleQuestionChange} /> Other <br />
            </div>
            <input type="submit" value="Submit" />
          </form>
      </span>
    } else if (!this.state.name && this.state.submitted === false){
      user = <span onSubmit={this.handleNameSubmit.bind(this)}>
        <h2>Please enter your name to begin the survey.</h2>
        <form>
          <input type="text" placeholder="Enter Name..." ref="name" />
        </form>
      </span>;
      questions = '';
    } else if (this.state.submitted === true) {
      user = <h2>Thank You {this.state.name}</h2>
    }
    return (
      <div className="App">
        <header className="App-header text-center">

          <h1 className="App-title">Simple Survey</h1>
        </header>
        <div className="text-center">
        {user}
        </div>
        <div className="container">
        {questions}
        </div>
      </div>
    );
  }
}

export default App;
