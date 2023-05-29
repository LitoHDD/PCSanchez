package controlador;

import dao.LineaCestaDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VaciarCestaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);

        LineaCestaDAO lineaCestaDAO = new LineaCestaDAO();
        lineaCestaDAO.vaciarCesta(id);

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
