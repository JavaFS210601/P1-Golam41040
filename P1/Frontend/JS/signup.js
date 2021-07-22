const url = 'http://localhost:8080/P1/'
let button = document.getElementById("button");
button.addEventListener("click",uniqueConstr);



async  function uniqueConstr(){
    let userfn= document.getElementById("f_name").value;
    let userln = document.getElementById("l_name").value;

    let usern= document.getElementById("u_name").value;
    let userp = document.getElementById("password").value;
    let usere= document.getElementById("email").value;
    
    


    var userr =0;
    var radio = document.getElementsByName('role');
    for( var i=0 ; i < radio.length ; i++){
        if(radio[i].checked){
            
            userr= radio[i].value;
            
            break;
        }
    } 

    if(userfn== null||userln==null||usern==null|| userp ==null|| usere== null||
        userfn== ""||userln==""||usern==""|| userp ==""|| usere== ""||userr==0){
            alert("Can not leave a field Empty");
            location.href="signup.html";
        }
            let user ={
                user_first_name: userfn,
                user_last_name: userln,
                ers_username: usern,
                ers_password: userp,
                user_email: usere,
                role_id: userr
            }
            let response = await fetch(url+ "UsernameEmailConstraint",{
                method: "POST",
                body: JSON.stringify(user),
                credentials: 'include'
            })
            console.log(response);
            if(response.status===200){
                
                console.log("Success!!");
                signup(userfn,userln,usern,userp,usere,userr);
                
                
            }
            else{
                alert("Error: Username/Email already exists!!");
                location.href= "signup.html";
    }
   
    }





async function signup(userfn,userln,usern,userp,usere,userr){
    console.log("I am here null");
    let user ={
        user_first_name: userfn,
        user_last_name: userln,
        ers_username: usern,
        ers_password: userp,
        user_email: usere,
        role_id: userr
    }
    

    let response = await fetch(url+ "signup",{
                method: "POST",
                body: JSON.stringify(user),
                credentials: 'include'
            })
            if(response.status===200){
                console.log("Success!!");
                alert("Signup Successful!!");
                location.href = "login.html";
            }
            else{
                console.log("Failed!!")
                alert("Failed to signup")
                location.href = "Signup.html";
            }
}
