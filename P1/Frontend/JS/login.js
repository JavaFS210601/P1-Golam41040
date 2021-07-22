const url = 'http://localhost:8080/P1/'
let button = document.getElementById("button");

button.addEventListener("click",passwordCheck);

 async function passwordCheck(){

    let usern= document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username: usern,
        password: userp
    }

    let response = await fetch (url + "login",{

        method: "POST",

        body: JSON.stringify(user),
        credentials: 'include'
    
    
    });
 if(response.status === 200)
    
     {
         console.log("I am here");
         getUsertype();
        
        
    } else {
       document.getElementById("try-again").style.display = "flex";
    }

}

async function getUsertype() {
    
    let response1 = await fetch(url+"getusertype");
    console.log(response1);
        if(response1.status===200){
            let data= await response1.json();
            
            if(data==='2'){
                location. href = "employee.html";
            }
            else if(data==='1'){
                location. href = "manager.html";
            }
        }
}