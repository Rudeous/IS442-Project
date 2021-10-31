import org.junit.jupiter.api.Test;
import processor.IndoProcessor;
import selenium.ScrapperIndo;

public class ScraperIndoAndIndoProcessorTest {
    @Test
    void Test() throws InterruptedException {
        ScrapperIndo.ScrapeIndo(); //scrape and download excel file, rename files, fix file format
        IndoProcessor.processAll();//
    }
}
