package com.hibernate.entity.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
				SessionFactory factory = new Configuration()
						                 .configure()
						                 .addAnnotatedClass(Student.class)
						                 .buildSessionFactory();
				
				Session session=factory.getCurrentSession();
				
				try {
					session.beginTransaction();
					//query all students from the table
					System.out.println("All students from the table:");
					List<Student> theStudents = session.createQuery("from Student").getResultList(); 
		            displayStudents(theStudents);
		            
		            System.out.println("All students from the table whose last Name is 'Narayan' : ");
		            //query those students whose lastname is 'Narayan'
		           theStudents= session.createQuery(" from Student s where s.lastName= 'Narayan' ").getResultList();
		           displayStudents(theStudents);
		           
		           
		           System.out.println("All students from the table whose last Name is 'Narayan' or first name is ''yatharth ");
		           //query those students whose lastNmae is 'Narayan ' or firstName is 'Yatharth'
		           theStudents= session.createQuery(" from Student s where s.lastName= 'Narayan' or s.firstName='Yatharth' ").getResultList();
		           displayStudents(theStudents);
		           
		           
		           System.out.println("All students from the table whose email ends with @gmail.com");
		           theStudents= session.createQuery(" from Student s where s.email LIKE '%@gmail.com'").getResultList();
		           displayStudents(theStudents);
		      
		            session.getTransaction().commit();
				} 
				
				finally {
					session.close();
				}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent:theStudents)
		{
			System.out.println(tempStudent.firstName + " " + tempStudent.lastName +" " + tempStudent.email);
		}
	}

}
