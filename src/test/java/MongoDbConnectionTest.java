import org.junit.jupiter.api.Test;
import db.MongoDbConnection;

public class MongoDbConnectionTest {
    @Test
    void Test() {
        MongoDbConnection.connect();
    }
}
