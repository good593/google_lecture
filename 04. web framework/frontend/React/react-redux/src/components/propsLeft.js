
function Left1(props) {
  return (
    <div>
      <h1>Left1 : {props.number}</h1>
      <Left2 number={props.number} />
    </div>
  )
}

export default Left1;

function Left2(props) {
  return (
    <div>
      <h1>Left2 : {props.number}</h1>
      <Left3 number={props.number} />
    </div>
  )
}

function Left3(props) {
  return (
    <div>
      <h1>Left3 : {props.number}</h1>
    </div>
  )
}
