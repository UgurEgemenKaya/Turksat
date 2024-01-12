package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class Configuration {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions act;
    static String username;
    static String password;


    public static WebDriver config(){
        Properties properties= ConfigReader.getProperties();

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        //options.addArguments("--disable-dev-shm-usage");


        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver(options);

        String url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        int timeout = Integer.parseInt(properties.getProperty("timeOutInSeconds"));
        driver.get(url);
//        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        act = new Actions(driver);
        return getDriver();
    }
    public static WebDriver getDriver(){return driver;}
    public static WebDriverWait getWait(){return wait;}
    public static Actions getAct(){return act;}
    public static String getUsername(){return username;}
    public static String getPassword(){return password;}

}
