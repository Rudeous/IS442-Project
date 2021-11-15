import java.io.IOException;

import org.junit.jupiter.api.Test;
import db.MongoDbConnect;
import db.RunDbScripts;

public class MongoDbBatchFileTest {
    @Test
    void Test() throws IOException{
        RunDbScripts.runBatchFile();
    }
}
