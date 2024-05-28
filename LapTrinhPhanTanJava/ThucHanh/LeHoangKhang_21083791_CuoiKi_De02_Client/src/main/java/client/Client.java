package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entity.Candidate;
import entity.Certificate;
import entity.Position;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (Socket socket = new Socket("IAMHOANGKHANG", 2003); Scanner sc = new Scanner(System.in);) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			int choice = 0;

			while (true) {
				System.out.println("1. Get list of positions"
						+ "\n2. Get list of candidates and number of companies they have worked for"
						+ "\n3. Get list of candidates who have worked the longest on a position"
						+ "\n4. Add a new candidate"
						+ "\n5. Get list of candidates and their years of experience on a position"
						+ "\n6. Get list of candidates and their certificates" + "\n7. Exit" + "\nEnter your choice:");
				choice = sc.nextInt();
				out.writeInt(choice);
				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.println("Enter position name:");
					String name = sc.nextLine();
					System.out.println("Enter salary from:");
					double salaryFrom = sc.nextDouble();
					System.out.println("Enter salary to:");
					double salaryTo = sc.nextDouble();
					out.writeUTF(name);
					out.writeDouble(salaryFrom);
					out.writeDouble(salaryTo);
					List<Position> positions = (List<Position>) in.readObject();
					positions.forEach(System.out::println);
					break;
				case 2:
					Map<Candidate, Long> listCadidatesByCompanies = (Map<Candidate, Long>) in.readObject();
					listCadidatesByCompanies.forEach((k, v) -> {
						System.out.println(k + " - " + v);
					});
					break;
				case 3:
					Map<Candidate, Position> listCandidatesWithLongestWorking = (Map<Candidate, Position>) in
							.readObject();
					listCandidatesWithLongestWorking.forEach((k, v) -> {
						System.out.println(k + " - " + v);
					});
					break;
				case 4:
					sc.nextLine();
					System.out.println("Enter candidate id:");
					String id = sc.nextLine();

					while (!id.matches("C\\d{3,}")) {
						System.out.println("Invalid id. Please enter again:");
						System.out.println("Enter candidate id:");
						id = sc.nextLine();
					}

					out.writeUTF(id);

					System.out.println("Enter full name:");
					String fullName = sc.nextLine();
					out.writeUTF(fullName);

					System.out.println("Enter year of birth:");
					int yearOfBirth = sc.nextInt();
					out.writeInt(yearOfBirth);

					sc.nextLine();
					System.out.println("Enter gender(1 is Nam 0 is Nu):");
					String gender = ((sc.nextInt() == 1) ? "Nam" : "Nu");
					out.writeUTF(gender);

					sc.nextLine();
					System.out.println("Enter email:");
					String email = sc.nextLine();
					out.writeUTF(email);

					System.out.println("Enter phone:");
					String phone = sc.nextLine();
					out.writeUTF(phone);

					System.out.println("Enter description:");
					String description = sc.nextLine();
					out.writeUTF(description);

					out.flush();
					boolean result = in.readBoolean();
					if (result) {
						System.out.println("Candidate added successfully");
					} else {
						System.out.println("Candidate not added");
					}
					break;
				case 5:
					sc.nextLine();
					System.out.println("Enter candidate id:");
					String candidateID = sc.nextLine();
					out.writeUTF(candidateID);
					Map<Position, Integer> listYearsOfExperienceByPosition = (Map<Position, Integer>) in.readObject();
					listYearsOfExperienceByPosition.forEach((k, v) -> {
						System.out.println(k + " - " + v);
					});
					break;
				case 6:
					Map<Candidate, Set<Certificate>> map = (Map<Candidate, Set<Certificate>>) in.readObject();
					map.forEach((k, v) -> {
						System.out.println(k + " - " + v);
					});
					break;
				case 7:
					System.out.println("Client disconnected");
					return;
				default:
					System.out.println("Invalid choice");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}