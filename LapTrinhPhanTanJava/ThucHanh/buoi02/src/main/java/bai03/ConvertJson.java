package bai03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class ConvertJson {
	public static List<State> readToFile(String filePath) {
		
		try {
			List<State> listState = new ArrayList<State>();
			JsonReader jr  = Json.createReader(new FileReader(filePath));
			JsonArray ja = jr.readArray();
			
			for (int i = 0; i < ja.size(); i++) {
				State state = new State();
				JsonObject jo = ja.getJsonObject(i);
				state.setId(jo.getInt("ID"));
				state.setAbbreviation(jo.getString("Abbreviation"));
				state.setCapital(jo.getString("Capital"));
				state.setStateHood(jo.getInt("Statehood"));
				state.setStateName(jo.getString("StateName"));
				
			System.out.println(state);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
