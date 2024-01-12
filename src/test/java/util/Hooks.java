package util;
import config.Configuration;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties properties;

    @Before
    public void before(){
        properties = ConfigReader.initialize_Properties();
        driver = Configuration.config();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        }
    }
    @After
    public void after(Scenario scenario){
        if(scenario.isFailed())
            Allure.addAttachment("Attachment",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

        driver.quit();
    }
}
