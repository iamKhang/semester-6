package bai02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import jakarta.json.JsonWriter;
import jakarta.json.JsonValue.ValueType;

public class ConvertJson {
	public static Person readFile(String filePath) {
		Person person = new Person();
		try {
			JsonReader jsonReader = Json.createReader(new FileReader(filePath));
			JsonObject jsonObject = jsonReader.readObject();

			person.setFirstName(jsonObject.getString("firstName"));
			person.setLastName(jsonObject.getString("lastName"));
			person.setAge(jsonObject.getInt("age"));

			JsonObject addressObject = jsonObject.getJsonObject("address");
			Address address = new Address();
			address.setCity(addressObject.getString("city"));
			address.setPostalCode(addressObject.getInt("postalCode"));
			address.setState(addressObject.getString("state"));
			address.setStreetAddress(addressObject.getString("streetAddress"));

			person.setAddress(address);

			JsonArray arrayNumberPhones = jsonObject.getJsonArray("phoneNumbers");
			List<PhoneNumber> phoneNumbers = new ArrayList<>();
			for (int i = 0; i < arrayNumberPhones.size(); i++) {
				JsonObject phoneNumberObject = arrayNumberPhones.getJsonObject(i);
				PhoneNumber phone = new PhoneNumber();
				phone.setType(phoneNumberObject.getString("type"));

			}

//			System.out.println(arrayNumberPhones);
			System.out.println(person.getAddress());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

	public static void writeFile(String filePath, Person person) {
		try (JsonWriter writer = Json.createWriter(new FileWriter(filePath))) {

			JsonObjectBuilder oBuilder = Json.createObjectBuilder();
			JsonArrayBuilder aBuilder = Json.createArrayBuilder();
			
//			List<PhoneNumber> listPhone = person.getPhoneNumbers();
//			for (PhoneNumber phoneNumber : listPhone) {
//				JsonObject job = Jso
//			}

			Address address = person.getAddress();
			JsonObject jAddress = oBuilder
					.add("streetAddress", address.getStreetAddress())
					.add("city", address.getCity()).add("state", address.getState())
					.add("postalCode", address.getPostalCode()).build();
	
			JsonObject jo = oBuilder
					.add("fristName", person.getFirstName())
					.add("lastName", person.getLastName())
					.add("age", person.getAge())
					.add("address", jAddress)
					.build();

			writer.writeObject(jo);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
