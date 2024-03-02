package test03;

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
	public static List<Customer> readFile(String fileName) {
		List<Customer> list = new ArrayList<Customer>();

		try (JsonReader jReader = Json.createReader(new FileReader(fileName))) {
			JsonArray jArray = jReader.readArray();
			for (JsonValue jsonValue : jArray) {
				JsonObject jObject = (JsonObject) jsonValue;

				Customer customer = new Customer();
				customer.setFirstName(jObject.getString("first_name"));
				customer.setLastName(jObject.getString("last_name"));
				customer.setEmail(jObject.getString("email_address"));
				customer.setAlive(jObject.getBoolean("is_alive"));
				customer.setAge(jObject.getInt("age"));
				customer.setHeight(jObject.getJsonNumber("height_cm").doubleValue());

				List<String> numberPhones = new ArrayList<String>();
				JsonArray jaNumberPhones = jObject.getJsonArray("phone_numbers");
				for (JsonValue jsonValue2 : jArray) {
					numberPhones.add(jsonValue2.toString());
				}
				customer.setPhoneNumber(numberPhones);

				Address billingAddress = new Address();
				JsonObject joBillAdd = jObject.getJsonObject("billing_address");

				billingAddress.setAddress(joBillAdd.getString("address"));
				billingAddress.setCity(joBillAdd.getString("city"));
				billingAddress.setState(joBillAdd.getString("state"));
				billingAddress.setPostalCode(joBillAdd.getInt("postal_code"));

				Address shippingAddress = new Address();
				JsonObject joShipAdd = jObject.getJsonObject("shipping_address");
				shippingAddress.setAddress(joShipAdd.getString("address"));
				shippingAddress.setCity(joShipAdd.getString("city"));
				shippingAddress.setState(joShipAdd.getString("state"));
				shippingAddress.setPostalCode(joShipAdd.getInt("postal_code"));

				customer.setBillingAddress(billingAddress);
				customer.setShippingAddress(shippingAddress);
				list.add(customer);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;

	}

	public static void writeFile(List<Customer> list, String fileName) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab  = Json.createArrayBuilder();
		
		try(JsonWriter jWriter  = Json.createWriter(new FileWriter(fileName))) {
			for (Customer customer : list) {
				List<String> phones  =customer.getPhoneNumber();
				JsonArrayBuilder jaPhones = Json.createArrayBuilder();
				
				for (String phone : phones) {
					jaPhones.add(phone.toString());
				}
				
				Address billing = customer.getBillingAddress();
				JsonObjectBuilder jobBilling = Json.createObjectBuilder();
				jobBilling.add("address", billing.getAddress()).add("city", billing.getCity())
				.add("state", billing.getState()).add("postal_code", billing.getPostalCode());
				
				Address shipping = customer.getShippingAddress();
				JsonObjectBuilder jobShipping = Json.createObjectBuilder();
				jobShipping.add("address", shipping.getAddress()).add("city", shipping.getCity())
				.add("state", shipping.getState()).add("postal_code", shipping.getPostalCode());
				
				
				JsonObject jObject =  job.add("first_name", customer.getFirstName())
						.add("last_name", customer.getLastName())
						.add("email_address", customer.getEmail())
						.add("phone_numbers", jaPhones)
						.add("is_alive", customer.isAlive())
						.add("age", customer.getHeight())
						.add("billing_address", jobBilling)
						.add("shipping_address", jobShipping)
						.build();
				jab.add(jObject);
			}
			jWriter.writeArray(jab.build());
			
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
