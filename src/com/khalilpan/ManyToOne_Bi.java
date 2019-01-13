package com.khalilpan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.khalilpan.entity.Review;
import com.khalilpan.entity.User;
import com.khalilpan.entity.UserLog;
import com.khalilpan.entity.course;
import com.khalilpan.entity.student;
//import com.sun.org.apache.bcel.internal.generic.Select;

public class ManyToOne_Bi {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
															.configure("hibernate.cfg.xml")
															.addAnnotatedClass(User.class)
															.addAnnotatedClass(UserLog.class)
															.addAnnotatedClass(course.class)
															.addAnnotatedClass(Review.class)
															.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// ================================adding item to table=================
			// to delete a user by using log

			// create user
//			User tempUser = new User("marciaFer", "marcia@hotmail.com");
//			UserLog tempUserLog = new UserLog("Recife", "Brasssil");

			// associate uerlog to user
//			tempUser.setUserLog(tempUserLog);

			// start the transaction
//			session.beginTransaction();

			// save user
//			session.save(tempUser);

			// commit transaction
//			session.getTransaction().commit();

			// ================================adding course to table=================

			// start the transaction
//			session.beginTransaction();

//			System.out.println(user.getCoursesList());
			// get user from data base
//			int id = 6;
//			User tempUser= session.get(User.class, id);

			// create course
//			course course1=new course("java Course");
//			course course2=new course("MySQL");

			// addcourse to user
//			tempUser.addCourse(course1);
//			tempUser.addCourse(course2);

			// save courses to database
//			session.save(course1);
//			session.save(course2);

			// =========================query from table===================================

			// start the transaction
//			session.beginTransaction();
			
			//CReate a query with HQL statement //"i" is an alias that we can use it later in query
//			Query<User> query=session.createQuery("SELECT i FROM User i "+
//													"JOIN FETCH i.coursesList "+
//													"WHERE i.id=:tempUserID",User.class);
			
//			int userID=6;
			
			//set parameter on query
//			query.setParameter("tempUserID", userID);
			
			//execute the query
//			User fetchedUser=query.getSingleResult();
			
			//print out fetched user bu query
//			System.out.println("fetched uder is =========> "+fetchedUser);
//			System.out.println("fetched uder is =========> "+fetchedUser.getCoursesList());
			
			//=======================testing review class===========================================
			
			// start the transaction
			session.beginTransaction();
			
			//course name		
			String tempCourseName="Hibernate Course";
					
			//create query //test by query
			Query<course> query=session.createQuery("FROM course c WHERE c.title='"+tempCourseName+"'");
			
			//execute query
			course tempCourse=query.getSingleResult();
			
			System.out.println(tempCourse.getReviews());
			
			//creating som reviews for course
//			tempCourse.addReview(new Review("is amazing course"));
//			tempCourse.addReview(new Review("is fantastico"));
//			tempCourse.addReview(new Review("full course,fulloption"));
			
			//add course to the list
//			session.save(tempCourse);
			
//			System.out.println("reviews for '"+tempCourse.getTitle()+ "'course :"+ tempCourse.getReviews() );

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
