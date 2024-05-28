package server;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.BookDao;
import entity.Book;

public class Server {

  public static void main(String[] args) {
    try (ServerSocket server = new ServerSocket(2003);) {
      System.out.println("Server started on port 2003");

      while (true) {
        Socket client = server.accept();

        System.out.println("Client connected");
        System.out.println(
          "Client IP: " + client.getInetAddress().getHostName()
        );
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
  private BookDao dao;

  public ClientHandler(Socket client) {
    super();
    this.socket = client;
    this.dao = new BookDao();
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
            String author = in.readUTF();
            int rating = in.readInt();
            System.out.println("Author: " + author);
            System.out.println("Rating: " + rating);
            List<Book> list = dao.listRatedBooks(author, rating);
            list.forEach(System.out::println);
            out.writeObject(list);
            out.flush();
            break;
          case 2:
				Map<String, Long> map = dao.countBooksByAuthor();
				out.writeObject(map);
            break;
           case 3:
        	   String isbn = in.readUTF();
        	   String readerID = in.readUTF();
        	   int ratingUpdate = in.readInt();
        	   String comment = in.readUTF();
        	   boolean result = dao.updateReviews(isbn, readerID, ratingUpdate, comment);
        	   out.writeBoolean(result);
        	   out.flush();
        	   break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}