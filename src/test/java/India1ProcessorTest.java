import org.junit.jupiter.api.Test;
import processor.India1Processor;

public class India1ProcessorTest {

    @Test
    void Test() {
        // Processor.ProcessIndia1("./src/main/resources/PT_import.xls");
        // Processor.ProcessIndia1("./src/main/resources/PT_import_H.xls");
        India1Processor.processIndia1(new String[] {"./src/main/resources/PT_import.xls", "./src/main/resources/PT_import_H.xls"});
    }
}
