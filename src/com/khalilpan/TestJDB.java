package com.khalilpan;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJDB {

	public static void main(String[] args) {
		
		//testdb=Database name
		//?useSSL=false --> to get rid of SSL Exception
		String jdbcURL="jdbc:mysql://localhost:3306/testdb?useSSL=false";
		String userString="root";
		String password="1234";
		try {
			System.out.println("connecting to db ....");
			
			Connection connection=DriverManager.getConnection(jdbcURL,userString,password); 
			
			System.out.println("successfully connected.....");
			
			
		} catch (Exception e) {
			System.out.println("exception.....");
		}

	}

}
