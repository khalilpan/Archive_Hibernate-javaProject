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
		
		//==============================save=============================================
		//trying to add new object to table
		try {
			
			//creating a temp object to save
			student tempStudent=new student("khalil","pan","khalil.pan2@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the object to table
			session.save(tempStudent);
			System.out.println("student added.");
			System.out.println("the id of saved student is : "+tempStudent.getId());
			//commit the transaction
			session.getTransaction().commit();
		
			
			//==============================get=========================================
			//trying to get object from table
			
			//getting the current session
			session=sessionFactory.getCurrentSession();
			
			//starting transaction
			session.beginTransaction();
			
			//retrieving student from table by id
			student retievedStudent = session.get(student.class, tempStudent.getId());
			
			//printing retrieved student
			System.out.println("retrieved student is : "+retievedStudent);
			
			//committing the transaction
			session.getTransaction().commit();
			
			
		} finally {
			sessionFactory.close();
		}
		
		
		
		
		
		
	}

}
