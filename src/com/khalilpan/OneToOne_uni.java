package com.khalilpan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalilpan.entity.User;
import com.khalilpan.entity.UserLog;
import com.khalilpan.entity.student;

public class OneToOne_uni {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(UserLog.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// =========================create and save===============================
			// try to create and save an object (one to one) into database

			// create objects
//					User tempUser=new User("kahlil","email");
//					UserLog tempUserLog=new UserLog("Recife","Brasil");

			// associate the objects
//					tempUser.setUserLog_id(tempUserLog);

			// start transaction
//					session.beginTransaction();

			// save the objests to database
//					session.save(tempUser);

			// commit transaction
//					session.getTransaction().commit();

//					System.out.println("User saved : "+ tempUser);

			// ============================delete============================================
			// try to delete one object from database (one to one)

			// start the transaction
//					session.beginTransaction();

//					int tempUserId=2;

			// retrieve user fromdatabase
//					User tempUser=session.get(User.class, tempUserId); //will return null if couldn't find the user

			// delete the user
//					if (tempUser!=null) {
//						session.delete(tempUser);
//						System.out.println("user deleted : "+tempUser);
//					}else {
//						System.out.println("user not found.");
//					}

			// commit transaction
//					session.getTransaction().commit();

			// =======================================checking bi directional
			// capabilities========
			// try to access one user by logs information (Bi directional)

//			int tempId = 455;

			// start the transaction
//			session.beginTransaction();

			// get the log of one id
//			UserLog tempUserLog = session.get(UserLog.class, tempId);

			// print the all information (user and userlog)
//			System.out.println("retreived user is : " + tempUserLog.getUser());

			// commit transaction
//			session.getTransaction().commit();

			
			//================================delete bi directional=================
			//to delete a user by using log 
			
			
			int tempUserLogId = 5;
			
			// start the transaction
			session.beginTransaction();
			
			//retreive the uler log from table
			UserLog temUserLog=session.get(UserLog.class, tempUserLogId);
			
			//delete the user and log by log number
			session.delete(temUserLog);
			
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
