/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var xmlButtons = document.getElementsByClassName('xml-button');
for (var i = 0; i < xmlButtons.length; i++) {
    xmlButtons[i].addEventListener('click', function () {
        var numeroPedido = this.getAttribute('data-numero-pedido');
        $.ajax({
            type: "POST",
            url: "GenerarFacturaServlet",
            data: { numeroPedido: numeroPedido },
            success: function(response){
                var link = 'FacturaXMLServlet?numeroPedido=' + numeroPedido;
                setTimeout(function(){
                    window.open(link, '_blank');
                }, 100);
            },
            error: function(jqXHR, textStatus, errorThrown){
                console.log("Error: " + textStatus + ": " + errorThrown);
            }
        });
    });
}

var pdfButtons = document.getElementsByClassName('pdf-button');
for (var i = 0; i < pdfButtons.length; i++) {
    pdfButtons[i].addEventListener('click', function () {
        var numeroPedido = this.getAttribute('data-numero-pedido');
        $.ajax({
            type: "POST",
            url: "GenerarFacturaServlet",
            data: { numeroPedido: numeroPedido },
            success: function(response){
                var link = 'FacturaPDFServlet?numeroPedido=' + numeroPedido;
                setTimeout(function(){
                    window.open(link, '_blank');
                }, 100);
            },
            error: function(jqXHR, textStatus, errorThrown){
                console.log("Error: " + textStatus + ": " + errorThrown);
            }
        });
    });
}
