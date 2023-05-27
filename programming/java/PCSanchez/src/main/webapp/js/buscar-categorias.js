/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function onSubmitForm() {
    var input = document.getElementById("search-bar").value;
    var categoria = "";

    // Lista de categorías predefinidas
    var categorias = ["Refrigeracion", "Caja", "Fuente de Alimentacion", "Placa Base", "Memoria Ram", "Almacenamiento", "Tarjeta Grafica", "Procesador"];

    // Verificar si el valor ingresado coincide con alguna categoría (incluso parcialmente)
    for (var i = 0; i < categorias.length; i++) {
        if (categorias[i].toLowerCase().includes(input.toLowerCase())) {
            categoria = categorias[i];
            break;
        }
    }

    document.getElementById("categoria-input").value = categoria;
    document.getElementById("query-input").value = input;
}