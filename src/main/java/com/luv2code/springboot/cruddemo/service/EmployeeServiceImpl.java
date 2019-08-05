package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAOHibernateImpl;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAOHibernateImpl employeeDAOHibernateImpl;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOHibernateImpl theEmployeeDAOHibernateImpl) {
        employeeDAOHibernateImpl = theEmployeeDAOHibernateImpl;
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAOHibernateImpl.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAOHibernateImpl.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDAOHibernateImpl.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAOHibernateImpl.deleteById(theId);
    }
}
