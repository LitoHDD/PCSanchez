/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function () {
    $('#search-bar').on('input', function () {
        var query = $(this).val();
        if (query.length > 0) {
            $.get('AutoCompletarServlet', {query: query}, function (data) {
                $('#suggestions').empty();
                data.forEach(function (item) {
                    var nombre = item.nombre;
                    var tipo = item.tipo;
                    var listItem = $('<li></li>').attr('data-nombre', nombre).attr('data-tipo', tipo).text(nombre);
                    $('#suggestions').append(listItem);
                });
                $('#suggestion-box').show();
            });
        } else {
            $('#suggestions').empty();
            $('#suggestion-box').hide();
        }
    });
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