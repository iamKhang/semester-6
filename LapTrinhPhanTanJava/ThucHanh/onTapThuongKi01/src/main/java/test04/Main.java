package test04;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Patient> patients = ConvertJson.readJson("data/patients.json");
		
		for (Patient patient : patients) {
			System.out.println(patient);
		}
	}
	
	
}
