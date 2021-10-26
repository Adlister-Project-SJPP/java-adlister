function validateLogin() {
    let x = document.forms["login"]["username"].value;
    let y = document.forms["login"]["password"].value;
    if (x == "") {
        alert("Username must be filled out");
        return false;
    }if(y ==""){
        alert("Please do not forget to enter your password!");
        return false;
    }
}
function validateRegister(){
    let u = document.forms["register"]["username"].value;
    let p = document.forms["register"]["password"].value;
    let e = document.forms["register"]["email"].value;
    let c = document.forms["register"]["confirm_password"].value;
    if(u == ""){
        alert("You must enter a username")
        return false;
    }if(p == ""){
        alert("You must enter a password")
        return false;
    }if(e == ""){
        alert("Please enter your email address")
        return false;
    }if(c != p){
        alert("Please reenter your password correctly!")
        return false;
    }
}