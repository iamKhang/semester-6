package server;

import jakarta.persistence.Persistence;

public class Test_Main {
public static void main(String[] args) {
	  Persistence.createEntityManagerFactory("jpa-mssql");
      System.out.println("Tạo database thành công!");
}
}
