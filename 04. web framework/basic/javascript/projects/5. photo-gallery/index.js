const btnEl = document.getElementById("btn");
const errorMessageEl = document.getElementById("errorMessage");
const galleryEl = document.getElementById("gallery");

async function fetchImage() {
    const inputValue = document.getElementById("input").value;

    if (inputValue > 10 || inputValue < 1) {
        errorMessageEl.style.display = "block";
        errorMessageEl.innerText = "Number should be between 0 and 11";
    return;
    }

    imgs = "";

    try {
        btnEl.style.display = "none";
        const loading = `<img src="spinner.svg" />`;
        galleryEl.innerHTML = loading;
        // fetch(): url 주소를 통해 서버와 통신!!
        await fetch(
            `https://api.unsplash.com/photos?per_page=${inputValue}&page=${Math.round(
            Math.random() * 1000
            )}&client_id=B8S3zB8gCPVCvzpAhCRdfXg_aki8PZM_q5pAyzDUvlc`
        )
        // then(): fetch() 통신 결과(response)
        .then((response) =>
            // response(서버 응답 객체)
            response.json()
                // data(서버로부터 받은 데이터(이미지들))
                .then((data) => {
                    // 만약 data(이미지들) 있다면, 
                    if (data) {
                        alert(data.length);
                        // // 각 이미지들을 화면에 그려주세요.
                        data.forEach((pic) => {
                        imgs += `
                        <img src=${pic.urls.small} alt="image"/>
                        `;
                        galleryEl.style.display = "block";
                        galleryEl.innerHTML = imgs;
                        btnEl.style.display = "block";
                        errorMessageEl.style.display = "none";
                        });
                    }
                })
        );
    } catch (error) {

        console.log(error);
        errorMessageEl.style.display = "block";
        errorMessageEl.innerHTML = "An error happened, try again later";
        btnEl.style.display = "block";
        galleryEl.style.display = "none";
    }
}

btnEl.addEventListener("click", fetchImage);