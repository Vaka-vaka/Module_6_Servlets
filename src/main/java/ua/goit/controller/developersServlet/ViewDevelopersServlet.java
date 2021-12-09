package ua.goit.controller.developersServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.body.Developers;
import ua.goit.service.DevelopersService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/developersJSP/*")
public class ViewDevelopersServlet extends HttpServlet {

    private DevelopersService service;

    @Override
    public void init() throws ServletException {
        this.service = (DevelopersService) getServletContext().getAttribute("developersService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(15);
//        if ("new".equalsIgnoreCase(id)) {
//            req.setAttribute("user", new User());
//            req.setAttribute("isNew", true);
//            req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
//        }
        Optional<Developers> developersOptional = service.get(Long.parseLong(id));
        if (developersOptional.isPresent()) {
            Developers developers = developersOptional.get();
            req.setAttribute("viewDevelopersJSP", developers);
            req.getRequestDispatcher("/view/jsp/viewDevelopersJSP.jsp").forward(req, resp);
        }
//        resp.sendRedirect("/users");
       req.getRequestDispatcher("/view/jsp/developersJSP.jsp").forward(req, resp);
    }
}
