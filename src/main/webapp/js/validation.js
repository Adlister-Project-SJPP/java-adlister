
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
    }if(e == ""){
        alert("Please enter your email address")
        return false;
    }if(p == ""){
        alert("You must enter a password")
        return false;
    }if(c != p){
        alert("Please reenter your password correctly!")
        return false;
    }
}
function validateCreate() {
    let t = document.forms["create"]["title"].value;
    let d = document.forms["create"]["description"].value;
    if (t == "") {
        alert("Please fill out your title")
        return false;
    }
    if (d == "") {
        alert("Please describe your ad")
        return false;
    }
}

//
// WAS HAVING ISSUES SO CREATED A SECOND VALIDATION FILE
//
// function validateLogin() {
//     let x = document.forms["login"]["username"].value;
//     let y = document.forms["login"]["password"].value;
//     if (x == "") {
//         alert("Username must be filled out");
//         removePassword(true, false);
//         return false;
//     }if(y ==""){
//         alert("Please do not forget to enter your password!");
//         removePassword(true, false);
//         return false;
//     }
// }
//
// function validateRegister(){
//     let u = document.forms["register"]["username"].value;
//     let p = document.forms["register"]["password"].value;
//     let e = document.forms["register"]["email"].value;
//     let c = document.forms["register"]["confirm_password"].value;
//     console.log("second")
//     if(u == ""){
//         alert("You must enter a username");
//         removePassword(true, true);
//         return true;
//     }if(e == ""){
//         alert("Please enter your email address");
//         removePassword(true, true);
//         return false;
//     }if(p == ""){
//         alert("You must enter a password");
//         removePassword(true, true);
//         return true;
//     }if(c != p){
//         alert("Please reenter your password correctly!");
//         removePassword(true, true);
//         return true;
//     }
// }
//
// //function to check for password or confirm_password in the form.
// function removePassword(hasPassword, hasConfirmPassword) {
//     window.addEventListener("submit", (event) => {
//         event.preventDefault();
//         if (hasPassword = true) {
//             let s = document.getElementById("password");
//             s.value = "";
//         }else if (hasConfirmPassword = true) {
//             let c = document.getElementById("confirm_password");
//             c.value = "";
//         }
//     });
// }
//
// function validateCreate(){
//     let t = document.forms["create"]["title"].value;
//     let d = document.forms["create"]["description"].value;
//     if(t == ""){
//         alert("Please fill out your title");
//         removePassword(false, false);
//         return false;
//     }if(d == ""){
//         alert("Please describe your ad");
//         removePassword(false, false);
//         return false;
//     }
// }
//

