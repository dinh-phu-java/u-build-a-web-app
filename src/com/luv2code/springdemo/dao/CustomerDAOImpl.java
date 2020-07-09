package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class CustomerDAOImpl implements ICustomerDAO{

//    @Autowired
//    private SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
//@Autowired
//private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        session.beginTransaction();

        Query<Customer> theQuery=session.createQuery("from Customer " +
                        "order by lastName",
                Customer.class);

        List<Customer> customers=theQuery.getResultList();

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.save(customer);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    public static void main(String[] args) {
        CustomerDAOImpl customerDAO=new CustomerDAOImpl();
        customerDAO.getCustomers().forEach(k-> System.out.println(k));
    }
}
