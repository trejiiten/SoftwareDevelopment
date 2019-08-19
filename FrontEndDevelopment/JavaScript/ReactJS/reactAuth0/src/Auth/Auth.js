
import auth0 from 'auth0-js';

export default class Auth {
  auth0 = new auth0.WebAuth({
    domain: 'toddrings.auth0.com',
    clientID: 'k3fxtu2CCfswaGh-KMo6_1NHT-mtAZtR',
    redirectUri: 'http://localhost:3000/callback',
    audience: 'https://toddrings.auth0.com/userinfo',
    responseType: 'token id_token',
    scope: 'openid'
  });

  login() {
    this.auth0.authorize();
  }
}