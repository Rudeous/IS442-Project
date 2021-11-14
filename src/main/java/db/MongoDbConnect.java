package db;
import scrapers.ChromeOS;
import db.RunDbScripts;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.mongodb.*;
import org.bson.*;
import org.json.JSONObject;

import java.util.*;
// import com.mongodb.client.model.Filters.*;

public class MongoDbConnect {
    public static MongoCollection<Document> connect(String dbName, String collectionName) {

        // check os to run windows bat or mac bash file
        // ISSUE: unable to start a background subthread while main process continues to run?
        String osType = ChromeOS.OSDetector();
        switch (osType) {
            case "windows":
                System.out.println("reached 1");
                RunDbScripts.runBatchFile();
                System.out.println("reached 2");
                break;
            
            case "mac":
                RunDbScripts.runBashScript();
                break;

        }
        // mongodb server is up and running in the background

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        // MongoClient mongoClient = new MongoClient(); // local instance on default
        // port

        MongoDatabase database = mongoClient.getDatabase(dbName); // gets local db, creates one upon data insertion if db
                                                                // doesn't exist

        MongoCollection<Document> collection = database.getCollection(collectionName); // gets collection -> similar to tables in
                                                                                // relational db
        
        return collection;
    }
    
    public static void insert(JSONObject jsonobj, String dbName, String collectionName) {
        MongoCollection<Document> collection = connect(dbName, collectionName);

        Document doc = Document.parse(jsonobj.toString());
        if (collection.find(doc).first()!=null) { // drop if document with same key already exists in db
            System.out.println(collection.find(doc));
            collection.deleteOne(doc);
        }
        collection.insertOne(doc);

        // jsonobj.keys().forEachRemaining(key -> {
        //     Document doc = Document.parse( jsonobj.toString() );
        //     if (collection.find(doc).first()!=null) { // drop if document with same key already exists in db
        //         System.out.println(collection.find(doc));
        //         collection.deleteOne(doc);
        //     }
        //     collection.insertOne(doc);
        // });
    }

    public static JSONObject retrieve(String collectionName, String dbName) {
        MongoCollection<Document> collection = connect(dbName, collectionName);
        
        Document doc = collection.find().first();
        JSONObject jObject = new JSONObject(doc.toJson());
        return jObject;
    }
}