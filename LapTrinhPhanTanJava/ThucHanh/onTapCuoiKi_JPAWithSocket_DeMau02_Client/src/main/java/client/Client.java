package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.Candidate;
import entity.Position;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (Socket socket = new Socket("IAMHOANGKHANG", 2003); Scanner sc = new Scanner(System.in);) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			int choice = 0;

			while (true) {
				System.out.println("1. Get list position by name and salary"
						+ "\n2. Get list candidate and number of companies they worked for"
						+ "\n3. Get list candidate and their working position with longest time"
						+ "\n4. Add new candidate" + "\n5. Get list candidate and their years of experience by position"
						+ "\n6. Exit");
                System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				out.writeInt(choice);
				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.print("Enter the position name: ");
					String name = sc.nextLine();
					out.writeUTF(name);

					System.out.print("Enter the salary from: ");
					double salaryFrom = sc.nextDouble();
					out.writeDouble(salaryFrom);

					System.out.print("Enter the salary to: ");
					double salaryTo = sc.nextDouble();
					out.writeDouble(salaryTo);
					out.flush();

					List<Position> positions = (List<Position>) in.readObject();
					positions.forEach(System.out::println);
					break;

				case 2:
					Map<Candidate, Long> map = (Map<Candidate, Long>) in.readObject();
					map.forEach((k, v) -> System.out.println(k + " - " + v));
					break;
				case 3:
					Map<Candidate, Position> map1 = (Map<Candidate, Position>) in.readObject();
					map1.forEach((k, v) -> System.out.println(k + " - " + v));
					break;
				case 4:
					sc.nextLine();
					System.out.print("Enter the candidate ID: ");
					String id = sc.nextLine();
					out.writeUTF(id);

					System.out.print("Enter the full name: ");
					String fullName = sc.nextLine();
					out.writeUTF(fullName);

					System.out.print("Enter the year of birth: ");
					int yearOfBirth = sc.nextInt();
					out.writeInt(yearOfBirth);

					sc.nextLine();
					System.out.print("Enter gender: ");
					String gender = sc.nextLine();
					out.writeUTF(gender);
					
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					out.writeUTF(email);
					
					System.out.print("Enter phone: ");
					String phone = sc.nextLine();
					out.writeUTF(phone);
					
					System.out.print("Enter description: ");
					String description = sc.nextLine();
					out.writeUTF(description);
								
					
					out.flush();

					try {
                        // existing code
                        if (in.readBoolean()) {
                            System.out.println("Add new candidate successfully!");
                        } else {
                            System.out.println("Add new candidate failed!");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
					break;

				case 5:
					sc.nextLine();
					System.out.print("Enter the candidate ID: ");
					String candidateID = sc.nextLine();
					out.writeUTF(candidateID);
					out.flush();

					Map<Position, Integer> map2 = (Map<Position, Integer>) in.readObject();
					map2.forEach((k, v) -> System.out.println(k + " - " + v));
					break;
				case 6:
					System.out.print("Exit");
					out.writeInt(6);
					out.flush();
					break;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
