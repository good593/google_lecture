import {Provider, useSelector, useDispatch} from 'react-redux';
import store from '../redux/store';
import Counter from '../components/Counter';

function ToolkitPage() {
  return (
    <Provider store={store}>
        <Counter />
    </Provider>
  );
}

export default ToolkitPage;
