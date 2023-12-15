/*
비동기 예제 함수!!
*/
const asyncFnc = () => {
    alert("[비동기] 첫번째야~~~");

    setTimeout(() => {
        alert("[비동기] 두번째야~~~");
    }, 2000)
    
    alert("[비동기] 세번째야~~~");
}

// 비동기 예제 함수!!
// asyncFnc();

/*
여기부터는 동기 예제 함수!!
*/
function somAsyncTask() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("[동기] 두번째야~~~")
        }, 2000);
    })
        .then((result) => {
            alert(result);
            return "[동기] 세번째야~~~"
        })
            .then((result) => {
                alert(result);
                return "[동기] 네번째야~~~"
            })
}

async function main() {
    alert("[동기] 첫번째야~~~");

    const result = await somAsyncTask();
    
    alert(result);
}

main();

