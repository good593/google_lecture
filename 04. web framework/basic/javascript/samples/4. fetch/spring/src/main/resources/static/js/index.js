const sendByApi = (method, url, params, server, success_callback, failure_callback) => {
    let content_type = 'application/json'
    let send_url = url
    let options = {
        method: method,
        headers: {
            "Content-Type": content_type
        }
    }

    if(method === 'get') {
        send_url += "?" + new URLSearchParams(params)
    } else {
        options['body'] = JSON.stringify(params)
    }

    fetch(send_url, options)
        .then(response => {
            response.json()
                // API 호출 성공 (서버 호출 성공)
                .then(json => {
                    // 요청 결과 성공 
                    if(response.status >= 200 && response.status < 300) {  // 200 ~ 299
                        if(success_callback) {
                            alert("요청 결과 성공");
                            success_callback(server, json)
                        }
                    }
                    // 요청 결과 오류 
                    else {
                        if (failure_callback) {
                            alert("요청 결과 오류");
                            failure_callback(json)
                        }else {
                            alert(JSON.stringify(json))
                        }
                    }
                })
                // API 호출 오류 (서버 호출 오류)
                .catch(error => {
                    alert("API 호출 오류 (서버 호출 오류)");
                    alert(JSON.stringify(error))
                })
        })

}

const successFnc = (server, json) => {
    api_info[server]['tag'].innerHTML = JSON.stringify(json);
}

const failureFnc = (json) => {
    alert(JSON.stringify(json));
}


async function mainApi(server, url, params) {
    try {
        await sendByApi('get', url, params, server, successFnc, failureFnc);
    } catch(e) {
        console.log(e);
    }
}

const api_info = {
    "java": {
        "host":"http://localhost:8080",
        "tag": document.getElementById("java")
    },
    "python": {
        "host":"http://localhost:8000",
        "tag": document.getElementById("python")
    }
}

let sendApi = document.getElementById("sendApi");

sendApi.onsubmit = (event) => {
    // 리프레쉬 방지!!!
    event.preventDefault();

    let path = sendApi.path.value;
    let server = sendApi.server.value;
    let number = sendApi.number.value;
    number = Number(number);
    
    // 검증
    if(!number) {
        alert("숫자만 입력이 가능합니다.");
        return;
    } else if(!api_info[server]) {
        alert("올바른 서버를 선택해주세요.");
        return;
    }

    // localhost:8080      /api/index
    let url = api_info[server]['host'] + path;
    let params = {
        'num':number
    };

    alert(url);
    mainApi(server, url, params);

};