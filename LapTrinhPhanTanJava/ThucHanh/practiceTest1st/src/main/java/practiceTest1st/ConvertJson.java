package practiceTest1st;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sql.rowset.CachedRowSet;

public class ConvertJson {

	public static ArrayList<Restaurant> readFiles(String filePath) {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant restaurant = null;
		Address address = null;
		ArrayList<Grade> grades = null;
		String keyName = "";

		try (JsonParser parser = Json.createParser(new FileReader(filePath))) {
			while (parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case KEY_NAME:
					keyName = parser.getString();
					break;
				case START_OBJECT:
					if (keyName.equals("address")) {
						address = new Address();
					} else if (restaurant == null) {
						restaurant = new Restaurant();
					}
					break;
				case END_OBJECT:
					if (address != null) {
						restaurant.setAddress(address);
						address = null;
					} else if (restaurant != null) {
						restaurants.add(restaurant);
						restaurant = null;
					}
					break;
				case START_ARRAY:
					if (keyName.equals("coord")) {
						double[] coord = new double[2];
						int i = 0;
						JsonArray jArray = parser.getArray();
						for (JsonValue jValue : jArray) {
							JsonNumber jNumber = (JsonNumber) jValue;
							coord[i++] = jNumber.doubleValue();
						}
						address.setCoord(coord);
					} else if (keyName.equals("grades")) {
						grades = new ArrayList<Grade>();
						JsonArray jArray = parser.getArray();
						for (JsonValue jsonValue : jArray) {
							Grade grade = new Grade();
							JsonObject jObject = (JsonObject) jsonValue;
							JsonObject date = jObject.getJsonObject("date");
							grade.setDate(LocalDate.of(date.getInt("year"), date.getInt("month"), date.getInt("day")));
							grade.setGrade(jObject.getString("grade"));
							grade.setScore(jObject.getInt("score"));
							grades.add(grade);
						}
						restaurant.setGrades(grades);
						grades = null;
					}
					break;
				case END_ARRAY:
					if (!keyName.equals("coord") && restaurant != null) {
						restaurant.setGrades(grades);
						grades = null;
					}
					break;
				case VALUE_STRING:
					String value = parser.getString();
					switch (keyName) {
					case "restaurant_id":
						restaurant.setRestaurant_id(value);
						break;
					case "name":
						restaurant.setName(value);
						break;
					case "building":
						address.setBuilding(value);
						break;
					case "street":
						address.setStreet(value);
						break;
					case "zipcode":
						address.setZipcode(value);
						break;
					case "cuisine":
						restaurant.setCuisine(value);
						break;
					case "borough":
						restaurant.setBorough(value);
						break;
					default:
						break;
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		for (Restaurant res : restaurants) {
			System.out.println(res);
		}
		return restaurants;
	}
}
