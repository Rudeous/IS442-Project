import org.junit.jupiter.api.Test;

public class MongoDbTest {
    // @Test
    void Test() {
        MongoDbProvider provider1 = new MongoDbProvider("mongodb:localhost:27017");
        MongoDbProvider provider2 = new MongoDbProvider("localhost", 27017);

    }
}
