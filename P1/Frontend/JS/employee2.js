const url ='http://localhost:8080/P1/'


let backBut=  document.getElementById("back");
backBut.addEventListener("click",newBackFunc);
function newBackFunc(){
    location.href = "employee.html";
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


let createButton= document.getElementById("create");
createButton.addEventListener("click",createFunc);

 async function createFunc(){
    let amount = document.getElementById("amount").value;
    let receipt = document.getElementById("receipt").value;
    let description = document.getElementById("description").value;
    

    var type =0;
    
    var select = document.getElementById("type"); 
    type= select.value;
    
    if(amount== null||receipt==null||description==null||amount== ""||receipt==""||description==""||type==0){
            alert("Can not leave a field Empty");
            location.href="employee2.html";
        }

    let reimburstment ={
        reimb_amount: amount,
        reimb_description: description,
        reimb_receipt: receipt,
        reimb_type: type
    }
    let response= await fetch(url+"addreimburstment",{
        method: "POST",
        body: JSON.stringify(reimburstment),
        credentials: 'include'
    })
    if(response.status===200){
                
                alert("Success: Reimburstment added!!");
                location.href= "employee.html";
                
                
            }
            else{
                alert("Error: Could not add new Reimburstment!!");
                location.href= "employee2.html";
    }


}