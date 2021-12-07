

package ua.goit.servlets.listners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ua.goit.config.DbMigration;
import ua.goit.dao.DevelopersDao;
import ua.goit.http.server.service.DevelopersService;

@WebListener
public class LoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        DbMigration.migrate();
//        ServletContext servletContext = sce.getServletContext();
//        servletContext.setAttribute("developersDao", DevelopersDao.getInstance());
//        servletContext.setAttribute("developersService", DevelopersService.getInstance());
    }
}
