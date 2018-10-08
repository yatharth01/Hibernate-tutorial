package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				                .configure()
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
				                
		Session session= factory.getCurrentSession();
		
		try {
			System.out.println("Creating Student objects::----");
			Student student1 = new Student("Yatharth","Mishra","yatharthmishra01@gmail.com");
			Student student2 = new Student("Shiv","Narayan","shiva911@gmail.com");
			Student student3 = new Student("Rohit","Nand","Rnand01@gmail.com");
			session.beginTransaction();
			
			System.out.println("Saving Students into database::--");
			
			session.save(student1);
			session.save(student2);
			session.save(student3);

			session.getTransaction().commit();
			System.out.println("done--!");
		}
		
		finally {
			session.close();
		}
		
	}

}
