package iuh.fit.handler;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import iuh.fit.entity.State;
import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class StateJsonHandler {
	
//	Tìm kiếm đối tượng State theo abbreviation, trả về null nếu không tồn tại
//	+ findByAb(abb:String): State
	public static State findByAb(String abb) {

		State st = null;
		String keyName = "";

		try(JsonParser parser = Json.createParser(new FileReader("./data/states.json"))){

			while(parser.hasNext()) {
				Event event = parser.next();
				switch (event){

				case START_OBJECT : 
					st = new State();
					break;

				case KEY_NAME :
					keyName = parser.getString();
					break;

				case VALUE_STRING :
					String value = parser.getString();
					setStringValues(st, keyName, value);
					break;

				case VALUE_NUMBER :
					JsonValue jv = parser.getValue();
					if(jv instanceof JsonNumber){
						JsonNumber numValue = (JsonNumber) jv;
						if(keyName.equals("ID"))
							st.setId(numValue.longValue());
						else
							st.setStatehood(numValue.intValue());
					}

					break;           

				case END_OBJECT :
//					System.out.println(st);
					if(st.getAbbreviation().equalsIgnoreCase(abb))
						return st;
					break;
				default: break;
				}
			}

		}catch (IOException e){
			e.printStackTrace();
		}

		return null;
	}
	
//	b.  Tìm kiếm các đối tượng State có state-hood-year(ie. năm thành lập) trước một năm được 
//	cung cấp
//	+ findByYear(year:int): List<State>
	public static List<State> findByYear(int year){

		List<State> states = null;
		State st = null;
		String keyName = "";

		try(JsonParser parser = Json.createParser(new FileReader("./data/states.json"))){

			while(parser.hasNext()) {
				Event event = parser.next();
				switch (event){
				case START_ARRAY :
					states = new ArrayList<>();
					break;

				case START_OBJECT : 
					st = new State();
					break;

				case KEY_NAME :
					keyName = parser.getString();
					break;

				case VALUE_STRING :
					String value = parser.getString();
					setStringValues(st, keyName, value);
					break;

				case VALUE_NUMBER :
					JsonValue jv = parser.getValue();
					if(jv instanceof JsonNumber){
						JsonNumber numValue = (JsonNumber) jv;
						if(keyName.equals("ID"))
							st.setId(numValue.longValue());
						else
							st.setStatehood(numValue.intValue());
					}

					break;           

				case END_OBJECT :
					if(st.getStatehood()==year)
						states.add(st);
					break;
				default: break;
				}
			}

		}catch (IOException e){
			e.printStackTrace();
		}

		return states;
	}
	

	/**
	 * Get all states
	 * @param st
	 * @param keyName
	 * @param value
	 */
	public static List<State> getStates(){

		List<State> states = null;
		State st = null;
		String keyName = "";

		try(JsonParser parser = Json.createParser(new FileReader("./data/states.json"))){

			while(parser.hasNext()) {
				Event event = parser.next();
				switch (event){
				case START_ARRAY :
					states = new ArrayList<>();
					break;

				case START_OBJECT : 
					st = new State();
					break;

				case KEY_NAME :
					keyName = parser.getString();
					break;

				case VALUE_STRING :
					String value = parser.getString();
					setStringValues(st, keyName, value);
					break;

				case VALUE_NUMBER :
					JsonValue jv = parser.getValue();
					if(jv instanceof JsonNumber){
						JsonNumber numValue = (JsonNumber) jv;
						if(keyName.equals("ID"))
							st.setId(numValue.longValue());
						else
							st.setStatehood(numValue.intValue());
					}

					break;           

				case END_OBJECT :
					states.add(st);
					break;
				default: break;
				}
			}

		}catch (IOException e){
			e.printStackTrace();
		}

		return states;
	}

	private static void setStringValues(State st, String keyName, String value) {
		switch (keyName){
		case "StateName": 
			st.setStateName(value);
			break;
		case "Abbreviation":
			st.setAbbreviation(value);
			break;
		case "Capital" :
			st.setCapital(value);
			break;

		}
	}
}
