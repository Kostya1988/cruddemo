package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {


    private EntityManager entityManager;


    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override

    public List<Employee> findAll() {


        Session currentSession = entityManager.unwrap(Session.class);


        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);


        List<Employee> employees = theQuery.getResultList();


        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session curentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = curentSession.get(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session curentSession = entityManager.unwrap(Session.class);
        curentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Session curentSession = entityManager.unwrap(Session.class);
        Query theQuery = curentSession.createQuery("delete  from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();

    }

}







