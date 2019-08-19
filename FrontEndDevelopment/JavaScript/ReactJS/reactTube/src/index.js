import _ from 'lodash';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import YTSearch from 'youtube-api-search';
import SearchBar from './components/SearchBar';
import VideoList from './components/VideoList';
import VideoDetail from './components/VideoDetail';
const API_KEY = 'AIzaSyAZG51rEErPJyBAkmZVuJYJWU4V4yBJrCE';

// Class-based component because working with State
class App extends Component {
    constructor(props){
        super(props);
        this.state = {
            videos: [],
            selectedVideo: null
        };

        this.videoSearch('ReactJS');
    }

    videoSearch(term){
        YTSearch({key: API_KEY, term: term}, videos=>{
            this.setState({
                videos: videos,
                selectedVideo: videos[0]
            });
        });
    }

    render() {
        // Throttle user input search (similar to Google Instance Search)
        const videoSearch = _.debounce(term => { this.videoSearch(term)}, 300);
        
        return (
            <div className="container">
                <SearchBar onSearchTermChange={videoSearch}/>
                <VideoDetail video={this.state.selectedVideo}/>
                <VideoList 
                    onVideoSelect={selectedVideo => this.setState({selectedVideo}) }
                    videos={this.state.videos} />
            </div>
        );
    }
}

ReactDOM.render(<App />, document.querySelector('.container'));