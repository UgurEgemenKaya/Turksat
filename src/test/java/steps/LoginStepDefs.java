package steps;


import config.Configuration;
import io.cucumber.java.en.Given;
import pageObjects.LoginPagePOM;

public class LoginStepDefs {
    LoginPagePOM loginpage = new LoginPagePOM(Configuration.getDriver());


    @Given("Authorized user has logged in.")
    public void authorizedUserHasLoggedIn() throws InterruptedException {
        loginpage.login();
        Thread.sleep(7500);

        loginpage.warningClose();
        Thread.sleep(500);

    }
}
