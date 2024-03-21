package dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.neo4j.driver.Bookmark;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Query;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionCallback;
import org.neo4j.driver.TransactionConfig;
import org.neo4j.driver.TransactionWork;
import org.neo4j.driver.Value;
import org.neo4j.driver.types.Node;

import com.google.gson.Gson;

import entity.Product;
import utils.ConvertEntity;

public class ProductDAO {
	private Driver driver;
	private SessionConfig sessionConfig;
	private Gson gson = new Gson();

	public ProductDAO() {
		driver = utils.ConnectDB.connectDB();
	}

	// Get all products
	public List<Product> getAllProducts() {
		String query = "MATCH (p:Product) RETURN p";

		try (Session session = driver.session()) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);

				return result.stream().map(record -> {
					Node node = record.get("p").asNode();
					return ConvertEntity.convertEntity(node, Product.class);
				}).toList();
			});
		}
	};

	// Get product by id
	public Product getProductById(String id) {
		String query = "MATCH (p:Product) WHERE p.productID = $id RETURN p";
		Map<String, Object> params = Map.of("id", id);

		try (Session session = driver.session()) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, params);
				return result.stream()
						.map(record -> ConvertEntity.convertEntity(record.get("p").asNode(), Product.class)).findFirst()
						.orElse(null);
			});
		}
	}

	// Add product
	public void addProduct(Product product) {
		String query = "CREATE (p:Product {productID: $productID, productName: $productName, unitPrice: $unitPrice, "
				+ "quantityPerUnit: $quantityPerUnit, unitsInStock: $unitsInStock,"
				+ "reOrderLevel: $reOrderLevel})";

		Map<String, Object> params = ConvertEntity.getParams(product, Product.class);
		try (Session session = driver.session()) {
			session.executeWrite(tx -> {
				tx.run(query, ConvertEntity.getParams(product, Product.class));
				return null;
			});
		}
	}
	
     // Update product
	public void updateProduct(Product product) {
		String query = "MATCH (p:Product) WHERE p.productID = $productID SET p.productName = $productName, p.unitPrice = $unitPrice, "
                + "p.quantityPerUnit = $quantityPerUnit, p.unitsInStock = $unitsInStock,"
                + "p.reOrderLevel = $reOrderLevel";

        Map<String, Object> params = ConvertEntity.getParams(product, Product.class);
        try (Session session = driver.session()) {
            session.executeWrite(tx -> {
                tx.run(query, ConvertEntity.getParams(product, Product.class));
                return null;
            });
        }
	}
	
	public void deleteProduct(String id) {
		String query = "MATCH (p:Product) WHERE p.productID = $productID DELETE p";
		Map<String, Object> params = Map.of("productID", id);
		try (Session session = driver.session()) {
			session.executeWrite(tx -> {
				tx.run(query, params);
				return null;
			});
		}
	}
	
//	Search all products by SupplierName
	public List<Product> searchProductBySupplierName(String companyName) {
	    String query = "MATCH (s:Supplier)-[:SUPPLIES]->(p:Product) WHERE s.companyName =$companyName RETURN p";
	    Map<String, Object> params = Map.of("companyName", companyName);

	    try (Session session = driver.session()) {
	        return session.executeRead(tx -> {
	            Result result = tx.run(query, params);
	            return result.stream()
	                    .map(record -> {
	                        Node node = record.get("p").asNode();
	                        return ConvertEntity.convertEntity(node, Product.class);
	                    })
	                    .toList();
	        });
	    }
	}
	
//	Find list of product with the high price
	public List<Product> findProductWithHighPrice() {
		String query = "MATCH (p:Product)\r\n"
				+ "WITH MAX(p.unitPrice) AS maxPrice\r\n"
				+ "MATCH (p:Product)\r\n"
				+ "WHERE p.unitPrice = maxPrice\r\n"
				+ "RETURN p";
		try (Session session = driver.session()) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream().map(record -> {
					Node node = record.get("p").asNode();
					return ConvertEntity.convertEntity(node, Product.class);
				}).toList();
			});
		}
	}

}
