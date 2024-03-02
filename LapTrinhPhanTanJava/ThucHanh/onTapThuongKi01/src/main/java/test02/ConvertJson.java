package test02;

import java.io.FileReader;
import java.io.FileWriter;
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
	public static ArrayList<Customer> readFile(String fileName) {
		ArrayList<Customer> list = new ArrayList<Customer>();

		try (JsonReader jReader = Json.createReader(new FileReader(fileName))) {
			JsonArray jArray = jReader.readArray();

			for (JsonValue jsonValue : jArray) {
				Customer cus = new Customer();
				JsonObject jObject = (JsonObject) jsonValue;

				cus.setFirstName(jObject.getString("first_name"));
				cus.setLastName(jObject.getString("last_name"));
				cus.setEmail(jObject.getString("email_address"));
				cus.setAlive(jObject.getBoolean("is_alive"));
				cus.setAge(jObject.getInt("age"));
				cus.setHeight(jObject.getJsonNumber("height_cm").doubleValue());
				
				List<String> numbers = new ArrayList<String>();
				JsonArray jaPhones = jObject.getJsonArray("phone_numbers");
				for (JsonValue jsonValue2 : jArray) {
					System.out.println(jsonValue2);
					numbers.add(jsonValue2.toString());
				}
				cus.setPhoneNumbers(numbers);

				JsonObject jobBillAddress = jObject.getJsonObject("billing_address");
				Address billAddress = new Address();
				billAddress.setCity(jobBillAddress.getString("city"));
				billAddress.setAddress(jobBillAddress.getString("address"));
				billAddress.setState(jobBillAddress.getString("state"));
				billAddress.setPostalCode(jobBillAddress.getInt("postal_code"));
				cus.setBillAddress(billAddress);

				JsonObject jobShippAddress = jObject.getJsonObject("shipping_address");
				Address shippAddress = new Address();
				shippAddress.setCity(jobShippAddress.getString("city"));
				shippAddress.setAddress(jobShippAddress.getString("address"));
				shippAddress.setState(jobShippAddress.getString("state"));
				shippAddress.setPostalCode(jobShippAddress.getInt("postal_code"));
				cus.setShippAddress(shippAddress);

				list.add(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public static void writeFile(ArrayList<Customer> list, String fileName) {
		try (JsonWriter jWriter = Json.createWriter(new FileWriter(fileName))) {

			JsonObjectBuilder jObjectBuilder = Json.createObjectBuilder();
			JsonArrayBuilder jArrayBuilder = Json.createArrayBuilder();

			for (Customer customer : list) {

				JsonObjectBuilder jobBillAddress = Json.createObjectBuilder();
				Address billAddress = customer.getBillAddress();
				jobBillAddress.add("address", billAddress.getAddress()).add("city", billAddress.getCity())
						.add("state", billAddress.getState()).add("postal_code", billAddress.getPostalCode());

				JsonObjectBuilder jobShippAddress = Json.createObjectBuilder();
				Address shippAddress = customer.getShippAddress();
				jobBillAddress.add("address", shippAddress.getAddress()).add("city", shippAddress.getCity())
						.add("state", shippAddress.getState()).add("postal_code", shippAddress.getPostalCode());

				List<String> numberPhones = customer.getPhoneNumbers();
				System.out.println(customer);
				JsonArrayBuilder jabPhones = Json.createArrayBuilder();
				for (String phone : numberPhones) {
					jabPhones.add(phone.toString());
				}
				
				JsonObject joCus = jObjectBuilder.add("first_name", customer.getFirstName())
						.add("last_name", customer.getLastName())
						.add("email_address", customer.getEmail())
						.add("phone_numbers", jabPhones)
						.add("is_alive", customer.isAlive())
						.add("age", customer.getAge())
						.add("height_cm", customer.getHeight())
						.add("billing_address", jobBillAddress)
						.add("shipping_address", jobShippAddress)
						.build();
				
				jArrayBuilder.add(joCus);
			}
			JsonArray ja = jArrayBuilder.build();
			jWriter.writeArray(ja);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
