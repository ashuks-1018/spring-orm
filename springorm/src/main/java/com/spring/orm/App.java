package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(234,"Tommy","France");
//        int r = studentDao.insert(student);
//        System.out.println("done" + r);
        
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go) {
        	System.out.println("Press 1 to add new student");
            System.out.println("Press 2 to display all students");
            System.out.println("Press 3 to get single student");
            System.out.println("Press 4 to delete student");
            System.out.println("Press 5 to update student");
            System.out.println("Press 6 for exit");
            
            try {
            	int input = Integer.parseInt(br.readLine());
            	
            	switch (input) {
				case 1:
					System.out.println("Enter user id : ");
					int uid = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name : ");
					String uName = br.readLine();
					
					System.out.println("Enter user city : ");
					String uCity = br.readLine();
					
					Student s = new Student();
					s.setStudentId(12);
					s.setStudentName("Finn");
					s.setStudentCity("London");
					
					int r = studentDao.insert(s);
					System.out.println(r + "Student added" );
					System.out.println("++++++++++++++++++++");
					System.out.println();
					
					break;
				case 2:
					
					System.out.println("+++++++++++++++++++");
					List<Student> allStudents = studentDao.getAllStudents();
					for(Student st : allStudents) {
						System.out.println("Id : " + st.getStudentId());
						System.out.println("Name : " + st.getStudentName());
						System.out.println("City : " + st.getStudentCity());
					}
					System.out.println("+++++++++++++++++++");
					break;
					
				case 3:
					
					System.out.println("Enter user id : ");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId); 
					
					System.out.println("Id : " + student.getStudentId());
					System.out.println("Name : " + student.getStudentName());
					System.out.println("City : " + student.getStudentCity());
					
					break;
				case 4:
					
					System.out.println("Enter user id : ");
					int userId1 = Integer.parseInt(br.readLine());
					studentDao.delete(userId1);
					System.out.println("Student deleted...");
					
					break;
				case 5:
					break;
				case 6:
					go = false;
					break;

				default:
					break;
				}
            } catch(Exception e) {
            	System.out.println("Invalid input: Try with another option");
            	System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank You for using our appplication. See you soon!");
    }
}
