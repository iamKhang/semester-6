package server;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.ItemDao;
import dao.impl.ItemDaoImpl;
import entity.Food;
import enums.Type;

public class Server {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(2003);) {
			System.out.println("Server started on port 2003");

			while (true) {
				Socket client = server.accept();

				System.out.println("Client connected");
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client Port: " + client.getPort());

				Thread t = new Thread(new ClientHandler(client));
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ClientHandler implements Runnable {

	private Socket socket;
	private ItemDao itemDao;

	public ClientHandler(Socket client) {
		super();
		this.socket = client;
		this.itemDao = new ItemDaoImpl();
	}

	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

			int choice = 0;

			while (true) {
				choice = in.readInt();
				switch (choice) {
				case 1:

					String id = in.readUTF();
					String name = in.readUTF();
					double price = in.readDouble();
					String description = in.readUTF();
					boolean onSpecial = in.readBoolean();
					String type = in.readUTF();
					int preparationTime = in.readInt();
					int servingTime = in.readInt();

					Food food = new Food(id, name, price, description, onSpecial, Type.valueOf(type), preparationTime,
							servingTime);
					out.writeBoolean(itemDao.addFood(food));
					out.flush();
					break;
				case 2:
					String supplierName = in.readUTF();
					out.writeObject(itemDao.listItems(supplierName));
					out.flush();
					break;
				case 3:
					out.writeObject(itemDao.listFoodAndCost());
					out.flush();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
