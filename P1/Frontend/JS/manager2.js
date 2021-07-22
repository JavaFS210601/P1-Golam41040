const url ='http://localhost:8080/P1/'

let userprofile = document.getElementById("userprofile");



document.addEventListener('DOMContentLoaded',assembleFunc);


async function assembleFunc(){

    response = await fetch(url+'getusername');
    if(response.status===200){
        let data= await response.json();
        var htmlString ='&#x1f464;'+data;
        console.log(data);
        userprofile.insertAdjacentHTML("beforeend",htmlString);
    }

}


let subBut=  document.getElementById("sub-button");


subBut.addEventListener("click",subButtonFunc);


async function subButtonFunc(){
    var id= document.getElementById('reimb_id').value;
    var response = await fetch(url+'allreimburstments');
    if(response.status===200){

        let data= await response.json();
        let table = document.getElementById("reimbody");
        table.innerHTML ="";

        var htmlString ="";
        var j=0;
         for(i=0;i<data.length;i++){
            if(data[i].reimb_id==id && data[i].reimb_status=="Submitted"){
                j++;
                htmlString+= '<th scope="row"> '+data[i].reimb_id   + '</th>';
                htmlString+='<td> '+data[i].reimb_amount + '</td>';
                    htmlString+='<td> '+data[i].reimb_submitted  + '</td>';
                    
                    htmlString+='<td> '+data[i].reimb_description  + '</td>';
                    htmlString+='<td> '+data[i].reimb_receipt  + '</td>';
                    htmlString+='<td> '+data[i].reimb_author_name  + '</td>';
                    
                    htmlString+='<td> '+data[i].reimb_status  + '</td>';
                    htmlString+='<td> '+data[i].reimb_type  + '</td>';
                    table.insertAdjacentHTML ("beforeend",htmlString);
                }
         } 
         if(j!=0){
             document.getElementById("notshown").style.display="block"; 
             document.getElementById("notshown2").style.display="none"; 
         } 
         else if(j==0){
             document.getElementById("notshown2").style.display="block"; 
             document.getElementById("notshown").style.display="none"; 
         }
    }
    
}


let upBut=  document.getElementById("update-button");


upBut.addEventListener("click",updateButtonFunc);


async function  updateButtonFunc(){

    var id= document.getElementById('reimb_id').value;
    var status =0;
    var radio = document.getElementsByName('status');
    for( var i=0 ; i < radio.length ; i++){
        if(radio[i].checked){
            
            status= radio[i].value;
            
            break;
        }
    }
    if(status===0){
        alert("Please select an option!!");
        location.href= "manager2.html";
    }
    else {
            let reimbursment={
                reimb_id: id,
                reimb_status: status
            }
            let response = await fetch(url+ "updatereimburstment",{
                method: "POST",
                body: JSON.stringify(reimbursment),
                credentials: 'include'
            })
            if(response.status===200){
                console.log("Success!!");
                alert("Update Successful!!");
                location.href = "manager1.html";
            }
            else{
                console.log("Failed!!")
                alert("Failed to Update")
                
            }
    }


}


let backBut=  document.getElementById("back-button");

backBut.addEventListener("click",newBackFunc);

function newBackFunc(){
    location.href = "manager.html";
}