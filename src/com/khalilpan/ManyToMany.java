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

//import jdk.internal.jline.internal.TestAccessible;

public class ManyToMany {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(UserLog.class).addAnnotatedClass(course.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// ================================adding item to table=================

			// start the transaction
//			session.beginTransaction();

			// retrieve course from table
//			course tempCourse = session.get(course.class, 1);
//			System.out.println("course retrieved");

			// creating new student
//			student tempStudent=new student("isabella","test","isabella@gmail.com");

			// adding course to student
//			tempStudent.addCourse(tempCourse);
//			System.out.println("student added");

			// saving student to table
//			session.save(tempStudent);
//			System.out.println("student added to table.");

			// commit transaction
//			session.getTransaction().commit();
			// ================================adding new review=================

			// start the transaction
//			session.beginTransaction();
			
			// retrieve course from table
//			course tempCourse = session.get(course.class, 1);
//			System.out.println("course retrieved");
			
			//crete new review
//			Review tempReview = new Review("Test review");
			
			//adding revirew to course
//			tempCourse.addReview(tempReview);
			
			//updating course/review in table
//			session.save(tempReview);
			
			// commit transaction
//			session.getTransaction().commit();
			
			System.out.println("done.");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();

			sessionFactory.close();
		}

	}

}
