package pageObjects;
import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class LoginPagePOM {

    By usernameTxt = By.cssSelector("input[id='parolaSertifikaAccordion:uForm:txtUKullaniciAdi']");

    By passwordTxt = By.cssSelector("input[id='loginUSifre']");

    By loginBtn = By.cssSelector("button[id='parolaSertifikaAccordion:uForm:girisYapButton']");

    By demoBttn = By.cssSelector("div[id='menu'] li:nth-child(1)");

    By warningBttn = By.cssSelector("button[id='tasviyeSuresiGecmisUyariMesajiDialogEvetBtn']");



    ElementHelper elementHelper;
    WebDriver driver;

    public LoginPagePOM(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
        this.driver = driver;
    }

    public void enterUsernamePassword(String username, String password) throws InterruptedException {
        Thread.sleep(500);
        elementHelper.runWithJavaScript(demoBttn);
        elementHelper.click(demoBttn);
        Thread.sleep(500);

        elementHelper.sendKey(usernameTxt, username);

        elementHelper.sendKey(passwordTxt, password);
    }
    public void loginBtn() {

        elementHelper.checkElementVisible(loginBtn);
        elementHelper.runWithJavaScript(loginBtn);
    }
    public void loginPagePOMDisplayed() {

        elementHelper.checkElementVisible(usernameTxt);
        elementHelper.checkElementVisible(passwordTxt);
        elementHelper.checkElementVisible(loginBtn);
    }

    public void login() throws InterruptedException {

        this.enterUsernamePassword(Configuration.getUsername(), Configuration.getPassword());
        this.loginBtn();
    }
    public void warningClose(){
        if(driver.findElements(warningBttn).size() != 0){
            elementHelper.runWithJavaScript(warningBttn);
        }
    }
}
