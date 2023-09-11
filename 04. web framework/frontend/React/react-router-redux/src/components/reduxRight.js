import {Provider, useSelector, useDispatch, connect} from 'react-redux';

function Right1() {
    return (
        <div>
        <h1>Right1</h1>
        <Right2 />
        </div>
    )
}

export default Right1;

function Right2() {
    return (
        <div>
        <h1>Right2</h1>
        <Right3 />
        </div>
    )
}

function Right3() {
    const dispatch = useDispatch();
    return (
        <div>
        <h1>Right3</h1>
        <input type='button' value="+" onClick={() => {
            dispatch({type:'PLUS'})
        }} />
        </div>
    )
}
