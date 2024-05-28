package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.Food;
import entity.Item;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Socket socket = new Socket("IAMHOANGKHANG", 2003); Scanner sc = new Scanner(System.in);) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			int choice = 0;

			while (true) {
				System.out.println("1. Add food" + "\n2. List items" + "\n3. List food and cost");
				System.out.println("Enter your choice: ");
				choice = sc.nextInt();
				out.writeInt(choice);
				switch (choice) {
				case 1:
					sc.nextLine();
					String id;
					System.out.println("Enter the food ID: ");
					
					do {
						id = sc.nextLine();
//						ID must be unique, begin with F and follow by at least 3 digits
						if (!id.matches("F\\d{3,}")) {
							System.out.println("Invalid ID! Please enter again");
							id = "";
						}
                    } while (id.isEmpty());
					
					out.writeUTF(id);

					System.out.println("Enter the food name: ");
					String name = sc.nextLine();
					out.writeUTF(name);

					System.out.println("Enter the food price: ");
					double price = sc.nextDouble();
					out.writeDouble(price);

					sc.nextLine();
					System.out.println("Enter the food description: ");
					String description = sc.nextLine();
					out.writeUTF(description);

					System.out.println("Is the food on special? (Choosen 1 for true, 0 for false)");
					boolean onSpecial = sc.nextInt() == 1 ? true : false;
					out.writeBoolean(onSpecial);

//					Type is APPETIZER, MAIN_COURSE, DESSERT;
					String typeString = "";
					while (true) {
						System.out.println("Enter the food type(1 is APPETIZER, 2 is MAIN_COURSE, 3 is DESSERT): ");
						int type = sc.nextInt();
						switch (type) {
						case 1:
							typeString = "APPETIZER";
							break;
						case 2:
							typeString = "MAIN_COURSE";
							break;
						case 3:
							typeString = "DESSERT";
							
							break;
						default:
							System.out.println("Invalid choice");
							continue;
						}
						if (!typeString.isEmpty()) {
							break;
						}
					}
					out.writeUTF(typeString);
					
					System.out.println("Enter the food preparation time: ");
					int preparationTime = sc.nextInt();
					out.writeInt(preparationTime);
					
					System.out.println("Enter the food serving time: ");
					int servingTime = sc.nextInt();
					out.writeInt(servingTime);
					
					out.flush();
					
					boolean result = in.readBoolean();
					if (result) {
						System.out.println("Add new food successfully!");
					} else {
						System.out.println("Add new food failed!");
					}

					break;
				case 2:
					sc.nextLine();
					System.out.println("Supplier name: ");
					String supplierName = sc.nextLine();
					out.writeUTF(supplierName);
					out.flush();
					List<Item> items = (List<Item>) in.readObject();
					items.forEach(System.out::println);
				case 3:
					Map<Food, Double> map = (Map<Food, Double>) in.readObject();
					for (Food f : map.keySet()) {
						System.out.println(f.getName() + " " + map.get(f));
					}
				case 4:
					System.out.println("Exit");
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