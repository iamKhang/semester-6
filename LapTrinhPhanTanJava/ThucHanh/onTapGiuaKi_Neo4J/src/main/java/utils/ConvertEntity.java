package utils;

import java.util.Map;

import org.neo4j.driver.types.Node;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConvertEntity {

	private static final Gson gson = new Gson();

	public static <T> T convertEntity(Node node, Class<T> clazz) {
		String json = gson.toJson(node.asMap());
		return gson.fromJson(json, clazz);
	}

	public static <T> Map<String, Object> getProperties(T t) {
		String json = gson.toJson(t);
		Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		});
		return map;
	}
}
