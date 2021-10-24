package scrapers;
import java.util.regex.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeOS {
    public static String OSDetector() {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(os);
        if (os.contains("win")) {
            return "Win.exe";
        } else if (os.contains("nux") || os.contains("nix")) {
            return "Linux";
        } else if (os.contains("mac")) {
            return "Mac";
        } else {
            return "Other";
        }
    }

    public static String getVersionNumStr(String errMsg) {
        String[] msg = errMsg.split("\n");
        for (String line : msg) {
            if (!line.contains("browser version")) {
                continue;
            }
            System.out.println(line);
            Pattern pattern = Pattern.compile("[0-9]{2}"); // first 2 digits
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                return matcher.group(0);
            }
            
        }
        return null;
    }

}
