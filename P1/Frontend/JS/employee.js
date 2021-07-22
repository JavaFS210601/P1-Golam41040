const url ='http://localhost:8080/P1/'

document.addEventListener('DOMContentLoaded',assembleFunc);
let userprofile = document.getElementById("userprofile");


async function assembleFunc(){
     let response = await fetch(url+'getusername');
    if(response.status===200){
        let data= await response.json();
        var htmlString ='&#x1f464;'+data;
        console.log(data);
        userprofile.insertAdjacentHTML("beforeend",htmlString);
    }
}


let pastRec = document.getElementById("past-ticket");
let newReq = document.getElementById("new-ticket");
let logout = document.getElementById("logout");

pastRec.addEventListener("click",pastRecFunc);
newReq.addEventListener("click",newReqFunc);
logout.addEventListener("click",logoutFunc);


function pastRecFunc(){
    location. href = "employee1.html";
}


function newReqFunc(){
    location.href = "employee2.html";
}

function logoutFunc(){
    location.href = "login.html";
}