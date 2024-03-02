package demo;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.JsonWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

  public static Person fromFile(String fileName) {
    Person p = null;

    Address add = null;

    try (JsonReader reader = Json.createReader(new FileReader(fileName));) {
      System.out.println(reader);
      JsonObject jo = reader.readObject();
      if (jo != null) {
        p = new Person();
        p.setFirstName(jo.getString("firstName"));
        p.setLastName(jo.getString("lastName"));
        p.setAge(jo.getInt("age"));

        JsonObject joAdd = jo.getJsonObject("address");

        add = new Address();
        add.setStreetAddress(joAdd.getString("streetAddress"));

        p.setAddress(add);

        JsonArray ja = jo.getJsonArray("phoneNumbers");
        List<PhoneNumber> phones = new ArrayList<>();

        for (JsonValue jv : ja) {
          JsonObject joPh = (JsonObject) jv;
          PhoneNumber ph = new PhoneNumber(
            joPh.getString("type"),
            joPh.getString("number")
          );
          phones.add(ph);
        }

        p.setPhoneNumbers(phones);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return p;
  }

  public static void toFile(List<Person> persons, String fileName) {
    try (JsonWriter writer = Json.createWriter(new FileWriter(fileName));) {
      JsonArrayBuilder aBuilder = Json.createArrayBuilder();
      JsonObjectBuilder oBuilder = Json.createObjectBuilder();

      for (Person p : persons) {
        Address add = p.getAddress();
        JsonObject joAdd = oBuilder
          .add("name", add.getStreetAddress())
          .add("city", add.getCity())
          .build();

        JsonObject jo = oBuilder
          .add("firstName", p.getFirstName())
          .add("lastName", p.getLastName())
          .add("age", p.getAge())
          .add("address", joAdd)
          .build();

        aBuilder.add(jo);
      }

      JsonArray ja = aBuilder.build();
      writer.write(ja);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
//autoboxing
//unboxing
//upcasting
//downcasting
