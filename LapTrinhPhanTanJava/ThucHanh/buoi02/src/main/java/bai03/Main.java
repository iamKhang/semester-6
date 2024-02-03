package bai03;

import java.util.List;

public class Main {
	public static void main(String[] args) {
//		ConvertJson.readToFile("data/bai03.json");
		
		List<State> states = ConvertJsonWithStreamingAPI.readFile("data/bai03.json");
		for (State state : states) {
			System.out.println(state);
		}
	}
}
