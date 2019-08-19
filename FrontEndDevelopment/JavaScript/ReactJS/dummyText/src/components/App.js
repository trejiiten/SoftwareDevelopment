import React, { Component } from 'react';
import './App.css';
import Output from './Output';
import Text from './controls/Text';
import Select from './controls/Select';
import axios from 'axios';


class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      paras: 4,
      html: true,
      text: ''
    }
  }

  componentWillMount(){
    this.getText();
  }

  getText(){
    const url = 'https://cors-anywhere.herokuapp.com/'
    axios.get(url+'http://hipsterjesus.com/api?paras='+this.state.paras+'&html='+this.state.html).then(
      (response)=>{
      this.setState({ text: response.data.text}, 
        function(){
        //console.log(this.state);
      });
    }).catch((err)=>{
      console.log(err);
    })
  }

  changeParas(number){
    this.setState({paras:number},this.getText );
  }

  showHtml(x){
    this.setState({html:x}, this.getText)
  }
  render() {
    return (
      <div className="container">
       <h1>Dummy Text Generator</h1>
       <Output value={this.state.text} />
       <h3>Real Time Options</h3>
       <form>
         <div>
           <label>Paragraphs: </label>
           <Text value={this.state.paras} onChange={this.changeParas.bind(this)}/>
         </div>
         <div>
           <label>Include HTML: </label>
           <Select value={this.state.html} onChange={this.showHtml.bind(this)}/>
         </div>
       </form>
      </div>
    );
  }
}

export default App;
