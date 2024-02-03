package bai03;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class ConvertJsonWithStreamingAPI {
    public static List<State> readFile(String filePath) {
        List<State> states = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            JsonParser parser = Json.createParser(fis);

            State state = null;
            String keyName = null;

            while (parser.hasNext()) {
                Event event = parser.next();

                switch (event) {
                    case START_OBJECT:
                        state = new State();
                        break;
                    case KEY_NAME:
                        keyName = parser.getString();
                        break;
                    case VALUE_STRING:
                        if (keyName.equals("StateName")) {
                            state.setStateName(parser.getString());
                        } else if (keyName.equals("Abbreviation")) {
                            state.setAbbreviation(parser.getString());
                        } else if (keyName.equals("Capital")) {
                            state.setCapital(parser.getString());
                        }
                        break;
                    case VALUE_NUMBER:
                        if (keyName.equals("Statehood")) {
                            state.setStateHood(parser.getInt());
                        } else if (keyName.equals("ID")) {
                            state.setId(parser.getInt());
                        }
                        break;
                    case END_OBJECT:
                        states.add(state);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return states;
    }
}
