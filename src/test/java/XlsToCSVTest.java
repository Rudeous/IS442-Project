import org.junit.jupiter.api.Test;
import processor.XlsxtoCSV;

import java.io.File;

public class XlsToCSVTest {
    // @Test
    void convert() {
        // int i=0;
        // reading file from desktop
        File inputFile = new File("./src/main/resources/PT_import.xls"); //provide your path
        // writing excel data to csv
        File outputFile = new File("./src/test/resources/PT_import.csv");  //provide your path
        XlsxtoCSV.xlsx(inputFile, outputFile);
        System.out.println("Conversion of " + inputFile + " to flat file: "
                + outputFile + " is completed");
    }
}
