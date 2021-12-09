package ua.goit.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ua.goit.model.config.DbMigration;
import ua.goit.service.DevelopersService;

@WebListener
public class LoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DbMigration.migrate();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("developersService", DevelopersService.getInstance());
 //       servletContext.setAttribute("skillsService", SkillsDao.getInstance());
//        servletContext.setAttribute("developersService", DevelopersService.getInstance());
//        servletContext.setAttribute("developersService", DevelopersService.getInstance());
//        servletContext.setAttribute("developersService", DevelopersService.getInstance());

    }
}
