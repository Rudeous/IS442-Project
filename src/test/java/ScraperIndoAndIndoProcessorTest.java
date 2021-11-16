import org.junit.jupiter.api.Test;
import processor.IndoProcessor;
import scrapers.IndoScraper;

public class ScraperIndoAndIndoProcessorTest {
    @Test
    void Test() throws InterruptedException {
        IndoScraper.ScrapeIndo(); //scrape and download excel file, rename files, fix file format
        IndoProcessor.processAll();//
    }
}
