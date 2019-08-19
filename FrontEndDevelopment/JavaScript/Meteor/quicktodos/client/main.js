// Before publishing for public use:
// Remove "Insecure": meteor remove Insecure
// Remove "Publications": meteor remove autopublish

import { Template } from 'meteor/templating';
import { ReactiveVar } from 'meteor/reactive-var';

import {Tasks} from '../api/tasks.js';
import {Accounts} from 'meteor/accounts-base';

Accounts.ui.config({
  passwordSignupFields: 'USERNAME_ONLY'
});

import './main.html';

/*const todos = [
  {text:'Pickup kid from school', time:'8:00'},
  {text: 'Grocery Shopping', time:'12:00'},
  {text: 'Meeting with boss', time:'16:00'}
];*/

// created because autopublish was removed from project
//subscribe to the server
Template.main.onCreated(function mainOnCreated(){
  Meteor.subscribe('tasks');
});


Template.main.helpers({
  title(){
    return 'Quick Todos';
  },
  tasks(){
    return Tasks.find({},{sort:{createdAt:-1}});
  }
});

Template.main.events({
  'submit .add-task' (event){
    event.preventDefault();
    //console.log('submitted');

    const text = event.target.text.value;


    //console.log(name+' '+time);

    /* Old Insert Task - Replace query with method quotes/calls
    Tasks.insert({
      name,
      createdAt: new Date(),
      owner: Meteor.userId(),
      username: Meteor.user().username
    });*/


    // Insert Task
    Meteor.call('tasks.insert', text);

    //Clear input
    event.target.name.value = '';


  }
});

Template.task.events({
  'click .toggle-checked'(event){
    /*Tasks.update(this._id, {
      $set:{checked: !this.checked}
    });*/
    Meteor.call('tasks.setChecked', this._id, !this.checked);
  },
  'click .delete'(event){
    //Tasks.remove(this._id);
    Meteor.call('tasks.remove', this._id);
  },
  'click .toggle-private'(){
    Meteor.call('tasks.setPrivate', this._id, !this.private);
  }
});


Template.task.helpers({
  isOwner(){
    // Check to see if 'owner field' matches the user ID in the system
    return this.owner === Meteor.userId();
  }
});
