import org.junit.jupiter.api.Test;
import db.MongoDbConnect;

import java.util.Iterator;

import org.json.*;

public class RetrieveIndoDataTest {
    @Test
    void retrieveIndoTest() {
        JSONObject jObject = MongoDbConnect.retrieve("IndoOilData", "IS442");
        System.out.println(jObject);
        Iterator<String> keys = jObject.keys();
        
        while(keys.hasNext()) {
            String key = keys.next();
            if (!key.equals("_id")) {
                // check all keys not equal to document id
                System.out.println(key);
            }
        }
    }
}
