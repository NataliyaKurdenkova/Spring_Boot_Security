package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements EntityService<Role> {


    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    public void delete(long id) {
        Optional<Role> role = roleDAO.findById(id);
        if (role.isPresent()) {
            roleDAO.delete(role.get());
        }
    }

    @Override
    public void update(Role role) {
        roleDAO.save(role);
    }

    @Override
    public List<Role> findAll() {
        Iterable<Role> roles = roleDAO.findAll();
        List<Role> roleList = new ArrayList<>();
        for (Role role : roles) {
            roleList.add(role);
        }
        return roleList;
    }

    @Override
    public Optional<Role> findById(long id) {
        return roleDAO.findById(id);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleDAO.findRoleByNameRole(name);
    }
}
