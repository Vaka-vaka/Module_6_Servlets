/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 23.11.2021
 */

package ua.goit.http.server.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.dao.DevelopersDao;
import ua.goit.model.Developers;

import java.util.List;
import java.util.Optional;

public class DevelopersService {

    private static DevelopersService instance;

    private static final Logger LOGGER = LogManager.getLogger(DevelopersService.class);

    private final DevelopersDao developersDao = DevelopersDao.getInstance();

    private DevelopersService() {
    }

    public static DevelopersService getInstance() {
        if (instance == null) {
            instance = new DevelopersService();
        }
        return instance;
    }


    public List<Developers> getAll() {
        return developersDao.getAll();
    }

    public Optional<Developers> get(long id) {
        return developersDao.get(id);
    }

    public void update(Developers developers) {
        developersDao.update(developers);
    }

    public void create(Developers developers) {
        developersDao.create(developers);
    }

    public void delete(Developers developers) {
        developersDao.delete(developers);
    }
}
