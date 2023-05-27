/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function changeForm() {
    // Obtén el tipo de producto seleccionado
    var productType = document.getElementById("product-type-selector").value;

    // Oculta todos los campos del formulario
    var allFields = document.getElementsByClassName("product-fields");
    for (var i = 0; i < allFields.length; i++) {
        allFields[i].style.display = "none";
    }

    // Muestra los campos para el tipo de producto seleccionado
    var fieldsToShow = document.getElementById(productType + "-fields");
    if (fieldsToShow) {
        fieldsToShow.style.display = "block";
    }
}