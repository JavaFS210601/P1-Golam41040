const url ='http://localhost:8080/P1/'

document.addEventListener('DOMContentLoaded',assembleFunc);

let userprofile = document.getElementById("userprofile");



async function assembleFunc(){

    var response = await fetch(url+'allreimburstments');
    if(response.status===200){
        

        let data= await response.json();
        let table = document.getElementById("reimbody");
        table.innerHTML ="";
       
        for(i=0;i<data.length;i++){
            
            var htmlString ="";
            
            
            htmlString+= '<th scope="row"> '+data[i].reimb_id+ '</th>';
            htmlString+='<td> '+data[i].reimb_amount + '</td>';
            htmlString+='<td> '+data[i].reimb_submitted  + '</td>';
            if(data[i].reimb_status==='Submitted'){
                htmlString+='<td> - </td>';
            }
            else{
                htmlString+='<td> '+data[i].reimb_resolved  + '</td>';
            }
            htmlString+='<td> '+data[i].reimb_description  + '</td>';
            htmlString+='<td> '+data[i].reimb_receipt  + '</td>';
            htmlString+='<td> '+data[i].reimb_author_name  + '</td>';
            if(data[i].reimb_status==='Submitted'){
            htmlString+='<td> - </td>';
            }
            else{
                htmlString+='<td> '+data[i].reimb_solver_name  + '</td>';
            }
            htmlString+='<td> '+data[i].reimb_status  + '</td>';
            htmlString+='<td> '+data[i].reimb_type  + '</td>';
            table.insertAdjacentHTML ("beforeend",htmlString);
        }
    }
    response = await fetch(url+'getusername');
    if(response.status===200){
        let data= await response.json();
        var htmlString ='&#x1f464;'+data;
        console.log(data);
        userprofile.insertAdjacentHTML("beforeend",htmlString);
    }

}





let backBut=  document.getElementById("back-button");


backBut.addEventListener("click",newBackFunc);




function newBackFunc(){
    location.href = "manager.html";
}





let subButton = document.getElementById("sub-button");

subButton.addEventListener("click",subButtonFunc);

async function subButtonFunc(){
   

    var response = await fetch(url+'allreimburstments');
    if(response.status===200){

        let data= await response.json();
        let table = document.getElementById("reimbody");
        table.innerHTML ="";

        
         for(i=0;i<data.length;i++){
             var htmlString ="";
            if(data[i].reimb_status==='Submitted'){
                htmlString+= '<th scope="row"> '+data[i].reimb_id   + '</th>';
                htmlString+='<td> '+data[i].reimb_amount + '</td>';
                    htmlString+='<td> '+data[i].reimb_submitted  + '</td>';
                    htmlString+='<td> - </td>';
                    htmlString+='<td> '+data[i].reimb_description  + '</td>';
                    htmlString+='<td> '+data[i].reimb_receipt  + '</td>';
                    htmlString+='<td> '+data[i].reimb_author_name  + '</td>';
                    htmlString+='<td> - </td>';
                    htmlString+='<td> '+data[i].reimb_status  + '</td>';
                    htmlString+='<td> '+data[i].reimb_type  + '</td>';
                    table.insertAdjacentHTML ("beforeend",htmlString);
                }
         }   
    }   
   
}

let denButton = document.getElementById("den-button");

denButton.addEventListener("click",denButtonFunc);

async function denButtonFunc(){
     
    var response = await fetch(url+'allreimburstments');
    if(response.status===200){
        let data= await response.json();
        let table = document.getElementById("reimbody");
        table.innerHTML ="";

        
        for(i=0;i<data.length;i++){
            var htmlString ="";
            if(data[i].reimb_status==='Denied'){
                htmlString+= '<th scope="row"> '+data[i].reimb_id   + '</th>';
                htmlString+='<td> '+data[i].reimb_amount + '</td>';
                    htmlString+='<td> '+data[i].reimb_submitted  + '</td>';
                    htmlString+='<td> '+data[i].reimb_resolved  + '</td>';
                    htmlString+='<td> '+data[i].reimb_description  + '</td>';
                    htmlString+='<td> '+data[i].reimb_receipt  + '</td>';
                    htmlString+='<td> '+data[i].reimb_author_name  + '</td>';
                    htmlString+='<td> '+data[i].reimb_solver_name  + '</td>';
                    htmlString+='<td> '+data[i].reimb_status  + '</td>';
                    htmlString+='<td> '+data[i].reimb_type  + '</td>';
                    table.insertAdjacentHTML ("beforeend",htmlString);
                }
        }   
    }
}

let accButton = document.getElementById("acc-button");

accButton.addEventListener("click",accButtonFunc);

async function accButtonFunc(){
    var response = await fetch(url+'allreimburstments');
    if(response.status===200){
        let data= await response.json();
        let table = document.getElementById("reimbody");
        table.innerHTML ="";

        
        for(i=0;i<data.length;i++){
            var htmlString ="";
            if(data[i].reimb_status==='Approved'){
                htmlString+= '<th scope="row"> '+data[i].reimb_id   + ' </th>';
                htmlString+='<td> '+data[i].reimb_amount + '</td>';
                    htmlString+='<td> '+data[i].reimb_submitted  + '</td>';
                    htmlString+='<td> '+data[i].reimb_resolved  + '</td>';
                    htmlString+='<td> '+data[i].reimb_description  + '</td>';
                    htmlString+='<td> '+data[i].reimb_receipt  + '</td>';
                    htmlString+='<td> '+data[i].reimb_author_name  + '</td>';
                    htmlString+='<td> '+data[i].reimb_solver_name  + '</td>';
                    htmlString+='<td> '+data[i].reimb_status  + '</td>';
                    htmlString+='<td> '+data[i].reimb_type  + '</td>';
                    table.insertAdjacentHTML ("beforeend",htmlString);
                }
        }   
    }
}

let allButton = document.getElementById("all-button");

allButton.addEventListener("click",allButtonFunc);



async function allButtonFunc(){

    var response = await fetch(url+'allreimburstments');
    if(response.status===200){
        

        let data= await response.json();
        let table = document.getElementById("reimbody");
        table.innerHTML ="";
       
        for(i=0;i<data.length;i++){
            
            var htmlString ="";
            
            
            htmlString+= '<th scope="row"> '+data[i].reimb_id+ '</th>';
            htmlString+='<td> '+data[i].reimb_amount + '</td>';
            htmlString+='<td> '+data[i].reimb_submitted  + '</td>';
            if(data[i].reimb_status==='Submitted'){
                htmlString+='<td> - </td>';
            }
            else{
                htmlString+='<td> '+data[i].reimb_resolved  + '</td>';
            }
            htmlString+='<td> '+data[i].reimb_description  + '</td>';
            htmlString+='<td> '+data[i].reimb_receipt  + '</td>';
            htmlString+='<td> '+data[i].reimb_author_name  + '</td>';
            if(data[i].reimb_status==='Submitted'){
            htmlString+='<td> - </td>';
            }
            else{
                htmlString+='<td> '+data[i].reimb_solver_name  + '</td>';
            }
            htmlString+='<td> '+data[i].reimb_status  + '</td>';
            htmlString+='<td> '+data[i].reimb_type  + '</td>';
            table.insertAdjacentHTML ("beforeend",htmlString);
        }
    }
    

}