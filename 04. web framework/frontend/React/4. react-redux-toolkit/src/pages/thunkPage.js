import {Provider, useSelector, useDispatch} from 'react-redux';
import store from '../redux/store';
import CounterAsync from '../components/CounterAsync';

function ThunkPage() {
  return (
    <Provider store={store}>
        <CounterAsync />
    </Provider>
  );
}

export default ThunkPage;

