import org.junit.jupiter.api.Test;
import processor.Processor;

public class processorTest {

    @Test
    void Test() {
        // Processor.ProcessIndia1("./src/main/resources/PT_import.xls");
        // Processor.ProcessIndia1("./src/main/resources/PT_import_H.xls");
        Processor.processIndia1(new String[] {"./src/main/resources/PT_import.xls", "./src/main/resources/PT_import_H.xls"});
    }
}
