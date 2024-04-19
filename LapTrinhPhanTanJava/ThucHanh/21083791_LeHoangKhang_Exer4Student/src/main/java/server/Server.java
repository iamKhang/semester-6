package server;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.List;

import dao.StudentDao;
import dao.impl.StudentImpl;
import entity.Course;
import entity.Student;

public class Server {
	public static void main(String[] args) {
		
		try(ServerSocket server = new ServerSocket(2003);
				){
			
			System.out.println("Server started on port 2003");
			
			while (true) {
				Socket client = server.accept();
				
				System.out.println("Client connected"	);
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client Port: " + client.getPort());
				
				Thread t = new Thread(new ClientHandler(client));
				t.start();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class ClientHandler implements Runnable{
	private Socket socket;
	private StudentDao studentDao;

	public ClientHandler(Socket client) {
		super();
		this.socket = client;
		this.studentDao = new StudentImpl();
	}

	@Override
	public void run() {
		
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			
			int choice = 0;
			
			while(true) {
				choice = in.readInt();
				switch(choice) {
				 case 1: // Find students by enrollment year
	                    int year = in.readInt();
	                    List<Student> studentsByYear = studentDao.findByEnrollmentInYear(year);
	                    out.writeObject(studentsByYear);
	                    break;
				case 2:
					String title = in.readUTF();
					System.out.println("Client requested to search for: " + title);
					List<Student> students = studentDao.findByEnrollmentInCourse(title);
					out.writeObject(students);
					
					break;
					
				case 3:
					List<Student> courses = studentDao.findAll();
					out.writeObject(courses);
					break;
				case 4:
                        String id = in.readUTF();
                        studentDao.deleteByID(id);
                       
                        break;
				case 5:
					 String firstName = in.readUTF();
					    String lastName = in.readUTF();
					    LocalDate enrollmentDate = LocalDate.parse(in.readUTF());

					    Student student = new Student(firstName, lastName, enrollmentDate);
					    studentDao.add(student);
					    break;
					 
				case 6:
					String name = in.readUTF();
					String name2 = in.readUTF();
					String id1 = in.readUTF();
					studentDao.updateInfo(name, name2, id1);
					break;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}