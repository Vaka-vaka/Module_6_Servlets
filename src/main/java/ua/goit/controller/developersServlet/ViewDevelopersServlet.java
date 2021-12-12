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

    public static final Logger LOGGER = LogManager.getLogger(ViewDevelopersServlet.class);
    protected Gson jsonParser = new Gson();

    @Override
    public void init() throws ServletException {
        this.service = (DevelopersService) getServletContext().getAttribute("developersService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(15);
        if ("new".equalsIgnoreCase(id)) {
            req.setAttribute("developers", new Developers());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/view/jsp/viewDevelopersJSP.jsp").forward(req, resp);
        }
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
                      .ifPresent(developers -> {
                          service.update(developers);
                      });
//            Developers developers = null;
//        try (InputStream inputStream = req.getInputStream();
//             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
//            String jsonStr = scanner.next();
//            developers = jsonParser.fromJson(jsonStr, Developers.class);
//        } catch (IOException e) {
//            LOGGER.error("Request body getting error", e);
//        }
//        if(developers != null) {
//            service.update(developers);
//        }
        resp.sendRedirect("/developersJSP");
    }
}
