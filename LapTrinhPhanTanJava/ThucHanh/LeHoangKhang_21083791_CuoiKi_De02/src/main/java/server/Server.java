package server;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import dao.CandidateDao;
import dao.impl.CandidateDaoImpl;
import entity.Candidate;
import entity.Position;
import jakarta.persistence.Column;

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
	private CandidateDao candidateDao;

	public ClientHandler(Socket client) {
		super();
		this.socket = client;
		this.candidateDao = new CandidateDaoImpl();
	}

	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

			int choice = 0;

			while (true) {
//	    		public List<Position> listPositions(String name, double salaryFrom, double salaryTo);
//	    		public Map<Candidate, Long> listCadidatesByCompanies();
//	    		public Map<Candidate, Position> listCandidatesWithLongestWorking();
//	    		public boolean addCandidate(Candidate candidate);
//	    		public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID);
//	    		public Map<Candidate, Set<Certificate>> listCadidatesAndCertificates();

//	    		a) Liệt kê danh sách các vị trí công việc khi biết tên vị trí (tìm tương đối) và mức lương khoảng từ,
//	    		kết quả sắp xếp theo tên vị trí công việc.
//	    		+ listPositions(name: String, salaryFrom: double, salaryTo: double): List<Position>
//	    		b) Liệt kê danh sách các ứng viên và số công ty mà các ứng viên này từng làm.
//	    		+ listCadidatesByCompanies() : Map<Candidate, Long>
//	    		c) Tìm danh sách các ứng viên đã làm việc trên một vị trí công việc nào đó có thời gian làm lâu nhất.
//	    		+ listCandidatesWithLongestWorking (): Map<Candidate, Position>
//	    		d) Thêm một ứng viên mới. Trong đó mã số ứng viên phải bắt đầu là C, theo sau ít nhất là 3 ký số.
//	    		+ addCandidate(candidate: Candidate) : boolean
//	    		e) Tính số năm làm việc trên một vị trí công việc nào đó khi biết mã số ứng viên.
//	    		+ listYearsOfExperienceByPosition(candidateID: String): Map<Position, Integer>
//	    		f) Liệt kê danh sách các ứng viên và danh sách bằng cấp của từng ứng viên.
//	    		+ listCadidatesAndCertificates(): Map<Candidate, Set<Certificate >>
//	    	System.out.println("1. Get list position by name and salary"
//	    			                    + "\n2. Get list candidate and number of companies they worked for"
//	    			                    + "\n3. Get list candidate and their working position with longest time"
//	    			                    + "\n4. Add new candidate"
//	    			                    + "\n5. Get list candidate and their years of experience by position"
//	    			                    + "\n6. Get list candidate and their certificates"
//	    			                    + "\n7. Exit");
//	    	System.out.println("Enter your choice: ");
				choice = in.readInt();
				switch (choice) {
				case 1:
					String name = in.readUTF();
					double salaryFrom = in.readDouble();
					double salaryTo = in.readDouble();
					List<Position> positions = candidateDao.listPositions(name, salaryFrom, salaryTo);
					out.writeObject(positions);
					break;
				case 2:
					out.writeObject(candidateDao.listCadidatesByCompanies());
					break;
				case 3:
					out.writeObject(candidateDao.listCandidatesWithLongestWorking());
					break;
				case 4:
					String id = in.readUTF();
					String fullName = in.readUTF();
					int yearOfBirth = in.readInt();
					String gender = in.readUTF();
					String email = in.readUTF();
					String phone = in.readUTF();
					String description = in.readUTF();

					Candidate candidate = new Candidate(id, fullName, yearOfBirth, gender, email, phone, description);
					boolean result = candidateDao.addCandidate(candidate);
					out.writeBoolean(result);
					break;
				case 5:
					String candidateID = in.readUTF();
					out.writeObject(candidateDao.listYearsOfExperienceByPosition(candidateID));
					break;
				case 6:
					out.writeObject(candidateDao.listCadidatesAndCertificates());
					break;
				case 7:
					System.out.println("Client disconnected");
					socket.close();
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