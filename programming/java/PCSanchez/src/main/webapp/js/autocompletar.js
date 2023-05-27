/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function () {
    $('#search-bar').on('input', function () {
        var query = $(this).val();
        if (query.length > 0) {
            $.get('AutoCompletarServlet', {query: query}, function (data) {
                // Borra la lista desplegable actual
                $('#suggestions').empty();

                // Agrega las nuevas coincidencias a la lista desplegable
                data.forEach(function (item) {
                    var nombre = item.nombre; // Obtener el nombre del elemento
                    var tipo = item.tipo; // Obtener el tipo del elemento

                    var listItem = $('<li></li>').attr('data-nombre', nombre).attr('data-tipo', tipo).text(nombre);
                    $('#suggestions').append(listItem);
                });

                // Muestra la caja de sugerencias
                $('#suggestion-box').show();
            });
        } else {
            // Si la barra de búsqueda está vacía, borra la lista desplegable
            $('#suggestions').empty();
            $('#suggestion-box').hide();
        }
    });

    // Agregar evento de clic a los elementos de la lista de sugerencias
    $('#suggestions').on('click', 'li', function () {
        var nombre = $(this).data('nombre');
        var tipo = $(this).data('tipo');

        if (tipo === 'articulo') {
            var url = './search?query=' + nombre;
            window.location.href = url;
        } else if (tipo === 'categoria') {
            var url = './search?categoria=' + nombre;
            window.location.href = url;
        }
    });
});