
import {Provider, useSelector, useDispatch, connect} from 'react-redux';

function Left1() {
  const number = useSelector((state) => state.number) 
  return (
    <div>
      <h1>Left1 : {number}</h1>
      <Left2 />
    </div>
  )
}

export default Left1;

function Left2() {
  const number = useSelector((state) => state.number) 
  return (
    <div>
      <h1>Left2 : {number}</h1>
      <Left3 />
    </div>
  )
}

function Left3() {
  const number = useSelector((state) => state.number) 
  return (
    <div>
      <h1>Left3 : {number}</h1>
    </div>
  )
}
