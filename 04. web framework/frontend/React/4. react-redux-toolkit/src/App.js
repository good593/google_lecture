
import './App.css';

import {Provider, useSelector, useDispatch} from 'react-redux';
import store from './redux/store';
import counterSlice from './redux/counterSlice';

function Counter() {
  const dispatch = useDispatch();
  const count = useSelector(state=>state.counter.value);
  return (<div>
    <button onClick={()=>{
      dispatch(counterSlice.actions.up(2));
    }}>+</button> <button onClick={()=>{
      dispatch(counterSlice.actions.down(2));
    }}>-</button> {count}
  </div>)
}


function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <Counter />
      </div>
    </Provider>
  );
}

export default App;
