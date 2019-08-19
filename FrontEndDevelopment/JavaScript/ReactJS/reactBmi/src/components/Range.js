import React, { Component } from 'react';



class Range extends Component {

    constructor(props){
        super(props);
        this.state={
            value: props.value
        }
    }

    static defaultProps = {
        min:0,
        max:245,
        step: 1
    }

    onChange(e){
        // console.log(e.target.value);
        this.props.onChange(this.state.value);
        this.setState({
            value:e.target.value
        });
    }

  render() {
    return (
      <div className="range">
        {/*With set value, slider does not move because React uses controlled components*/}
        {/*Must call an onChange() attribute to allow slider movement*/}
        <input 
            type="range" 
            value={this.state.value} 
            
            min={this.props.min}
            max={this.props.max}
            step={this.props.step}
            
            onChange={this.onChange.bind(this)}
        />
        
      </div>
    );
  }
}

/*Range.propTypes = {min: React.PropTypes.number.isRequired, max: React.PropTypes.number.isRequired, step: React.PropTypes.number.isRequired}*/

export default Range;
