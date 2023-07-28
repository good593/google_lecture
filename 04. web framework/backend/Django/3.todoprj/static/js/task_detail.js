window.onload = function() {
    let f = document.getElementsByTagName("form")[0];
    for(let i=0,fLen=f.length;i<fLen;i++){
        f.elements[i].readOnly = true; 
        if(f.elements[i].type == "checkbox") {
            f.elements[i].onclick =  function checkClickFunc() {
                return false;
            }
        }
    }
}