package com.deloitte.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter employee details");
			System.out.print("\nName: ");
			String empName = sc.next();
			System.out.print("\nSalary: ");
			Double empSalary = sc.nextDouble();
			Employee emp = new Employee(empName, empSalary);

			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
			System.out.println("New Employee Added!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
			sc.close();
		}

	}

}
