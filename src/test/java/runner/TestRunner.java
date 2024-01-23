package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps","util"},
        tags = "@Turksat",
        plugin= {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeTest
    public void beforeTest() {
        try {
            FileUtils.deleteDirectory(new File("allure-results"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void afterTest(){
        try {
            Runtime.getRuntime().exec("cmd /c start \" \" allure serve allure-results");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
