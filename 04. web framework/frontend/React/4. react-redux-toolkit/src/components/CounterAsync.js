import {Provider,useSelector,useDispatch} from 'react-redux';

import counterAsyncSlice from '../redux/counterAsyncSlice'
import {asyncUpFetch} from '../redux/counterAsyncSlice';


function CounterAsync(){
  const dispatch = useDispatch();
  const count = useSelector(state=>{
    return state.counterAsync.value;
  });
  const status = useSelector(state=>{
    return state.counterAsync.status;
  });
  return (
  <div>
    <button onClick={()=>{
      dispatch(counterAsyncSlice.actions.up(2));
    }}>+</button>  
    
    <button onClick={()=>{
      dispatch(asyncUpFetch());
    }}>+ async fetch</button><br/>
    
    <div>{count} | {status}</div>
  </div>
  )
}

export default CounterAsync;