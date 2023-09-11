import React, {useState} from 'react';
import Left1 from '../components/propsLeft';
import Right1 from '../components/propsRight';


function Props() {
    const [number, setNumber] = useState(1);

    return (
        <div>
            <h1>Props Root</h1>
            <div className='grid'>
                <Left1 number={number} />
                <Right1 
                    onIncrease = {() => {
                        setNumber(number +1);
                    }}
                />
            </div>
        </div>
    )
}

export default Props;