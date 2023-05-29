package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("email");
        String mensaje = request.getParameter("mensaje");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp-mail.outlook.com"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); 
        props.put("mail.smtp.ssl.ciphers", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"); 

        // Crear una sesión de JavaMail
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pcsanchez.incidents@hotmail.com", "PCSanchez2000");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pcsanchez.incidents@hotmail.com")); 
            String destinatario = request.getParameter("email"); 
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            String logoUrl = "https://i.imgur.com/3G3Tx2L.png";

            String asunto = "Confirmación de recepción: Mensaje desde el formulario de contacto";

            String mensajeHtml = "<html><head>"
                    + "<style>"
                    + "body {"
                    + "    font-family: Arial, sans-serif;"
                    + "    margin: 0;"
                    + "    padding: 0;"
                    + "}"
                    + ".container {"
                    + "    max-width: 600px;"
                    + "    margin: 0 auto;"
                    + "    padding: 20px;"
                    + "    background-color: #f5f5f5;"
                    + "    border-radius: 5px;"
                    + "}"
                    + "h2 {"
                    + "    color: #333333;"
                    + "    font-size: 24px;"
                    + "    font-weight: bold;"
                    + "    margin-top: 20px;"
                    + "}"
                    + "p {"
                    + "    color: #333333;"
                    + "    font-size: 16px;"
                    + "    line-height: 1.5;"
                    + "    margin-bottom: 15px;"
                    + "}"
                    + "ul {"
                    + "    margin-top: 0;"
                    + "    padding-left: 20px;"
                    + "}"
                    + "li {"
                    + "    margin-bottom: 5px;"
                    + "}"
                    + "</style>"
                    + "</head><body>"
                    + "<div class=\"container\">"
                    + "<img src=\"" + logoUrl + "\" alt=\"Logo de la empresa\" style=\"display: block; margin: 0 auto; max-width: 200px;\">"
                    + "<h2>" + asunto + "</h2>"
                    + "<p>Estimado/a " + nombre + ",</p>"
                    + "<p>Gracias por ponerse en contacto con nosotros. Hemos recibido su mensaje y le aseguramos que será procesado de manera oportuna por nuestro equipo.</p>"
                    + "<p>Detalles del mensaje:</p>"
                    + "<ul>"
                    + "<li>Nombre: " + nombre + "</li>"
                    + "<li>Correo electrónico: " + correo + "</li>"
                    + "<li>Mensaje: " + mensaje + "</li>"
                    + "</ul>"
                    + "<p>Nos pondremos en contacto con usted lo antes posible para darle seguimiento a su consulta.</p>"
                    + "<p>Atentamente, PCSanchez</p>"
                    + "</div>"
                    + "</body></html>";

            message.setContent(mensajeHtml, "text/html; charset=UTF-8");
            message.setSubject(asunto);

            message.setRecipient(Message.RecipientType.BCC, new InternetAddress("pcsanchez.tickets@hotmail.com"));

            Transport.send(message);

            request.setAttribute("resultado", "Formulario enviado con éxito");
        } catch (MessagingException e) {
            e.printStackTrace();

            request.setAttribute("resultado", "Error al enviar el formulario");
        }

        request.getRequestDispatcher("contacto.jsp").forward(request, response);
    }
}
