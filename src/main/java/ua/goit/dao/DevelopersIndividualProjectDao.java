/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.DevelopersIndividualProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DevelopersIndividualProjectDao extends AbstractDao<DevelopersIndividualProject> {

    private static final Logger LOGGER = LogManager.getLogger(DevelopersIndividualProjectDao.class);
    private static DevelopersIndividualProjectDao instance;

    private DevelopersIndividualProjectDao() {
    }

    public static DevelopersIndividualProjectDao getInstance() {
        if (instance == null) {
            instance = new DevelopersIndividualProjectDao();
        }
        return instance;
    }

    @Override
    String getTableName() {
        return "list_developers_project";
    }

    @Override
    DevelopersIndividualProject mapToEntity(ResultSet rs) throws SQLException {
        DevelopersIndividualProject developersIndividualProject = new DevelopersIndividualProject();
        developersIndividualProject.setName_(rs.getString("name_"));
        developersIndividualProject.setDevelopers(rs.getString("d_name_"));
        return developersIndividualProject;
    }

    public List<DevelopersIndividualProject> getListDevelopersProject(String projectName) {
        String query = "select * from sum_salary_developers_project where project_name = ?";
        List<DevelopersIndividualProject> resultList = new ArrayList<>();
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
    public Optional<DevelopersIndividualProject> create(DevelopersIndividualProject entity) {
        return Optional.empty();
    }

    @Override
    public void update(DevelopersIndividualProject entity) {
    }

}
