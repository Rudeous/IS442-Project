package scrapers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.JavascriptExecutor;
import processor.FileFormat;

import java.io.File;
import java.sql.Timestamp;
import java.time.Year;
import java.util.*;

//This java class will:
//- scrape indonesia website and download excel files from 2017 onwards BY product group
//- rename file names into import/export_productgroup
//- fix file format to .xls


public class IndoScraper {

    public static boolean checkElement(WebDriver driver, String className){
        try{
            driver.findElement(By.className(className)).isDisplayed();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    private static WebDriver getChromeDriver(String timeStampFolderName){
        // Set the path of the driver to driver executable.
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory",
                System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+timeStampFolderName); //specify relative
        // download path
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        // options.addArguments("--maximise");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options); // Create a Chrome Web Driver
        // driver.manage().window().maximize();
    }

    public static void ScrapeIndo() throws InterruptedException {
        //Folder Name for putting the scrapped excel files
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        String timeStampFolderName = timestamp.substring(0,timestamp.length()-4).replaceAll(":","-").replaceAll(" ",
                "__");

        //create folder to store downloads
        File theDir = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+timeStampFolderName);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        else{
            File anotherDir = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+timeStampFolderName+"(2)");
            anotherDir.mkdirs();
        }

        WebDriver driver = getChromeDriver(timeStampFolderName);

//        // Set the path of the driver to driver executable.
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe"); //relative path
//        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory",
//                System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+timeStampFolderName); //specify relative
//        // download path
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//        options.addArguments("--headless");
//        options.addArguments("--window-size=1920,1080");
//        // options.addArguments("--maximise");
//        WebDriver driver = new ChromeDriver(options); // Create a Chrome Web Driver
        // driver.manage().window().maximize();
        try{
            driver.get("https://www.bps.go.id/exim"); //navigate to website
            Thread.sleep(3000);
            driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
            Thread.sleep(1000);

            //Fill in form
            for (int radio=0;radio<2;radio++){
                Thread.sleep(300);
                WebElement radioButton = driver.findElement(By.id("radios_"+String.valueOf(radio)));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", radioButton);
                Thread.sleep(500);
                radioButton.click(); //Click import/export radio button
                Thread.sleep(500);
                driver.findElement(By.id("s2id_autogen1")).sendKeys("Kode HS");
                driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.ENTER);
                driver.findElement(By.id("s2id_autogen2")).sendKeys("Full HS");
                driver.findElement(By.id("s2id_autogen2")).sendKeys(Keys.ENTER);
                Thread.sleep(1000);

                WebElement yearInput = driver.findElement(By.id("s2id_autogen3")); //input year 2017 onwards
                yearInput.click();
                Thread.sleep(500);
                int currentYear = Year.now().getValue();
                while (currentYear!=2016){
                    yearInput.sendKeys(String.valueOf(currentYear));
                    Thread.sleep(500);
                    if (checkElement(driver,"select2-no-results")){
                        yearInput.sendKeys(Keys.ESCAPE);
                    }
                    else{
                        yearInput.sendKeys(Keys.ENTER);
                    }
                    currentYear--;
                }
                WebElement HSCodeInput = driver.findElement(By.id("s2id_autogen4")); //input HS Codes and generate by product group
                HSCodeInput.click();
                ArrayList<ArrayList<Integer>> HSCodeList = HSCodes.getList(); //get 2d list of HS Codes by product group
                for (ArrayList<Integer> productGroup : HSCodeList){
                    System.out.println("Downloading product group: "+productGroup);
                    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", HSCodeInput);
                    int backspaces = productGroup.size()*2;
                    for (int HSCode : productGroup){
                        HSCodeInput.sendKeys(String.valueOf(HSCode));
                        Thread.sleep(1000);
                        if (checkElement(driver,"select2-no-results")){ //check if HS code is valid
                            HSCodeInput.sendKeys(Keys.ESCAPE);
                        }
                        else{
                            HSCodeInput.sendKeys(Keys.ENTER);
                        }
                    }
                    Thread.sleep(500);
                    WebElement processButton = driver.findElement(By.xpath("//*[@id=\"btn-proses\"][1]"));
                    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", processButton);
                    Thread.sleep(500);
                    processButton.click();
                    Thread.sleep(5000);
                    if (driver.findElement(By.id("output")).getText()!="Data tidak ditemukan"){ //check search results is empty
                        driver.findElement(By.xpath("//*[@id=\"output\"]/table/tbody/tr[2]/td[1]/select")).click();
                        driver.findElement(By.xpath("//*[@id=\"output\"]/table/tbody/tr[2]/td[1]/select/option[2]")).click();
                        WebElement excelButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/input"));
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center', " +
                                "inline: 'nearest'});", excelButton); //download excel
                        excelButton.click();
                        Thread.sleep(1000);

                    }
                    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", HSCodeInput);
                    for (int i=0;i<backspaces;i++){
                        Thread.sleep(500);
                        HSCodeInput.sendKeys(Keys.BACK_SPACE);
                    }
                }
            }
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("Web Driver closing");
            driver.close();
            //rename files to product group
            FileFunction.renameFiles(timeStampFolderName); //todo
            FileFormat.change_file_format(timeStampFolderName);//todo
            Thread.sleep(20000);
        }

    }
}