package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="7352026597yk";
		try {
			System.out.println("Connection to database: "+jdbcUrl);
			Connection myconn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful");
		}
		
		catch(Exception exec) {
			exec.printStackTrace();
		}

	}

}
