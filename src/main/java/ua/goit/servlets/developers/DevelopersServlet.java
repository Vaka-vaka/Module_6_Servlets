/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 01.12.2021
 */

package ua.goit.servlets.developers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.http.server.service.DevelopersService;
import ua.goit.model.Developers;

import java.io.IOException;
import java.util.List;

@WebServlet("/developers")
public class DevelopersServlet extends HttpServlet {

    private DevelopersService service;

    @Override
    public void init() throws ServletException {
        this.service = (DevelopersService) getServletContext().getAttribute("developersService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Developers> all = service.getAll();
        req.setAttribute("developers", all);
        req.getRequestDispatcher("/jsp/developers.jsp").forward(req, resp);
    }
}
