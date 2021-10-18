import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Map;

public class MongoDbProvider {

    private MongoClient mongoClient;

    /**
     * Build a MongoClient from hostname and port
     * @param hostname - for example, localhost
     * @param port - for example, 27017
     */
    public MongoDbProvider(String hostname, int port)
    {
        this.mongoClient = new MongoClient(hostname, port);
    }

    /**
     * Build a MongoClient from connection string
     * @param connectionString for example, mongodb://localhost:27017
     */
    public MongoDbProvider(String connectionString){
        MongoClientURI connectionStringURI = new MongoClientURI(connectionString);
        this.mongoClient = new MongoClient(connectionStringURI);
    }

    public MongoCollection<Document> getCollection(String database, String collection) {
        return this.mongoClient.getDatabase(database).getCollection(collection);
    }

    public void insert(Map<String, Object> data, String database, String collection)
    {
        Document doc = new Document(data);
        this.getCollection(database, collection).insertOne(doc);
    }
}
