package utils;

import java.net.URI;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

public class ConnectDB {
	public static Driver connectDB() {
		return GraphDatabase.driver("neo4j://localhost:7687", 
				AuthTokens.basic("neo4j", "12345678"));
	}

}
