import scrapers.*;
import processor.*;

public class PopulateDB {
    public static void main(String[] args) throws InterruptedException {

        // scrape india1 website to obtain updated xls files -> downloads:
            // - current year xls file
            // - past years xls file
        India1Scraper.scrapeIndia1();
        
        // scrape indo website and rename xls files -> downloads and renames:
            // - EXPORT_* (various oil product types)
            // - IMPORT_* (various oil product types)
        IndoScraper.ScrapeIndo();
        
        // process india1 xls files and populate db with india1 oil data
        India1Processor.processIndia1(new String[] {"./src/main/resources/PT_import.xls", "./src/main/resources/PT_import_H.xls"});

        // process indo xls files and populate db with indo oil data
        IndoProcessor.processAll();

    }

}
