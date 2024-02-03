package demo;

import java.util.List;

public class ObjectModelAPIDemo {
	public static void main(String[] args) {
		
		List<Person> list = List.of(
					new Person("Ti", "Le", 20, new Address("12 nguyen Van Bao", "P4", "GV HCM", 10000)),
					new Person("Le", "Le", 23, new Address("12455 nguyen Van Bao", "P4", "GV HCM", 10000))
				);
		
		JsonHandler.toFile(list, "data/people.json");
		
//		Person p = JsonHandler.fromFile("data/person.json");
//		System.out.println(p);
		
	
//		try(
//				JsonReader reader = Json.createReader(
//						new FileReader("data/person.json"));
//				){
			
//			reader.readObject()
//			.entrySet()
//			.forEach(entry -> {
//				System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
//			});
			
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}

//Checked Exception
//Unchecked Exception --> RuntimeException
