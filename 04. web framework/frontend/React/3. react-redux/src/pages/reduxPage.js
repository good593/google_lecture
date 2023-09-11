import React from "react";
import Left1 from '../components/reduxLeft';
import Right1 from '../components/reduxRight';

import {createStore} from 'redux';
import {Provider, useSelector, useDispatch, connect} from 'react-redux';

function reducer(currentState, action) {
    

    if (action.type === 'PLUS') {
        const newState = {...currentState};
        newState.number ++;
        return newState;
    } else if (action.type === 'MINUS') {
        return {...currentState, number:currentState.number - action.step }
    }

    return currentState
};

const initialState = {number: 1}
const store = createStore(reducer, initialState);

function Redux() {
    return (
        <div>
            <h1>Redux Root</h1>
            <div className='grid'>
                <Provider store={store}>
                    <Left1 />
                    <Right1 />
                </Provider>
            </div>
        </div>
    )
}

export default Redux;



