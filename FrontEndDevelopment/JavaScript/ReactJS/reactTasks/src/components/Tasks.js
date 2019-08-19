import React, { Component } from 'react';
import {Panel} from 'muicss/react';
import TaskItem from './TaskItem';


class Tasks extends Component {
    handleEditState(task, checked){
        this.props.onEditState(task, checked);
    }
    render() {
        let taskItems;
        if(this.props.tasks){
            // tasks comes from main component state in App.js
            taskItems = this.props.tasks.map((task)=>{
                // map the array to access each individual task
                return (
                    <TaskItem 
                        onEditState={this.handleEditState.bind(this)}
                        key={task._id.$oid}
                        task={task}
                    />
                );
            });
        }
        return (
            <Panel>
                {taskItems}
            </Panel>
        );
    }
}

export default Tasks;