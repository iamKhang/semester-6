package dao;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

import entity.Product;
import util.AppUtils;

public class ProductDao {
	private Driver driver;
	
	public ProductDao() {
		driver = AppUtils.getDriver();
	}
	
	public List<Product> listProductsByCategory(String categoryName) {
		String query = "MATCH  (p:Product)-[r:PART_OF]->(c:Category) where c.categoryName= $name RETURN p" ;
		Map<String, Object> pars = Map.of("name", categoryName);
		
		try (Session session = driver.session()) {

			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				return result.stream()
						.map(Record -> Record.get("p").asNode())
						.map(node -> AppUtils.nodeToPOJO(node, Product.class))
						.toList();
			});
		}
		
	}
	
	
	public Product findOne(String id) {
		
		String query = "MATCH (n:Product) WHERE n.productID= $id RETURN n";
		Map<String, Object> pars = Map.of("id", id);
		
		try(Session session = driver.session()){
			
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				
				if(!result.hasNext())
					return null;
				
			 	Record record = result.next();
				Node node = record.get("n").asNode();
				
				
				return AppUtils.nodeToPOJO(node, Product.class);
			});
		}
	}
	
	
	public void close() {
		driver.close();
	}
	
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		List<Product> products = dao.listProductsByCategory("Beverages");
		System.out.println(products.size());
		products.forEach(System.out::println);
		dao.close();
	}
	
}
