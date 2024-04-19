package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import entity.Student;

public class Client {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        try(Socket socket = new Socket("IAMHOANGKHANG", 2003);
                Scanner sc = new Scanner(System.in);
                ){
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            int choice = 0;
            
            
            while(true) {
                System.out.println("Enter your choice: \n"
                        + "1. Find students by enrollment year\n"
                        + "2. Find students by enrollment in course\n"
                        + "3. Get all students\n"
                        + "4. Delete student by id\n"
                        + "5. Add Student\n"
                        + "6. Update Student by id\n");
                
                choice = sc.nextInt();
                out.writeInt(choice);
                switch (choice) {
                case 1:
                    System.out.println("Enter the enrollment year: ");
                    int year = sc.nextInt();
                    out.writeInt(year);
                    out.flush();
                    
                    List<Student> studentsByYear = (List<Student>) in.readObject();
                    studentsByYear.forEach(System.out::println);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Enter the course title to search: ");
                    String title = sc.nextLine();
                    out.writeUTF(title);
                    out.flush();
                    
                    List<Student> studentsByCourse = (List<Student>) in.readObject();
                    studentsByCourse.forEach(System.out::println);
                    break;

                case 3:
                    List<Student> students = (List<Student>) in.readObject();
                    students.forEach(System.out::println);
                    break;
				case 4:
					sc.nextLine();
					System.out.println("Enter the ID to delete: ");
					String id = sc.nextLine();
					out.writeUTF(id);
					out.flush();
					break;
					
				case 5:
					  sc.nextLine();
					    System.out.println("Enter the first name: ");
					    String firstName = sc.nextLine();
					    out.writeUTF(firstName);

					    System.out.println("Enter the last name: ");
					    String lastName = sc.nextLine();
					    out.writeUTF(lastName);

					    System.out.println("Enter the enrollment date (yyyy-mm-dd): ");
					    String enrollmentDate = sc.nextLine();
					    out.writeUTF(enrollmentDate);					   
					    out.flush();
					    break;
				case 6: 
					sc.nextLine();
					System.out.println("Enter the ID to update: ");
					String id1 = sc.nextLine();
					out.writeUTF(id1);
					
					System.out.println("Enter the new first name: ");
					String name = sc.nextLine();
					out.writeUTF(name);
					
					System.out.println("Enter the new last name: ");
					String name2 = sc.nextLine();
					out.writeUTF(name2);
					
					out.flush();
					 System.out.println("Update Thành Công ID");
					 break;
					
                }
            }
            
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}