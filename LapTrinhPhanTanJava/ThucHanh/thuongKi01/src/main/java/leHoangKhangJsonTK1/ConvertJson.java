package leHoangKhangJsonTK1;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.JsonWriter;

public class ConvertJson {
	public static List<Project> readFile(String path) {

		List<Project> projects = new ArrayList<Project>();

		try (JsonReader jReader = Json.createReader(new FileReader(path))) {
			JsonArray jArray = jReader.readArray();

			for (JsonValue jsonValue : jArray) {
				JsonObject jObject = (JsonObject) jsonValue;

				Project project = new Project();
				project.setId(jObject.getString("id"));
				project.setLocation(jObject.getString("location"));
				project.setBudget(jObject.getJsonNumber("budget").doubleValue());
				project.setPeojectName(jObject.getString("project_name"));

				JsonObject jobDate = jObject.getJsonObject("start_date");
				int year = jobDate.getInt("year");
				int month = jobDate.getInt("month");
				int day = jobDate.getInt("day");

				project.setStartDate(LocalDate.of(year, month, day));

				JsonObject jDepartment = jObject.getJsonObject("department");
				Department department = new Department();
				department.setId(jDepartment.getString("id"));
				department.setName(jDepartment.getString("name"));

				JsonArray jContacts = jDepartment.getJsonArray("contacts");
				List<Contact> contacts = new ArrayList<Contact>();
				for (JsonValue value : jContacts) {
					JsonObject jContact = (JsonObject) value;
					Contact contact = new Contact();
					contact.setName(jContact.getString("name"));
					contact.setPhone(jContact.getString("phone"));
					contacts.add(contact);
				}
				department.setContacts(contacts);

				project.setDepartment(department);

				JsonArray jAssignments = jObject.getJsonArray("assignments");
				List<Assignment> assignments = new ArrayList<Assignment>();
				for (JsonValue value : jAssignments) {
					JsonObject jAssignment = (JsonObject) value;
					Assignment assignment = new Assignment();
					assignment.setHours(jAssignment.getInt("hours"));
					assignment.setEmployeeId(jAssignment.getString("employee_id"));
					assignments.add(assignment);
				}

				project.setAssignments(assignments);
				projects.add(project);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return projects;

	}
       

	public static void writeFile(String path, List<Project> projects) {

		try (JsonWriter jWriter = Json.createWriter(new FileWriter(path))) {
			JsonArrayBuilder jArrayBuilder = Json.createArrayBuilder();
			JsonObjectBuilder jObjectBuilder = Json.createObjectBuilder();

			for (Project project : projects) {
				
				jObjectBuilder.add("id", project.getId());
				jObjectBuilder.add("location", project.getLocation());
				jObjectBuilder.add("budget", project.getBudget());
				jObjectBuilder.add("project_name", project.getPeojectName());

				LocalDate startDate = project.getStartDate();
				JsonObjectBuilder jDateBuilder = Json.createObjectBuilder();
				jDateBuilder.add("year", startDate.getYear());
				jDateBuilder.add("month", startDate.getMonthValue());
				jDateBuilder.add("day", startDate.getDayOfMonth());

				jObjectBuilder.add("start_date", jDateBuilder);

				Department department = project.getDepartment();
				JsonObjectBuilder jDepartmentBuilder = Json.createObjectBuilder();
				jDepartmentBuilder.add("id", department.getId());
				jDepartmentBuilder.add("name", department.getName());

				JsonArrayBuilder jContactsBuilder = Json.createArrayBuilder();
				for (Contact contact : department.getContacts()) {
					JsonObjectBuilder jContactBuilder = Json.createObjectBuilder();
					jContactBuilder.add("name", contact.getName());
					jContactBuilder.add("phone", contact.getPhone());
					jContactsBuilder.add(jContactBuilder);
				}
				jDepartmentBuilder.add("contacts", jContactsBuilder);

				jObjectBuilder.add("department", jDepartmentBuilder);

				JsonArrayBuilder jAssignmentsBuilder = Json.createArrayBuilder();
				for (Assignment assignment : project.getAssignments()) {
					JsonObjectBuilder jAssignmentBuilder = Json.createObjectBuilder();
					jAssignmentBuilder.add("hours", assignment.getHours());
					jAssignmentBuilder.add("employee_id", assignment.getEmployeeId());
					jAssignmentsBuilder.add(jAssignmentBuilder);
				}
				jObjectBuilder.add("assignments", jAssignmentsBuilder);

				jArrayBuilder.add(jObjectBuilder);
			}
			
			JsonArray jArray = jArrayBuilder.build();
			jWriter.writeArray(jArray);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
