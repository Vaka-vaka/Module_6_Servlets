/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.12.2021
 */

package ua.goit.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.goit.dao.DevelopersDao;
import ua.goit.http.server.dto.LoginDto;
import ua.goit.model.Developers;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final DevelopersDao developersDao = DevelopersDao.getInstance();

//    @Override
//    public void init() throws ServletException {
//        this.developersDao = (DevelopersDao) getServletContext().getAttribute("developersDao");
//    }

    @Override
    protected void doPost(HttpServletRequest request
            , HttpServletResponse response) {
        String developersName = request.getParameter("developersName");
        String password = request.getParameter("password");

        LoginDto loginDto = new LoginDto();

        loginDto.setDevelopersName(developersName);
        loginDto.setPassword(password);

        try
        {
     //       Developers developers = developersDao.getByName(developersName);
            if ( developersDao.getByName(developersName) != null)
                  //  && developers.getPassword() != null)
                //    && developers.getPassword().equals(password))
            {
                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("developers", developersName); //setting session attribute
                session.setMaxInactiveInterval(10 * 60);
                request.setAttribute("developersName", developersName);
                response.sendRedirect("/jsp/main.jsp");
            } else {
                request.setAttribute("errMessage", "Developers with name " + developersName + " invalid");

                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
