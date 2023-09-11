import React, {useState} from "react";

const Login= () => {
    const [inputs, setInputs] = useState({
        name: "",
        email: "",
        tel: ""
    });

    const {name, email, tel} = inputs 

    const onChange = (e) => {
        const value = e.target.value;
        const name = e.target.name;

        setInputs({
            ...inputs,
            [name] : value 
        })
    };

    return (
        <div>
            <div>
                <label>이름</label>
                <input type="text" name="name" value={name} onChange={onChange} />
            </div>
            <div>
                <label>이메일</label>
                <input type="email" name="email" value={email} onChange={onChange} />
            </div>
            <div>
                <label>전화번호</label>
                <input type="tel" name="tel" value={tel} onChange={onChange} />
            </div>
            <p>이름: {name}</p>
            <p>이메일: {email}</p>
            <p>전화번호: {tel}</p>
        </div>
    )
}

export default Login;