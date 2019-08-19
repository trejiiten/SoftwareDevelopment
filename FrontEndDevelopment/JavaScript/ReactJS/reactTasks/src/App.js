import React, { Component } from 'react';
import axios from 'axios';
import Header from './components/Header';
import {Container, Button} from 'muicss/react';
import Tasks from './components/Tasks';
import AddTask from './components/AddTask';

import './App.css';

class App extends Component {
  constructor(){
    super();
    this.state = {
      tasks:[]
    }
  }

  componentWillMount(){
    this.getTasks();
  }

  getTasks(){
    axios.request({
      method:'GET',
      url:'https://api.mlab.com/api/1/databases/react_task/collections/tasks?apiKey=wmxnNPpCS2BCsUns1DGXkBX-nLd-gY0A'
    }).then((response) => {
      this.setState({tasks: response.data}, () => {
        console.log(this.state);
      });
    }).catch((error) => {
      console.log(error);
    });
  }

  editState(task, checked){
    //console.log(task);
    //console.log(checked);
    // make request to change "complete" in DB
      axios.request({
        method:'PUT',
        url:'https://api.mlab.com/api/1/databases/reacttasks/collections/tasks/'+task._id.$oid+'?apiKey=wmxnNPpCS2BCsUns1DGXkBX-nLd-gY0A',
        data: {
          text: task.text,
          completed: checked
        }
      }).then((response) => {
        let tasks = this.state.tasks;
        for(let i = 0;i < tasks.length;i++){
          if(tasks[i]._id.$oid === response.data._id.$oid){
            tasks[i].completed = checked;
          }
        }
        this.setState({tasks: tasks});
      }).catch((error) => {
        console.log(error);
      });
    }

    addTask(text){
      //console.log(text);
      axios.request({
        method:'POST',
        url:'https://api.mlab.com/api/1/databases/react_task/collections/tasks?apiKey=wmxnNPpCS2BCsUns1DGXkBX-nLd-gY0A',
        data: {
          text: text,
          completed: false
        }
      }).then((response) => {
        let tasks = this.state.tasks;
        tasks.push({
          _id: response.data._id,
          text: text,
          completed: false
        });
        this.setState({tasks: tasks});
      }).catch((error) => {
        console.log(error);
      });
    }

    clearTasks(){
      let tasks = this.state.tasks;
      let i = tasks.length;

      while(i--){
        if(tasks[i].completed === true){
          let id = tasks[i]._id.$oid;
          tasks.splice(i, 1);

          axios.request({
            method: 'DELETE',
            url: 'https://api.mlab.com/api/1/databases/reacttasks/collections/tasks/'+id+'?apiKey=wmxnNPpCS2BCsUns1DGXkBX-nLd-gY0A',
          }).then( response => {

          }).catch( error => {
            console.log(error);
          })
        }
      }

      this.setState = ({tasks: tasks});
    }

  render() {
    return (
      <div className="App">
        <Header />
        <br />
        <Container>
        <AddTask onAddTask={this.addTask.bind(this)} />
        <Tasks 
            onEditState={this.editState.bind(this)} 
            tasks={this.state.tasks} 
          />
          <Button 
            color="danger" 
            onClick={this.clearTasks.bind(this)} 
            >Clear Completed</Button>
        </Container>
      </div>
    );
  }
}

export default App;
