package test04;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

public class ConvertJson {
	public static List<Patient> readJson(String fileName) {
		List<Patient> patients = new ArrayList<Patient>();
		
		try(JsonReader jReader = Json.createReader(new FileReader(fileName))) {
			JsonArray jArray = jReader.readArray();
			for (JsonValue jsonValue : jArray) {
				JsonObject jObject = (JsonObject) jsonValue;
				Patient patient = new Patient();
				
				
				patient.setId(jObject.getString("_id"));
				patient.setFirstName(jObject.getString("first_name"));
				patient.setLastName(jObject.getString("last_name"));
				patient.setBloodType(jObject.getString("blood_type"));
				patient.setGender(jObject.getString("gender"));
				patient.setDateOfBirth(jObject.getInt("year_of_birth"));
				
				JsonObject joAdd = jObject.getJsonObject("address");
				Address address = new Address();
				address.setCity(joAdd.getString("city"));
				address.setStreet(joAdd.getString("street"));
				address.setDistrict(joAdd.getString("district"));
				address.setWard(joAdd.getString("ward"));
				patient.setAddress(address);
				
				JsonArray jaTelephones = jObject.getJsonArray("telephones");
				List<String> phones = new ArrayList<String>();
				for (JsonValue jsonValue2 : jaTelephones) {
					phones.add(jsonValue2.toString());
				}
				patient.setPhoneNumbers(phones);
				
				JsonArray jaTests = jObject.getJsonArray("tests");
				List<Test> tests = new ArrayList<Test>();
				
				for (JsonValue jsonValue2 : jaTests) {
					JsonObject jobTest = (JsonObject) jsonValue2;
					Test test = new Test();
					
					JsonObject joDate = jobTest.getJsonObject("date");
					int day = joDate.getInt("day");
					int month = joDate.getInt("month");
					int year = joDate.getInt("year");
					
					test.setDate(LocalDate.of(year, month, day));
					test.setResult(jobTest.getString("result"));
					test.setTestId(jobTest.getInt("test_id"));
					test.setTestType(jobTest.getString("test_type"));
					test.setCost(jobTest.getInt("cost"));
					tests.add(test);
				}
				
				patient.setTests(tests);
				
				patients.add(patient);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return patients;
	}

	public static String writeJson(List<Patient> patients) {
		return null;
	}
}
