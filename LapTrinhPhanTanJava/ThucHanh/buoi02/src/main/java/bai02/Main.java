package bai02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Person pRead = ConvertJson.readFile("data/bai02.json");
		// System.out.println(pRead);
		
		// List<PhoneNumber> listPhone = List.of(
		// 		new PhoneNumber("sdt", "0385489658"),
		// 		new PhoneNumber("emai", "iamhoangkhang@icloud.com")
		// 		);
		// Person pWrite = new Person("Le Hoang", "Khang", 20, new Address("Pham Ngu Lao", "Ho Chi Minh", "123", 123), listPhone);
		// ConvertJson.writeFile("data/bai02.json", pWrite);


		ArrayList<Person> persons = ConvertJsonWithStreamingAPI.readFiles("data/bai02.json");
		for (Person person : persons) {
			System.out.println(person);
		}

	}

}
