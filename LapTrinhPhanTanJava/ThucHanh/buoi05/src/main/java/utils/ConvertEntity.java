package utils;

import java.util.Map;

import org.neo4j.driver.types.Node;

import com.google.gson.Gson;

public class ConvertEntity {
	private static final Gson gson = new Gson();

	public static <T> T convertEntity(Node node, Class<T> clazz) {
		String json = gson.toJson(node.asMap());
		return gson.fromJson(json, clazz);
	}
	public static <T> Map<String, Object> getParams(Object object, Class<T> clazz) {
        String json = gson.toJson(object);
        return gson.fromJson(json, Map.class);
    }

}
