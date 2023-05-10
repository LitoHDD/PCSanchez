/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function calcularPrecioTotal() {
    var inputsCantidad = document.querySelectorAll('input[name="cantidad"]');
    var precios = document.querySelectorAll('.producto-info p');
    var precioTotal = 0;
    for (var i = 0; i < inputsCantidad.length; i++) {
        var cantidad = parseInt(inputsCantidad[i].value);
        var precio = parseFloat(precios[i].textContent.replace('Precio: ', '').replace('€', ''));
        precioTotal += cantidad * precio;
    }
    document.getElementById('precio-total').textContent = 'Total: ' + precioTotal.toFixed(2) + '€';
}
document.addEventListener('DOMContentLoaded', function () {
    calcularPrecioTotal();
});


