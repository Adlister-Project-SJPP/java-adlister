console.log("hello");

//targets the body of the html
const body = $('body');

body.on("click", "#edit", function (){
    $(`#editForm`).toggleClass("hidden")
});