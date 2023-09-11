import React from "react";
import Left1 from '../components/reduxLeft';
import Right1 from '../components/reduxRight';

import {createStore} from 'redux';
import {Provider, useSelector, useDispatch, connect} from 'react-redux';

function reducer(currentState, action) {
    if (currentState === undefined) {
        return {
            number: 1
        }
    }
    const newState = {...currentState};

    if (action.type === 'PLUS') {
        newState.number ++;
    }

    return newState;
};

const store = createStore(reducer);

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



