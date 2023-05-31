/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function validarCantidad(event) {
    var input = event.target;
    var cantidad = input.value;

    if (cantidad <= 0 || isNaN(cantidad)) {
        input.setCustomValidity('Introduce una cantidad válida.');
    } else {
        input.setCustomValidity('');
    }
}