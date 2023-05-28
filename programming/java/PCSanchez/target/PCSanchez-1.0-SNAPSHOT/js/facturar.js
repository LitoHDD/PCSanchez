/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var xmlButtons = document.getElementsByClassName('xml-button');
for (var i = 0; i < xmlButtons.length; i++) {
    xmlButtons[i].addEventListener('click', function () {
        var numeroPedido = this.getAttribute('data-numero-pedido');
        window.open('FacturaXMLServlet?numeroPedido=' + numeroPedido, '_blank');
    });
}

var pdfButtons = document.getElementsByClassName('pdf-button');
for (var i = 0; i < pdfButtons.length; i++) {
    pdfButtons[i].addEventListener('click', function () {
        var numeroPedido = this.getAttribute('data-numero-pedido');
        window.open('FacturaPDFServlet?numeroPedido=' + numeroPedido, '_blank');
    });
}
