import React, {useState} from "react";

const Input= () => {
    const [txtValue, setTextValue] = useState("");
    const onChange = (e) => {
        setTextValue(e.target.value)
    }

    return (
        <div>
            <input type="text" value={txtValue} onChange={onChange} />
            <br />
            <p>{txtValue}</p>
        </div>
    )
}

export default Input;