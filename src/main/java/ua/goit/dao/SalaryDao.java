/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 21.12.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.config.DataSourceHolder;
import ua.goit.model.Salary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SalaryDao extends AbstractDao<Salary> {

    private static final Logger LOGGER = LogManager.getLogger(SalaryDao.class);
    private static SalaryDao instance;

    private SalaryDao() {
    }

    public static SalaryDao getInstance() {
        if (instance == null) {
            instance = new SalaryDao();
        }
        return instance;
    }

    @Override
    String getTableName() {
        return "sum_salary_developers_project";
    }

    @Override
    Salary mapToEntity(ResultSet rs) throws SQLException {
        Salary salary = new Salary();
        salary.setName_(rs.getString("name_"));
        salary.setSumSalary(rs.getDouble("sum_salary"));
        return salary;
    }

    public List<Salary> getSumProjectSalary(String projectName) {
        String query = "select * from sum_salary_developers_project where project_name = ?";
        List<Salary> resultList = new ArrayList<>();
        try {
            ResultSet resultSet = DbHelper.getWithPreparedStatement(
                    query, ps -> {
                        ps.setString(1, projectName);
                    });
            while (resultSet.next()) {
                LOGGER.debug("Record was selected");
                resultList.add(mapToEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return resultList;
    }

    @Override
    public Optional<Salary> create(Salary entity) {
        return Optional.empty();
    }

    @Override
    public void update(Salary entity) {
    }


}
