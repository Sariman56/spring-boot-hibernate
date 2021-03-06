package ru.innovat.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innovat.dao.utils.DevelopmentRolePersonDao;
import ru.innovat.models.utils.DevelopmentRolePerson;

import java.util.List;
@Service
public class DevelopmentRolePersonService {

    public DevelopmentRolePersonService(){

    }

    @Autowired
    private DevelopmentRolePersonDao developmentRolePersonDao = new DevelopmentRolePersonDao();

    @Transactional
    public void setDevelopmentRolePersonDao(DevelopmentRolePerson DevelopmentRolePerson){
        this.developmentRolePersonDao = developmentRolePersonDao;
    }

    @Transactional
    public DevelopmentRolePerson findDevelopmentRolePerson(int id) {
        return developmentRolePersonDao.findById(id);
    }

    @Transactional
    public void addDevelopmentRolePerson(DevelopmentRolePerson developmentRolePerson) {
        developmentRolePersonDao.add(developmentRolePerson);
    }

    @Transactional
    public void deleteDevelopmentRolePerson(int id) {
        developmentRolePersonDao.delete(id);
    }

    @Transactional
    public void updateDevelopmentRolePerson(DevelopmentRolePerson developmentRolePerson) {
        developmentRolePersonDao.update(developmentRolePerson);
    }

    @Transactional
    public List<DevelopmentRolePerson> developmentRolePersonList() {
        return developmentRolePersonDao.developmentRolePersonList();
    }
}
