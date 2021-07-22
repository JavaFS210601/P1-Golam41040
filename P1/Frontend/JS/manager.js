const url ='http://localhost:8080/P1/'


let allRec = document.getElementById("all-ticket");
let updateRec = document.getElementById("update-ticket");
let logout = document.getElementById("logout");

allRec.addEventListener("click",allRecFunc);
updateRec.addEventListener("click",updateRecFunc);
logout.addEventListener("click",logoutFunc);


function allRecFunc(){
    location. href = "manager1.html";
}

function logoutFunc(){
    location.href = "login.html";
}

function updateRecFunc (){
    location.href = "manager2.html";
}



document.addEventListener('DOMContentLoaded',assembleFunc);
let userprofile = document.getElementById("userprofile");

async function assembleFunc(){

    response = await fetch(url+'getusername');
    if(response.status===200){
        let data= await response.json();
        var htmlString ='&#x1f464;'+data;
        userprofile.insertAdjacentHTML("beforeend",htmlString);
    }
}