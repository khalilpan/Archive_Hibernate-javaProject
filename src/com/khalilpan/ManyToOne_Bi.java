package com.khalilpan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalilpan.entity.User;
import com.khalilpan.entity.UserLog;
import com.khalilpan.entity.course;
import com.khalilpan.entity.student;

public class ManyToOne_Bi {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(User.class)
													.addAnnotatedClass(UserLog.class)
													.addAnnotatedClass(course.class)
													.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			
			//================================adding item to table=================
			//to delete a user by using log 
			
			//create user
			User tempUser=new User("marciaFer","marcia@hotmail.com");
			UserLog tempUserLog = new UserLog("Recife", "Brasssil");
			
			
			//associate uerlog to user
			tempUser.setUserLog(tempUserLog);
			
			// start the transaction
			session.beginTransaction();
			
			 //save user
			session.save(tempUser);
			
			// commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();

			sessionFactory.close();
		}

	}

}
