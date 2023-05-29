/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function vaciarCesta(id) {
    if (confirm("¿Estás seguro de que deseas vaciar la cesta?")) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    window.location.reload();
                } else {
                    alert("Error al eliminar al vaciar la cesta");
                }
            }
        };
        xhr.open("GET", "VaciarCestaServlet?id=" + encodeURIComponent(id), true);
        xhr.send();
    }
}