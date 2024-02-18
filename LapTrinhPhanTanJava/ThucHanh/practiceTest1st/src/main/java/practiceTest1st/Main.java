package practiceTest1st;

import java.util.ArrayList;

import jakarta.json.stream.JsonParser.Event;

public class Main {
	public static void main(String[] args) {
		ArrayList<Restaurant> restaurants = ConvertJson.readFiles("data/restaurants.json");
		
	}
}
