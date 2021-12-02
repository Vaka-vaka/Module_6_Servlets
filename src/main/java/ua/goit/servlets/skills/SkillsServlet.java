/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 02.12.2021
 */

package ua.goit.servlets.skills;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/skills")
public class SkillsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req
            , HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
