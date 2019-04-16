package ru.javastudy.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javastudy.hibernate.dao.OrganizationDao;
import ru.javastudy.hibernate.dao.PersonDao;
import ru.javastudy.hibernate.models.Organization;

import java.util.List;

@Service
public class OrganizationSevice {

    public OrganizationSevice(){
    }

    @Autowired
    private OrganizationDao organizationDao = new OrganizationDao();

    @Transactional
    public void setOrganizationDao(PersonDao personDao){
        this.organizationDao = organizationDao;
    }

    @Transactional
    public Organization findOrganization(int id) {
        return this.organizationDao.findById(id);
    }

    @Transactional
    public void addOrganization(Organization organization) {
        this.organizationDao.add(organization);
    }

    @Transactional
    public void deleteOrganiztion(int id) {
        this.organizationDao.delete(id);
    }

    @Transactional
    public void updatePerson(Organization organizaion) {
        this.organizationDao.update(organizaion);
    }

    @Transactional
    public List<Organization> organizationList() {
        return this.organizationDao.organizationList();
    }
}
