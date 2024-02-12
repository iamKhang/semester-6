package bai03;

/*
 * @ (#) Company.java       1.0     Sep 11, 2023
 *
 * Copyright (c) 2023 IUH. All rights reserved.
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @description:
 * @author: Khanh Nguyen
 * @date:   Sep 11, 2023
 * @version:    1.0
 */
public class EmployeeList {

  private Set<Employee> employees;

  /**
   * Default constructor: Create a collection of employees
   */
  public EmployeeList() {
    employees = new HashSet<>();
  }

  /**
   * This method returns the collection of employees
   * @return
   */
  public Set<Employee> getEmployees() {
    return employees;
  }

  /**
   * This method adds a new employee to the list.
   * @param emp the new employee
   * @throws IllegalArgumentException if the employee id is duplicated
   */
  public boolean addEmployee(Employee emp) {
    return employees.add(emp);
  }

  /**
   * Tìm nhân viên theo mã
   * @param id
   * @return
   */
  public Employee searchEmployeeById(String id) {
    Optional<Employee> optional = employees
      .stream()
      .filter(emp -> emp.getId().equalsIgnoreCase(id))
      .findFirst();

    return optional.isPresent() ? optional.get() : null;
  }

  /**
   * This method adds an array of employees to the list
   * @param emps the array of employees
   */
  public void addAll(Set<Employee> emps) {
    //		emps.forEach(emp -> addEmployee(emp));
    employees.addAll(emps);
  }

  /**
   * This method sorts the list by weekly salary of employees in ascending order
   * @return
   */
  public Set<Employee> sortByWeeklySalary() {
    return employees
      .stream()
      .sorted(Comparator.comparing(Employee::weeklyPay))
      .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  public Set<Employee> sortByWeeklySalary2() {
    return employees
      .stream()
      .collect(
        Collectors.toCollection(() ->
          new TreeSet<>(Comparator.comparing(Employee::weeklyPay))
        )
      );
  }

  /**
   * Remove an employee by id
   * @param id the given id
   * @throws IllegalArgumentException if the employee with the given id does not exist
   */
  public boolean removeEmployee(String id) {
    return false;
  }

  /**
   * This method updates the information of an employee by id
   * @param newInfor the new information
   * @throws IllegalArgumentException if the employee with the given id does not exist
   */
  public boolean updateEmployee(Employee newInfor) {
    return false;
  }

  /**
   * This method returns an array of employees who are hourly employees and work more than 40 hours per week
   * @return an array of employees who are hourly employees and work more than 40 hours per week
   */
  public Set<Employee> getHourlyEmpsWorkMoreThan40() {
    return employees
      .stream()
      .filter(emp -> emp instanceof HourlyEmployee)
      .map(emp -> (HourlyEmployee) emp)
      .filter(emp -> emp.getHoursWorked() >= 40)
      .collect(Collectors.toSet());
  }

  /**
   * This method returns the total salary of all managers
   * @return the total salary of all managers
   */
  public double getWeeklyTotalSalaryOfManager() {
    return employees
		.stream()
		.filter(emp -> emp instanceof Manager)
		.mapToDouble(emp -> ((Manager) emp).weeklyPay())
		.sum();
  }

  /**
   * This method updates the hourly work of an hourly employee by id
   * @param id the given id
   * @param newHour the new hourly worked
   * @throws IllegalArgumentException if the new hourly worked is less than 0
   * @throws IllegalArgumentException if the employee with the given id does not exist or the employee is not an hourly employee
   */
  public void updateHourlyWorked(String id, int newHour) {}

  /**
   * This method returns an array of employees who are young managers (less than 30 years old)
   * @return an array of employees who are young managers (less than 30 years old)
   */
  public Set<Employee> getYoungEmployeesAsManagers() {
    return employees
      .stream()
      .filter(emp ->
        Period.between(emp.getDob(), LocalDate.now()).getYears() < 30
      )
      .filter(emp -> emp instanceof Manager)
      .collect(Collectors.toSet());
  }

  /**
   * This method returns a map of number of employees by year of birth, sort by year
   * @return
   */
  public Map<Integer, Long> getNoOfEmployeesByYOB() {
    return employees
      .stream()
      .collect(
        Collectors.groupingBy(e -> e.getDob().getYear(), Collectors.counting())
      )
      .entrySet()
      .stream()
      .sorted(Comparator.comparing(Entry::getKey))
      .collect(
        Collectors.toMap(
          Entry::getKey,
          Entry::getValue,
          (x, y) -> x,
          LinkedHashMap::new
        )
      );
  }

  //+ getTotalWeeklySalary(): Map<String, Double>
  public Map<String, Double> getTotalWeeklySalary() {
    return employees.stream()
    		.collect(Collectors.groupingBy(
    				emp -> emp.getClass().getSimpleName(),
    				Collectors.summingDouble(Employee::weeklyPay)			
    				));
  }
}
