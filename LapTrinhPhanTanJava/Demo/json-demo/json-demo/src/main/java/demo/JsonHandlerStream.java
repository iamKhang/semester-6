package demo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class JsonHandlerStream {
	public static Person readFromFile(String fileName) {

		Person p = null;
		List<PhoneNumber> phones = null;
		String keyName = "";
		Address add = null;
		
		try(JsonParser parser = Json.createParser(new FileReader(fileName));){

			while(parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT :
					if(keyName.equals("address"))
						add = new Address();
					else
						p = new Person();
					break;
				case START_ARRAY:
					phones = new ArrayList<>();
					JsonArray ja = parser.getArray();
					for(JsonValue jv: ja) {
						JsonObject joPh = (JsonObject) jv;
						phones.add(new PhoneNumber(joPh.getString("type"), joPh.getString("number")));
					}
					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;

				case VALUE_STRING:
					break;

				case VALUE_NUMBER:
					break;

				case END_OBJECT:
					p.setAddress(add);
					p.setPhoneNumbers(phones);
					break;
				case END_ARRAY:
					break;
				default:
					break;
				}
			}

		}catch (IOException e) {
			e.printStackTrace();
		}

		return p;
	}
}
