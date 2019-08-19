import axios from 'axios'

const API_KEY = '75912877eb812d05b72606455d30e0e3';
const ROOT_URL = `https://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;

export const FETCH_WEATHER = 'FETCH_WEATHER';

export function fetchWeather(city) {
    const url = `${ROOT_URL}&q=${city},us`;
    const request = axios.get(url);



    return {
        type: FETCH_WEATHER,
        // Return the Promise as the Payload
        payload: request
    };
}