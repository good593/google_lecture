function Right1(props) {
    return (
        <div>
        <h1>Right1</h1>
        <Right2 
            onIncrease = {() => {
            props.onIncrease();
            }}
        />
        </div>
    )
}

export default Right1;

function Right2(props) {
    return (
        <div>
        <h1>Right2</h1>
        <Right3 
            onIncrease = {() => {
            props.onIncrease();
            }}
        />
        </div>
    )
}

function Right3(props) {
    return (
        <div>
        <h1>Right3</h1>
        <input type='button' value="+" onClick={() => {
            props.onIncrease();
        }} />
        </div>
    )
}
