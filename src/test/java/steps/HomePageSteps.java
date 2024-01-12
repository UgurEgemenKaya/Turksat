package steps;

import config.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePagePOM;
import pageObjects.LoginPagePOM;

public class HomePageSteps {

    HomePagePOM homepage = new HomePagePOM(Configuration.getDriver());
    LoginPagePOM loginpage = new LoginPagePOM(Configuration.getDriver());

    @When("User clicks on Evrak Isleri at Home Page")
    public void userClicksOnEvrakIsleriAtHomePage() throws InterruptedException {
        homepage.navigateEvrakOlstr();
    }

    @And("Fills out all necessary fields in Bilgileri tab")
    public void fillsOutAllNecessaryFieldsInBilgileriTab() throws InterruptedException {
        homepage.fillDocument();
    }

    @And("Switches in to Editor tab")
    public void switchesInToEditorTab() throws InterruptedException {
        homepage.switchEditor();
    }

    @And("Fills all necessary fields in Editor tab")
    public void fillsAllNecessaryFieldsInEditorTab() throws InterruptedException {
        homepage.fillEditor();
    }

    @And("Switches in to Ekler tab")
    public void switchesInToEklerTab() throws InterruptedException {
        homepage.switchEkler();
    }

    @And("Adds new attachment")
    public void addsNewAttachment() throws InterruptedException {
        homepage.attachmentAdd();
    }

    @And("Signs the document with S imza")
    public void signsTheDocumentWithSImza() throws InterruptedException {
        homepage.signWithSimza();

    }

    @Then("Checks for the document in the Imzaladiklarim and Teslim alinmayi bekleyenler")
    public void checksForTheDocumentInTheImzaladiklarimAndTeslimAlinmayiBekleyenler() throws InterruptedException {
        homepage.checkImzaTeslim();
    }

    @Then("checks all the required {string} exists")
    public void checksAllTheRequiredExists(String arg0) {
    }
}
