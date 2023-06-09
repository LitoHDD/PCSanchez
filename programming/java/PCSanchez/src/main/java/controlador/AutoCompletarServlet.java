package controlador;

import dao.ArticuloDAO;
import dao.CategoriaDAO;
import dto.Articulo;
import dto.Categoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

public class AutoCompletarServlet extends HttpServlet {

    private ArticuloDAO articuloDAO;
    private CategoriaDAO categoriaDAO;

    @Override
    public void init() {
        this.articuloDAO = new ArticuloDAO();
        this.categoriaDAO = new CategoriaDAO();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        List<Articulo> articuloMatches;
        List<Categoria> categoriaMatches;

        try {
            articuloMatches = articuloDAO.getByNombreParcial(query);
            categoriaMatches = categoriaDAO.getAll().stream()
                    .filter(categoria -> categoria.getNombre().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        List<JSONObject> jsonList = new ArrayList<>();
        for (Articulo articulo : articuloMatches) {
            JSONObject json = new JSONObject();
            json.put("nombre", articulo.getNombre());
            json.put("tipo", "articulo");
            jsonList.add(json);
        }
        for (Categoria categoria : categoriaMatches) {
            JSONObject json = new JSONObject();
            json.put("nombre", categoria.getNombre());
            json.put("tipo", "categoria");
            jsonList.add(json);
        }

        String json = jsonList.toString();
        System.out.println(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
