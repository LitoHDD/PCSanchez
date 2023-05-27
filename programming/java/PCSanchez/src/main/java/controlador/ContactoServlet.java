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

        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("email");
        String mensaje = request.getParameter("mensaje");

        // Configurar las propiedades de JavaMail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp-mail.outlook.com"); // Reemplaza con la dirección del servidor SMTP
        props.put("mail.smtp.port", "587"); // Reemplaza con el puerto del servidor SMTP
        props.put("mail.smtp.auth", "true"); // Habilitar autenticación
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Establecer protocolo TLS específico
        props.put("mail.smtp.ssl.ciphers", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"); // Establecer suites de cifrado específicas

        // Crear una sesión de JavaMail
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pcsanchez.incidents@hotmail.com", "PCSanchez2000");
            }
        });

        try {
            // Crear un objeto Message y configurarlo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pcsanchez.incidents@hotmail.com")); // Reemplaza con tu dirección de correo electrónico
            String destinatario = request.getParameter("email"); // Obtener el correo electrónico del destinatario del formulario
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            // Obtén la URL base del servidor (ajústala según corresponda)
            String logoUrl = "https://i.imgur.com/3G3Tx2L.png";

            // Asunto del mensaje
            String asunto = "Confirmación de recepción: Mensaje desde el formulario de contacto";

            // Crea el contenido HTML del mensaje con estilos CSS
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

            // Establece el contenido del mensaje como HTML
            message.setContent(mensajeHtml, "text/html; charset=UTF-8");
            message.setSubject(asunto);

            // Establecer la dirección de correo electrónico para la copia oculta (BCC)
            message.setRecipient(Message.RecipientType.BCC, new InternetAddress("pcsanchez.tickets@hotmail.com"));

            // Enviar el correo electrónico
            Transport.send(message);

            // Establecer el resultado de éxito en el atributo del request
            request.setAttribute("resultado", "Formulario enviado con éxito");
        } catch (MessagingException e) {
            // Manejar cualquier error durante el envío del correo electrónico
            e.printStackTrace();

            // Establecer el resultado de error en el atributo del request
            request.setAttribute("resultado", "Error al enviar el formulario");
        }

        // Redirigir de vuelta a la página contacto.jsp
        request.getRequestDispatcher("contacto.jsp").forward(request, response);
    }
}
