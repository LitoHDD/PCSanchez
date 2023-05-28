package controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import dao.PedidoArticuloDAO;
import dao.TarjetaDAO;
import dto.PedidoArticulo;
import dto.Usuario;
import dto.Tarjeta;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaPDFServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numeroPedido = Integer.parseInt(request.getParameter("numeroPedido"));

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // Añade el logo
            String logoPath = getServletContext().getRealPath("./images/index/logo.png");
            Image logo = Image.getInstance(logoPath);
            logo.scaleToFit(100, 50);
            logo.setAlignment(Element.ALIGN_RIGHT);
            document.add(logo);

            PedidoArticuloDAO pedidoArticuloDAO = new PedidoArticuloDAO();
            ArrayList<PedidoArticulo> lineas = pedidoArticuloDAO.getLineas(numeroPedido);
            TarjetaDAO tarjetaDAO = new TarjetaDAO();
            Tarjeta tarjetaUsuario = tarjetaDAO.getByCodigoUsuario(usuario.getCodigo());

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font tableBodyFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            document.add(new Paragraph("Factura del pedido: " + numeroPedido, titleFont));
            document.add(new Paragraph("Fecha del pedido: " + pedidoArticuloDAO.getFechaPedido(numeroPedido), subtitleFont));

            document.add(new Paragraph("Factura a nombre de: " + usuario.getNombreCompleto(), titleFont));
            document.add(new Paragraph("Dirección: " + usuario.getDirecciones().toString().replace("[", "").replace("]", ""), subtitleFont));
            document.add(new Paragraph("Tarjeta: " + tarjetaUsuario.getNumeroTarjeta() + " - Código de Pago: " + tarjetaUsuario.getCodPago(), subtitleFont));

            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(new float[] { 2, 1, 1 });
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Phrase("Artículo", tableHeaderFont));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Cantidad", tableHeaderFont));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Precio €", tableHeaderFont));
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            double total = 0;

            for (PedidoArticulo linea : lineas) {
                table.addCell(new Phrase(linea.getArticulo().getNombre(), tableBodyFont));
                table.addCell(new Phrase(String.valueOf(linea.getCantidad()), tableBodyFont));
                table.addCell(new Phrase(String.valueOf(linea.getArticulo().getPrecio() + " €"), tableBodyFont));

                double subtotal = linea.getCantidad() * linea.getArticulo().getPrecio();
                total += subtotal;
            }

            document.add(table);

            document.add(new Paragraph("Total: " + total + " €", titleFont));

            document.close();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=factura_" + numeroPedido + ".pdf");

        } catch (DocumentException | SQLException e) {
            throw new ServletException(e);
        }
    }
}