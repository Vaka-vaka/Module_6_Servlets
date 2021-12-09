

package ua.goit.controller.developersServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.body.Developers;
import ua.goit.service.DevelopersService;

import java.io.IOException;
import java.util.List;

@WebServlet("/developersJSP")
public class DevelopersServlet extends HttpServlet {

    private DevelopersService service;

    @Override
    public void init() throws ServletException {
        this.service = (DevelopersService) getServletContext().getAttribute("developersService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Developers> all = service.getAll();
        Object[] developersJSP = all.toArray();
        req.setAttribute("developersJSP", developersJSP);
        req.getRequestDispatcher("/view/jsp/developersJSP.jsp").forward(req, resp);
    }
}
