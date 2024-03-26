package dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Category;
import utils.ConnectDB;
import utils.ConvertEntity;

public class CategoryDAO {
	private Driver driver;
//	private SessionConfig sessionConfig;

	public CategoryDAO() {
		driver = ConnectDB.connectDB();
//		sessionConfig = SessionConfig.builder().withDatabase("northwind").build();
	}

	public void addCategory(Category category) {
		String query = "Create (c:Category {categoryID: $categoryID, " + "categoryName: $categoryName, "
				+ "description: $description," + "picture: $picture})";
		Map<String, Object> pars = ConvertEntity.getProperties(category);
		try (Session session = driver.session()) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}

	public void removeCategory(String categoryID) {
		String query = "Match (c:Category {categoryID: $categoryID}) Delete c";
		try (Session session = driver.session()) {
			session.executeWrite(tx -> {
				return tx.run(query, Map.of("categoryID", categoryID)).consume();
			});
		}
	}

//	Find category by categoryID
	public Category findCategory(String categoryID) {
		String query = "Match (c:Category {categoryID: $categoryID}) Return c";
        Map<String, Object> pars = Map.of("categoryID", categoryID);
        try(Session session = driver.session()) {
			return (Category) session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if(!result.hasNext()) {
					return 0;
				}
				return result.stream().map(record -> {
					Node node = record.get("c").asNode();
					return ConvertEntity.convertEntity(node, Category.class);
				}).findFirst();
			});
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
    
	}

}
