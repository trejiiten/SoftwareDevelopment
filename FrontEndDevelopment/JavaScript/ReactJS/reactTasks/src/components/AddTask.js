import React, { Component } from 'react';
import { Form, Input} from 'muicss/react';

class AddTask extends Component {
    constructor(props){
        super(props);
        this.state = {
            task: ''
        }
    }

    onSubmit(e){
        // call props to target the component above
         this.props.onAddTask(this.state.task);
        // prevent the form from submitting automatically
        e.preventDefault();
    }

    onChange(e){
        // Whatever task will be typed
        this.setState({task: e.target.value}); 
    }
    render() {
        return (
            <Form onSubmit={this.onSubmit.bind(this)}>
                <Input hint="Add Task" onChange={this.onChange.bind(this)}/>
            </Form>
        );
    }
}

export default AddTask;