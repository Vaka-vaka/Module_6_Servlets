/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 21.12.2021
 */

package ua.goit.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.dao.SalaryDao;
import ua.goit.model.Salary;
import java.util.List;


public class SalaryService {

    private static SalaryService instance;
    private static final Logger LOGGER = LogManager.getLogger(SalaryService.class);
    private static final SalaryDao salaryDao = SalaryDao.getInstance();

    private SalaryService() {
    }

    public static SalaryService getInstance() {
        if (instance == null) {
            instance = new SalaryService();
        }
        return instance;
    }

    public List<Salary> getAll() {
        return salaryDao.getAll();
    }

    public List<Salary> getSumProjectSalary(String projectName) {
        return salaryDao.getSumProjectSalary(projectName);
    }
}
