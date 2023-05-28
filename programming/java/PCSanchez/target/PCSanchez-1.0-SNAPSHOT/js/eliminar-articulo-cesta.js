/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function eliminarProducto(lineaId, codigoArticulo) {
    if (confirm("¿Estás seguro de que deseas eliminar este artículo?")) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    window.location.reload(); // Actualiza la página después de la eliminación
                } else {
                    alert("Error al eliminar el producto");
                }
            }
        };
        xhr.open("GET", "EliminarProductoServlet?lineaId=" + encodeURIComponent(lineaId) + "&codigoArticulo=" + encodeURIComponent(codigoArticulo), true);
        xhr.send();
    }
}
