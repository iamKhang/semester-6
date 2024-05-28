package main;

import dao.CandidateDao;
import entity.Candidate;
import entity.Certificate;
import entity.Position;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
  private CandidateDao candidateDao;

  public ClientHandler(Socket client) {
    super();
    this.socket = client;
    this.candidateDao = new CandidateDao();
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
            String name = in.readUTF();
            double salaryFrom = in.readDouble();
            double salaryTo = in.readDouble();
            List<Position> positions = candidateDao.listPositions(
              name,
              salaryFrom,
              salaryTo
            );
            out.writeObject(positions);
            break;
          case 2:
            Map<Candidate, Long> map = candidateDao.listCadidatesByCompanies();
            out.writeObject(map);
          case 3:
            Map<Candidate, Position> map1 = candidateDao.listCandidatesWithLongestWorking();
            out.writeObject(map1);
            break;
          case 4:
            String id = in.readUTF();
            String fullName = in.readUTF();
            int dob = in.readInt();
            String gender = in.readUTF();
            String email = in.readUTF();
            String phone = in.readUTF();
            String description = in.readUTF();
            Candidate candidate = new Candidate(
              id,
              fullName,
              dob,
              gender,
              email,
              phone,
              description
            );
            boolean result = candidateDao.addCandidate(candidate);
            System.out.println("Add candidate result: " + result);
            out.writeBoolean(result);
            out.flush();
            break;
          case 5:
            String candidateID = in.readUTF();
            Map<Position, Integer> map2 = candidateDao.listYearsOfExperienceByPosition(
              candidateID
            );
            out.writeObject(map2);
            break;
          case 6:
            Map<Candidate, Set<Certificate>> map3 = candidateDao.listCadidatesAndCertificates();
            out.writeObject(map3);
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
