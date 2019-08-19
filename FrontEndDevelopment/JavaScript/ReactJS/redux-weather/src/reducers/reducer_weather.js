import { FETCH_WEATHER } from "../actions/index";

export default function (state = [], action) {
    switch (action.type) {
        case FETCH_WEATHER:
            // ALWAYS return a new instance of state
            //return state.concat([action.payload.data]);
            // Below is the ES6 variation
            return [ action.payload.data, ...state ];
    }
    return state;
}