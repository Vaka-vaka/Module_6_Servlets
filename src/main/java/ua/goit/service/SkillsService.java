package ua.goit.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Skills;
import ua.goit.dao.SkillsDao;

import java.util.List;
import java.util.Optional;

public class SkillsService {

    private static SkillsService instance;

    private static final Logger LOGGER = LogManager.getLogger(SkillsService.class);

    private final SkillsDao skillsDao = SkillsDao.getInstance();

    private SkillsService() {
    }

    public static SkillsService getInstance() {
        if (instance == null) {
            instance = new SkillsService();
        }
        return instance;
    }

    public List<Skills> getAll() {
        return skillsDao.getAll();
    }

    public Optional<Skills> get(long id) {
        return skillsDao.get(id);
    }

    public void update(Skills skills) {
        skillsDao.update(skills);
    }

    public void create(Skills skills) {
        skillsDao.create(skills);
    }

    public void delete(Skills skills) {
        skillsDao.delete(skills);
    }
}
