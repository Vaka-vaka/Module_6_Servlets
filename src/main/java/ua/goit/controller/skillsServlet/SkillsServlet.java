package ua.goit.controller.skillsServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.Skills;
import ua.goit.service.HandleBodyUtil;
import ua.goit.service.SkillsService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/skillsJSP")
public class SkillsServlet extends HttpServlet{

    private SkillsService service;

    @Override
    public void init() throws ServletException {
        this.service = (SkillsService) getServletContext().getAttribute("skillsService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Skills skills = new Skills();
            skills.setId(Long.parseLong(deleteId));
            service.delete(skills);
            resp.sendRedirect("/skillsJSP");
        } else {
            List<Skills> all = service.getAll();
            Object[] skillsJSP = all.toArray();
            req.setAttribute("skillsJSP", skillsJSP);
            req.getRequestDispatcher("/view/jsp/skillsJSP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Skills> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Skills.class);
        modelFromStream.ifPresent(skills -> service.create(skills));
        resp.sendRedirect("/skillsJSP");
    }
}