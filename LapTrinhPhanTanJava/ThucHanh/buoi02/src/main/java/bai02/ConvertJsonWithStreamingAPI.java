package bai02;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class ConvertJsonWithStreamingAPI {
	public static ArrayList<Person> readFiles(String filePath) {

		ArrayList<Person> persons = new ArrayList();
		Person person = null;
		Address address = null;
		List<PhoneNumber> phoneNumbers;
		String keyName = "";

		try (JsonParser parser = Json.createParser(new FileReader(filePath))) {
			while (parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT:
					if (keyName.equals("address"))
						address = new Address();
					else {
						person = new Person();
					}
					break;
				case START_ARRAY:
					if (keyName.equals("phoneNumbers")) {
						phoneNumbers = new ArrayList();
						JsonArray jArray = parser.getArray();
						for (JsonValue jValue : jArray) {
							JsonObject jobObject = (JsonObject) jValue;
							phoneNumbers
									.add(new PhoneNumber(jobObject.getString("type"), jobObject.getString("number")));

						}
						person.setPhoneNumbers(phoneNumbers);
					}
					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;
				case VALUE_STRING:
					switch (keyName) {
					case "firstName":
						person.setFirstName(parser.getString());
						break;

					case "lastName":
						person.setLastName(parser.getString());
						break;
					case "streetAddress":
						address.setStreetAddress(parser.getString());
						break;
					case "city":
						address.setCity(parser.getString());
						break;
					case "state":
						address.setState(parser.getString());
						break;
					default:
						break;
					}
					break;
				case VALUE_NUMBER:
					switch (keyName) {
					case "age":
						person.setAge(parser.getInt());
						break;
					case "postalCode":
						address.setPostalCode(parser.getInt());
						break;
					}
				case END_OBJECT:
					if (keyName.equals("phoneNumbers")) {
						person.setAddress(address);
						persons.add(person);
					}
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return persons;
	}
}
