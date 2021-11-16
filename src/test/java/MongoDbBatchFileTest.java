import java.io.IOException;

import org.junit.jupiter.api.Test;
import db.RunWindowsDbScripts;

public class MongoDbBatchFileTest {
    @Test
    void Test() throws IOException{
        RunWindowsDbScripts.runBatchFile();
    }
}
