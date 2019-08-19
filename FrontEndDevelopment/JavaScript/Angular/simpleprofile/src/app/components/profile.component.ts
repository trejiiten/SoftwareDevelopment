import { Component } from '@angular/core';

@Component({
  moduleID: module.id,
  selector: 'profile',
  templateUrl:'profile.component.html'
})
export class ProfileComponent {
  title = 'Hello World';
  showAddress = true;
  person = {
    name: 'John Doe',
    age: 34,
    address:{
      street: '400 Walnut St',
      city: 'Lynn',
      state:'MA'
    },
    avatar:'https://d35bxr3ccprye3.cloudfront.net/images/blank-avatar.gif',
    friends: [
      {name: 'Bob', age: 34},
      {name: 'Jim', age: 32},
      {name: 'Moe', age: 45},
      {name: 'Curly', age: 39},
    ]
  }

  constructor(){
    this.title = 'User Profile';
  }
}
