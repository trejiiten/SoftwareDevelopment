import React, { Component } from 'react';
import {Appbar, Container} from 'muicss/react';

class Header extends Component {
    render() {
        let s1 = {verticalAlign: 'middle'};
    

    return (
      <div className="App">
        <Appbar>
          <Container>
            <table width="100%">
              <tbody>
                <tr style={s1}>
                  <td className="mui--appbar-height"><h3>ReactTask</h3></td>
                  
                </tr>
              </tbody>
            </table>
          </Container>
        </Appbar>
      </div>
        );
    }
}

export default Header;