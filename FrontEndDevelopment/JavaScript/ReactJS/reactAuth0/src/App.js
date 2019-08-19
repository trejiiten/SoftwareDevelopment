import React, { Component } from 'react';
import Auth0Lock from 'auth0-lock';
import { Grid, Row, Col } from 'react-bootstrap';
import Header from './components/Header';
import Home from './components/Home';
import Dashboard from './components/Dashboard';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

class App extends Component {
  constructor(){
    super();
    this.state={
      accessToken: '',
      profile: {}
    }
  }

  static defaultProps ={
    clientId: 'eQXfg94RcYCHHuZDfLRKHQRRQBg26cfY',
    domain: 'toddrings.auth0.com'
  }

  componentWillMount(){
    this.lock = new Auth0Lock(this.props.clientId, this.props.domain);

    // On authentication
    this.lock.on('authenticated', (authResult) => {
      //console.log(authResult);
      this.lock.getUserInfo(authResult.accessToken, (error, profile) => {
        if(error){
          console.log(error);
          return;
        }

        //console.log(profile);
        this.setData(authResult.accessToken, profile);
      });
    });

    // Get Data
    this.getData(); 
  }

  // Set accessToken and Profile Data to Local Storage
  setData(accessToken, profile){
    localStorage.setItem('accessToken', accessToken);
    localStorage.setItem('profile', JSON.stringify(profile));
    this.setState({
      accessToken: localStorage.getItem('accessToken'),
      profile: JSON.parse(localStorage.getItem('profile'))
    });
  }

  // Check for accessToken and GET profile data from Local Storage
  getData(){
    if(localStorage.getItem('accessToken') != null){
      this.setState({
        accessToken: localStorage.getItem('accessToken'),
        profile: JSON.parse(localStorage.getItem('profile'))
      }, () => {
        console.log(this.state);
      });
    }
  }
  // Show the Auth0 login modal to login to app
  showLock(){
    this.lock.show();
  }

  // Logout from app
  logout(){
    this.setState({
      accessToken:'',
      profile: '',
    }, () => {
      localStorage.removeItem('accessToken');
      localStorage.removeItem('profile');
    });
  }

  render() {
    let page;
    if(this.state.accessToken){
      page = <Dashboard 
                lock={this.lock}
                accessToken={this.state.accessToken}
                profile={this.state.profile}
              />
    } else {
      page = <Home />
    }
    return (
      <div className="App">
        <Header 
          lock={this.lock}
          accessToken={this.state.accessToken}
          profile={this.state.profile}
          onLoginClick={this.showLock.bind(this)}
          onLogoutClick={this.logout.bind(this)}
        />
        <Grid>
          <Row>
            <Col xs={12} md={12}>
              {page}
            </Col>
          </Row>
        </Grid>
      </div>
    );
  }
}

export default App;
