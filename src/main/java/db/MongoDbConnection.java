package db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import java.util.*;

public class MongoDbConnection {
    public static void connect() {

        // run cli commands/batch file using java

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        // MongoClient mongoClient = new MongoClient(); // local instance on default
        // port

        MongoDatabase database = mongoClient.getDatabase("is442Test"); // gets local db, creates one upon data insertion if db
                                                                // doesn't exist

        MongoCollection<Document> collection = database.getCollection("testCollection"); // gets collection -> similar to tables in
                                                                                // relational db

        List<Integer> books = Arrays.asList(27464, 747854);
        Document person = new Document("_id", "jo").append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St").append("city", "Faketon")
                        .append("state", "MA").append("zip", 12345))
                .append("books", books);
        
        
        collection.insertOne(person);
        System.out.println(person);
        collection.find();
    }
    

    // Convert json object/ java object to db objext
    // public static final DBObject toDBObject(Person person) {
    //     return new BasicDBObject("_id", person.getId())
    //                      .append("name", person.getName())
    //                      .append("address", new BasicDBObject("street", person.getAddress().getStreet())
    //                                                   .append("city", person.getAddress().getTown())
    //                                                   .append("phone", person.getAddress().getPhone()))
    //                      .append("books", person.getBookIds());
    // }
}