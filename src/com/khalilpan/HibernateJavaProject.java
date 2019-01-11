package com.khalilpan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalilpan.entity.student;

public class HibernateJavaProject {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory=new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(student.class)
											.buildSessionFactory();
		
		
		//create session
		Session session=sessionFactory.getCurrentSession();
		
		
		try {
			
			//creating a temp object to save
			student tempStudent=new student("khalil","pan","khalil.pan2@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the object to table
			session.save(tempStudent);
			System.out.println("student added.");
			
			//commit the transaction
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
		
	}

}
