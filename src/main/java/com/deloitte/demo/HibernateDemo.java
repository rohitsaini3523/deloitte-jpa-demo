package com.deloitte.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// HQL - Hibernate query language - JPQL : Java/Jakarta Persistance
			List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

			// createNativeQuery - SQL query

			// methods for Crud Operations
//			session.find(null, employees); // returns 1 employee
//			session.update(emp);
//			session.remove(emp);
			System.out.println("Employee Details: ");
			for (Employee emp : employees) {
				System.out.println(emp);
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
	}
}