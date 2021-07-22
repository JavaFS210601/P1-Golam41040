const url ='http://localhost:8080/P1/'

document.addEventListener('DOMContentLoaded',assembleFunc);
let userprofile = document.getElementById("userprofile");


async function assembleFunc(){

    var response = await fetch(url+'userreimburstments');
    if(response.status===200){
        

        let data= await response.json();
        var j=0;
        for(i=0;i<data.length;i++){
            j++;
            let table = document.getElementById("reimbody");
            var htmlString ="";
             htmlString+= '<th scope="row">'+data[i].reimb_id   + '</th>';
             htmlString+='<td> '+data[i].reimb_amount + '</td>';
             htmlString+='<td> '+data[i].reimb_submitted  + '</td>';
             if(data[i].reimb_resolved===null){
                 htmlString+='<td> - </td>';
             }
             else{
             htmlString+='<td> '+data[i].reimb_resolved  + '</td>';
             }
             htmlString+='<td> '+data[i].reimb_description  + '</td>';
             htmlString+='<td> '+data[i].reimb_receipt  + '</td>';
             if(data[i].reimb_solver_name===null){
                htmlString+='<td> -</td>';
             }
             else{
                htmlString+='<td> '+data[i].reimb_solver_name  + '</td>';
             }
             htmlString+='<td> '+data[i].reimb_status  + '</td>';
             htmlString+='<td> '+data[i].reimb_type  + '</td>';
             table.insertAdjacentHTML ("beforeend",htmlString);
        }
    }
    if(j===0){
         document.getElementById("notshown2").style.display="block";
         document.getElementById("table").style.display="none";
         document.getElementById("Title").style.display="none";
    }

    response = await fetch(url+'getusername');
    if(response.status===200){
        let data= await response.json();
        var htmlString ='&#x1f464;'+data;
        userprofile.insertAdjacentHTML("beforeend",htmlString);
    }

}




let newBut = document.getElementById("new-button");
let backBut=  document.getElementById("back-button");

newBut.addEventListener("click",newButFunc);
backBut.addEventListener("click",newBackFunc);


function newButFunc(){
    location.href = "employee2.html";
}

function newBackFunc(){
    location.href = "employee.html";
}






