console.log("hello");

//targets the body of the html
const body = $('body');

body.on("click", "#edit", function (){
    console.log("click works")
    $(`#editForm`).toggleClass("hidden")
});


body.on("click", ".adEdit", function (){
    let id = $(this).attr("data-id")
    console.log(id)
    $(`#form${id}`).toggleClass("hidden")
});
//Validation to prevent editing out their username and password
function validateEdit(){
    let t = document.forms["edit"]["username"].value;
    let d = document.forms["edit"]["email"].value;
    if(t == ""){
        alert("Your username cannot be blank")
        return false;
    }if(d == ""){
        alert("Please enter a valid email address")
        return false;
    }
    //validation for validating the ad edit forms.
    function validateAdEdit(){
        let t = document.forms["editad"]["title"].value;
        let d = document.forms["editad"]["description"].value;
        if(t == ""){
            alert("Please give your animals name")
            return false;
        }if(d == ""){
            alert("Please describe the animal in detail")
            return false;
        }
    }
}