package controlador;

import dao.PedidoArticuloDAO;
import dao.TarjetaDAO;
import dto.PedidoArticulo;
import dto.Usuario;
import dto.Tarjeta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class FacturaXMLServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int numeroPedido = Integer.parseInt(request.getParameter("numeroPedido"));

            HttpSession session = request.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            PedidoArticuloDAO pedidoArticuloDAO = new PedidoArticuloDAO();
            ArrayList<PedidoArticulo> lineas = pedidoArticuloDAO.getLineas(numeroPedido);
            TarjetaDAO tarjetaDAO = new TarjetaDAO();
            Tarjeta tarjetaUsuario = tarjetaDAO.getByCodigoUsuario(usuario.getCodigo());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element facturaElement = document.createElement("factura");
            document.appendChild(facturaElement);

            document.setXmlVersion("1.0");

            createElementWithText(document, facturaElement, "numeroPedido", String.valueOf(numeroPedido));
            createElementWithText(document, facturaElement, "fechaPedido", pedidoArticuloDAO.getFechaPedido(numeroPedido).toString());
            createElementWithText(document, facturaElement, "nombreCompleto", usuario.getNombreCompleto());
            createElementWithText(document, facturaElement, "direccion", usuario.getDirecciones().toString().replace("[", "").replace("]", ""));
            createElementWithText(document, facturaElement, "tarjeta", tarjetaUsuario.getNumeroTarjeta() + " - Código de Pago: " + tarjetaUsuario.getCodPago());

            Element lineasElement = document.createElement("lineas");
            facturaElement.appendChild(lineasElement);

            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            double total = 0;

            for (PedidoArticulo linea : lineas) {
                Element lineaElement = document.createElement("linea");
                lineasElement.appendChild(lineaElement);
                createElementWithText(document, lineaElement, "articulo", linea.getArticulo().getNombre());
                createElementWithText(document, lineaElement, "cantidad", String.valueOf(linea.getCantidad()));
                createElementWithText(document, lineaElement, "precio", decimalFormat.format(linea.getArticulo().getPrecio()));
                double subtotal = linea.getCantidad() * linea.getArticulo().getPrecio();
                total += subtotal;
                createElementWithText(document, lineaElement, "subtotal", decimalFormat.format(subtotal));
            }

            Element totalElement = document.createElement("total");
            Text totalText = document.createTextNode(decimalFormat.format(total));
            totalElement.appendChild(totalText);
            facturaElement.appendChild(totalElement);

            response.setContentType("application/xml");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=factura_" + numeroPedido + ".xml");

            PrintWriter out = response.getWriter();
            transformXmlDocument(document, out);
            out.flush();
        } catch (SQLException | ParserConfigurationException e) {
            throw new ServletException(e);
        }
    }

    private void createElementWithText(Document document, Element parentElement, String name, String text) {
        Element element = document.createElement(name);
        Text textNode = document.createTextNode(text);
        element.appendChild(textNode);
        parentElement.appendChild(element);
    }

    private void transformXmlDocument(Document document, PrintWriter writer) {
        try {
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(writer));
        } catch (Exception e) {
            throw new RuntimeException("Error transforming XML document", e);
        }
    }
}
