package ua.goit.controller.developersServlet;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.body.Developers;
import ua.goit.service.DevelopersService;
import ua.goit.service.HandleBodyUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;

@WebServlet("/developersJSP/*")
public class ViewDevelopersServlet extends HttpServlet {

    private DevelopersService service;

    private static final Logger LOGGER = LogManager.getLogger(ViewDevelopersServlet.class);
    private static Gson jsonParser = new Gson();

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
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("/view/jsp/viewDevelopersJSP.jsp").forward(req, resp);
        }
        resp.sendRedirect("/developersJSP");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HandleBodyUtil.getModelFromStream(req.getInputStream(), Developers.class)
                      .ifPresent(user -> {
                          service.update(user);
                      });
        resp.sendRedirect("/developersJSP");
    }
}
