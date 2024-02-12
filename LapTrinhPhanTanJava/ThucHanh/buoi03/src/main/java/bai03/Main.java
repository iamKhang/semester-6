package bai03;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

  static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    EmployeeList list = new EmployeeList();
    List<Employee> emps = List.of(
      new HourlyEmployee(
        "H001",
        "Morgan, Harry",
        LocalDate.of(1995, 2, 12),
        50,
        10.0
      ),
      new SalariedEmployee(
        "S012",
        "Lin, Sally",
        LocalDate.of(1975, 12, 12),
        52000
      ),
      new SalariedEmployee(
        "S022",
        "Lin, Sally",
        LocalDate.of(1975, 12, 12),
        52000
      ),
      new SalariedEmployee(
        "S032",
        "Lin, Sally",
        LocalDate.of(1975, 12, 12),
        52000
      ),
      new SalariedEmployee(
        "S002",
        "Lin, Sally",
        LocalDate.of(1995, 12, 12),
        52000
      ),
      new Manager("S003", "Smith, Mary", LocalDate.of(1975, 8, 22), 104000, 50),
      new Manager("S004", "Smith, Mary", LocalDate.of(1990, 6, 25), 94000, 40),
      new Manager("S005", "Smith, Mary", LocalDate.of(2000, 6, 25), 94000, 40)
    );
    Set<Employee> temp = new HashSet<>(emps);
    list.addAll(temp);

    System.out.println(list.getTotalWeeklySalary());
  }
}
