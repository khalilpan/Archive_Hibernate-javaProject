package com.khalilpan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khalilpan.entity.student;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public class HibernateJavaProject {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		// ==============================save=============================================
		// trying to add new object to table
		try {

			// creating a temp object to save
//			student tempStudent=new student("khalil","pan","khalil.pan2@gmail.com");

			// start the transaction
//			session.beginTransaction();

			// save the object to table
//			session.save(tempStudent);
//			System.out.println("student added.");
//			System.out.println("the id of saved student is : "+tempStudent.getId());
			// commit the transaction
//			session.getTransaction().commit();

			// ==============================get=========================================
			// trying to get object from table

			// getting the current session
//			session=sessionFactory.getCurrentSession();

			// starting transaction
//			session.beginTransaction();

			// retrieving student from table by id
//			student retievedStudent = session.get(student.class, tempStudent.getId());

			// printing retrieved student
//			System.out.println("retrieved student is : "+retievedStudent);

			// committing the transaction
//			session.getTransaction().commit();

			// =================================Query====================================
			// trying to do a query from table by hibernate

			// getting the current session
			session = sessionFactory.getCurrentSession();

			// start transaction
			session.beginTransaction();

			// query from table //select * from student
			List<student> retrievedStudentsList = session.createQuery("FROM student").getResultList();
			// *"student" is the name of class in java ,not name of table in MySQL

			// query from table //select * from student where firstname='khalil'
//			List<student> retrievedStudentsList2 = session.createQuery("FROM student s WHERE s.firstName='khalil' AND s.id=3").getResultList();

			// *"s.firstName" is the field name in object in java ,not the name of column in
			// MySQL

			// query from table //select * from student where firstname='khalil' or id=5
//			List<student> retrievedStudentsList3 = session.createQuery("FROM student s WHERE s.firstName='khalil' OR s.id=5").getResultList();

			// *"s.firstName" is the field name in object in java ,not the name of column in
			// MySQL

			// query from table //select * from student where email contain 'lil'
//			List<student> retrievedStudentsList4 = session.createQuery("FROM student s WHERE s.email LIKE '%lil%'").getResultList();

			// *"s.firstName" is the field name in object in java ,not the name of column in
			// MySQL

			// printing the list
//			System.out.println("-----------------");
//			System.out.println("retrieved LIST4 is : " + retrievedStudentsList4);

			// printing the list
//			System.out.println("-----------------");
//			System.out.println("retrieved LIST3 is : " + retrievedStudentsList3);

			// printing the list
//			System.out.println("-----------------");
//			System.out.println("retrieved LIST2 is : " + retrievedStudentsList2);

			// printing the list
			System.out.println("-----------------");
			System.out.println("retrieved LIST is : " + retrievedStudentsList);

			// commit the transaction
			session.getTransaction().commit();

			// =====================================update===================================================

			// getting the current session
//			session = sessionFactory.getCurrentSession();

			// start transaction
//			session.beginTransaction();

//			int studentID = 5;

			// retrieveng specific student from table to update
//			student studentToUpdate = session.get(student.class, studentID);

			// update the student
//			studentToUpdate.setFirstName("marcia");
//			studentToUpdate.setEmail("marcia@hotmail.com");

			// another code just for updating all the rows //will update all the emails in
			// table
//			session.createQuery("Update student set email='khalil@UpdatedEmail.com'").executeUpdate();

			// query from table //select * from student
//			List<student> retrievedStudentsList6 = session.createQuery("FROM student").getResultList();

			// retrieve and printing the updated user
//			System.out.println("-----------------");
//			System.out.println("updated table is : " + retrievedStudentsList6);
			// query from table //select * from student where firstname='khalil' or id=5

//			List<student> studentUpdated = session.createQuery("FROM student s WHERE s.id=5").getResultList();

			// retrieve and printing the updated user
//			System.out.println("-----------------");
//			System.out.println("updated user is : " + studentUpdated);

			// commit the changes(transaction)
//			session.getTransaction().commit();

			// ==========================================delete========================================

			// getting the current session
//			session = sessionFactory.getCurrentSession();

			// start transaction
//			session.beginTransaction();

//			int studentID = 6;

			// retrieveng specific student from table to update to delete
//			student studentToDelete = session.get(student.class, studentID);

			// delete the student
//			session.delete(studentToDelete);

			// print the deleted student
//			System.out.println("Studen deleted : "+ studentToDelete);

			// another way for execute one delete query on table
//			session.createQuery("DELETE FROM student WHERE id=8").executeUpdate();
//			System.out.println("student deleted.");

			// commit the changes(transaction)
//			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();

			sessionFactory.close();
		}

	}

}
