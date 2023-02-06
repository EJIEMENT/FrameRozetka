package ui.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    protected WebDriver driver;

    public DriverManager() {
        this.driver = getWebDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void startDriver() {
        driver.get("https://rozetka.com.ua/");
    }

    public static WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito", "--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public void closeDriver() {
        driver.quit();
    }
}
