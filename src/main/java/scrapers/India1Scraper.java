<<<<<<< HEAD:src/main/java/scrapers/India1Scraper.java
package scrapers;
=======
package demo.selenium;
>>>>>>> Thymeleaf,-Chart.js:src/main/java/demo/selenium/Scraper.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.SessionNotCreatedException;

<<<<<<< HEAD:src/main/java/scrapers/India1Scraper.java

=======
>>>>>>> Thymeleaf,-Chart.js:src/main/java/demo/selenium/Scraper.java
import java.util.*;


public class India1Scraper {

    public static void scrapeIndia1() throws InterruptedException {

        // config
        String dlPath = "/src/main/resources";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", dlPath);
        chromeOptions.setExperimentalOption("prefs", prefs);

        String chromeVer = "95";
        WebDriver driver = null;
        try {
            System.out.println(ChromeOS.OSDetector());
            String chromePath = "src/main/resources/chromedrivers/" + chromeVer + "/" + ChromeOS.OSDetector();
            System.out.println(chromePath);
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver(chromeOptions);
        } catch(SessionNotCreatedException e){
            String errorMsg = e.getMessage();
            chromeVer = ChromeOS.getVersionNumStr(errorMsg);
            String chromePath = "src/main/resources/chromedrivers/" + chromeVer + ChromeOS.OSDetector();
            System.out.println(chromePath);
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver(chromeOptions);
        }



        // driver.get("http://www.google.com");
        String baseURL = "https://www.ppac.gov.in/content/212_1_ImportExport.aspx";
        driver.get(baseURL); // go to webpage to scrape (India 1)
        System.out.println(driver.getTitle());

        // pinpoint set of category (h5), file list (ul) that Quantity belongs to (don't need Rupees, Dollars)
        List<WebElement> dataCategoryList = driver.findElements(By.xpath("//div[@class='function']//h5"));
        int quantityIndex = 0;
        for  (int i=0; i < dataCategoryList.size(); i++) {
            WebElement dataCat = dataCategoryList.get(i);
            if ( dataCat.getText().contains("Quantity")|dataCat.getText().contains("quantity") ) {
                quantityIndex=i+1; // xpath indexes start from 1
                break;
            }
        }

        // use index obtained to interate through list of href nodes and get quantity excel files
        List<WebElement> fileDivList = driver.findElements(By.xpath(String.format("//div[@class='function']//ul[%d]//a", quantityIndex)));
        for(WebElement fileDiv: fileDivList){
            String href = fileDiv.getAttribute("href");
            System.out.println(href);
            driver.get(href);
            Thread.sleep(10000);
        }

        driver.close();
    }
    



}
