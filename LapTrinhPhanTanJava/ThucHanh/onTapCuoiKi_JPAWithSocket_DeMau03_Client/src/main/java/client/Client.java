package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.Book;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (Socket socket = new Socket("IAMHOANGKHANG", 2003); Scanner sc = new Scanner(System.in);) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			int choice = 0;

			while (true) {
				System.out.println("1. List all books of an author with rating"
						+ "\n2. Count the number of books translated by each author" 
						+ "\n3. Update a review for a book"
						+ "\n4. Exit" + "\nYour choice:");
				System.out.println("Enter your choice:");
				choice = sc.nextInt();
				out.writeInt(choice);
				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.println("Enter author:");
					String author = sc.nextLine();
					System.out.println("Enter rating:");
					int rating = sc.nextInt();
					out.writeUTF(author);
					out.writeInt(rating);
					out.flush();
					List<Book> list = (List<Book>) in.readObject();
					if (list.isEmpty()) {
						System.out.println("No book found");
					} else {
						list.forEach(System.out::println);
					}
					break;
				case 2:
					System.out.println("Count the number of books translated by each author");
					Map<String, Long> list1 = (Map<String, Long>) in.readObject();
					list1.forEach((k, v) -> System.out.println(k + " - " + v));
					break;
				case 3:
					System.out.println("Update a review for a book");
					System.out.println("Enter ISBN:");
					String isbn = sc.next();
					System.out.println("Enter reader ID:");
					String readerID = sc.next();
					System.out.println("Enter rating:");
					int rating1 = sc.nextInt();
					System.out.println("Enter comment:");
					String comment = sc.next();
					out.writeUTF(isbn);
					out.writeUTF(readerID);
					out.writeInt(rating1);
					out.writeUTF(comment);
					boolean result = in.readBoolean();
					System.out.println(result ? "Update successfully" : "Update failed");
					break;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
