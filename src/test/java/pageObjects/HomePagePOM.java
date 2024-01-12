package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.ElementHelper;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class HomePagePOM {


    By evrkIsBttn  = By.cssSelector("button[id='topMenuForm2:ust:0:ustMenuEleman']");

    By evrkOlstrBttn = By.cssSelector("a[aria-label='(Shift + E)']");

    By deleteIcn   = By.cssSelector("button[id*='yeniGidenEvrakForm'] span[class*='delete-icon']");

    By konuKod     = By.cssSelector("input[id='yeniGidenEvrakForm:evrakBilgileriList:1:konuKoduLov:LovText']");

    By konuList    = By.cssSelector("div[class='expandCollapseLovItem ']");

    By eklenecekKlsrInpt = By.cssSelector("input[id='yeniGidenEvrakForm:evrakBilgileriList:4:eklenecekKlasorlerLov:LovText']");

    By eklenecekKlasorClose   = By.cssSelector("button[id*='eklenecekKlasorlerLov:lovTreePanelKapat']");

    By trksat2a    = By.xpath("//*[@id='yeniGidenEvrakForm:evrakBilgileriList:4:eklenecekKlasorlerLov:lovTree:0']");

    By imzaciEkle = By.cssSelector("button[id='yeniGidenEvrakForm:evrakBilgileriList:21:onayAkisiEkle']");

    By imzaOpt  = By.cssSelector("select[id='yeniGidenEvrakForm:evrakBilgileriList:21:akisAdimLov:LovSecilenTable:0:selectOneMenu']");

    By gerekInpt   = By.cssSelector("input[id='yeniGidenEvrakForm:evrakBilgileriList:18:geregiLov:LovText']");

    By gerekListSlct = By.cssSelector("li[id='yeniGidenEvrakForm:evrakBilgileriList:18:geregiLov:lovTree:0_0']");

    By kllnImzaBttn = By.cssSelector("button[id='yeniGidenEvrakForm:evrakBilgileriList:21:anlikAkisKullanButton']");

    By geregiClose = By.cssSelector("button[id*='geregiLov:lovTreePanelKapat']");

    By editorBttn = By.cssSelector("button[id='yeniGidenEvrakForm:leftTab:uiRepeat:1:cmdbutton']");

    By hitapBttn = By.cssSelector("div[id='yeniGidenEvrakForm:hitapInplace'] button[style*='height: 24']");

    By hitapInpt = By.cssSelector("input[id*='hitapEkInplaceTextId']");

    By hitapFrame = By.cssSelector("div[id='yeniGidenEvrakForm:D1Editor'] iframe");

    By contentBody = By.cssSelector("body[contenteditable='true']");

    By hitapOK = By.cssSelector("div[id*='yeniGidenEvrakForm'] button[onclick*='yeniGidenEvrakForm:hitapInplace']");

    By dosyaAciklaTxt = By.cssSelector("textarea[id*='dosyaAciklama']");

    By ekFileInpt = By.cssSelector("input[id='yeniGidenEvrakForm:evrakEkTabView:fileUploadButtonA_input']");

    By eklerSwitch = By.cssSelector("button[id='yeniGidenEvrakForm:leftTab:uiRepeat:2:cmdbutton']");

    By ekleBttn = By.cssSelector("button[id='yeniGidenEvrakForm:evrakEkTabView:dosyaEkleButton']");

    By imzala = By.cssSelector("button[id='yeniGidenEvrakForm:rightTab:uiRepeat:2:cmdbutton']");

    By simza = By.cssSelector("label[id='imzalaForm:c']");

    By sayisalImzala = By.cssSelector("button[id='imzalaForm:sayisalImzaConfirmDialogOpener']");

    By imzalaEvet = By.cssSelector("button[id='imzalaForm:sayisalImzaConfirmForm:sayisalImzaEvetButton']");

    By islemYaptiklarim = By.cssSelector("div[id='leftMenuForm:leftMenuIslemYaptiklarim']");

    By imzaladiklarim = By.cssSelector("a[onclick*='leftMenu.islemYaptiklarim.imzaladiklarim']");

    By sonImzalanan = By.cssSelector("table[id='mainInboxForm:inboxDataTable:0:evrakTable'] div[style='width:20%; float:left; text-align: right;']");

    By birimEvraklari = By.cssSelector("div[id='leftMenuForm:leftMenuBirimEvraklari']");

    By teslimAlinmayiBek = By.cssSelector("a[onclick*='teslimAlinmayiBekleyenler']");






    ElementHelper elementHelper;
    WebDriver driver;

    public HomePagePOM(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
        this.driver = driver;
    }

    public void navigateEvrakOlstr() throws InterruptedException {
        Thread.sleep(500);
        elementHelper.runWithJavaScript(evrkIsBttn);
        Thread.sleep(1500);

        elementHelper.runWithJavaScript(evrkOlstrBttn);

        Thread.sleep(2500);
    }

    public void fillDocument() throws  InterruptedException {

        if(driver.findElements(deleteIcn).size() != 0){
            Thread.sleep(500);
            elementHelper.runWithJavaScript(deleteIcn);
        }
        Thread.sleep(1500);

        elementHelper.sendKey(konuKod,"kültürel ve");
        elementHelper.checkElementVisible(konuList);
        elementHelper.runWithJavaScript(konuList);
        Thread.sleep(2500);
        elementHelper.sendKey(eklenecekKlsrInpt,"türksat");
        Thread.sleep(3700);
//        elementHelper.checkElementVisible(trksat2a);
        try {
            elementHelper.click(trksat2a);
        }catch (org.openqa.selenium.StaleElementReferenceException ex){
            By trksat2a1    = By.xpath("//*[@id='yeniGidenEvrakForm:evrakBilgileriList:4:eklenecekKlasorlerLov:lovTree:0']");
            elementHelper.click(trksat2a1);
        }

        Thread.sleep(1000);
        elementHelper.runWithJavaScript(eklenecekKlasorClose);
        elementHelper.runWithJavaScript(eklenecekKlasorClose);
        Thread.sleep(2500);
        elementHelper.sendKey(gerekInpt,"Alt test");
        Thread.sleep(2500);
        elementHelper.click(gerekListSlct);
        Thread.sleep(500);
        elementHelper.click(geregiClose);
        Thread.sleep(500);
        elementHelper.click(imzaciEkle);
        Thread.sleep(2500);

        Select signer = new Select(driver.findElement(imzaOpt));

        signer.selectByVisibleText("İmzalama");

        elementHelper.runWithJavaScript(kllnImzaBttn);
        Thread.sleep(4000);



    }

    public void switchEditor() throws InterruptedException {
        elementHelper.click(editorBttn);
       Thread.sleep(4000);
   }

    public void fillEditor() throws InterruptedException {
        elementHelper.click(hitapBttn);
        Thread.sleep(1500);
        elementHelper.sendKey(hitapInpt,"BU BİR TESTTİR");
        Thread.sleep(500);
        elementHelper.click(hitapOK);
        Thread.sleep(500);


        driver.switchTo().frame(driver.findElement(hitapFrame));

        List<WebElement> list = elementHelper.findElements(contentBody);

        list.get(0).sendKeys("test test test");
       Thread.sleep(2000);
        driver.switchTo().defaultContent();

   }

    public void switchEkler() throws InterruptedException {

        elementHelper.runWithJavaScript(eklerSwitch);
        Thread.sleep(500);


   }

    public void attachmentAdd() throws InterruptedException {
        elementHelper.sendKey(dosyaAciklaTxt,"test test test test");
        Thread.sleep(2000);
       String filePath = System.getProperty("user.dir");
       System.out.println(filePath);

       driver.findElement(ekFileInpt).sendKeys(filePath+ "\\turksat-logo.png");
       Thread.sleep(5000);
       elementHelper.click(ekleBttn);
       Thread.sleep(2000);

   }

    public void signWithSimza() throws InterruptedException {

        elementHelper.click(imzala);
        Thread.sleep(1000);
        elementHelper.click(simza);
        Thread.sleep(1500);
        elementHelper.click(sayisalImzala);
        Thread.sleep(1500);
        elementHelper.click(imzalaEvet);
        Thread.sleep(3500);

    }

    public void checkImzaTeslim() throws InterruptedException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        elementHelper.click(islemYaptiklarim);
        Thread.sleep(1000);
        elementHelper.click(imzaladiklarim);

        if(time.equals(elementHelper.getText(sonImzalanan))){
            System.out.println(time + " " + elementHelper.getText(sonImzalanan));
        }else{
            Assert.fail( time + " " + elementHelper.getText(sonImzalanan)+" İmzaladıklarımda bulunamadı");
        }
        Thread.sleep(2345);

        elementHelper.click(birimEvraklari);
        Thread.sleep(2000);
        elementHelper.click(teslimAlinmayiBek);
        Thread.sleep(2000);


        if(time.equals(elementHelper.getText(sonImzalanan))){
            System.out.println(time + " " + elementHelper.getText(sonImzalanan));
        }else{
            Assert.fail( time + " " + elementHelper.getText(sonImzalanan)+" TESLİM Alınmayı bekleyenlerde bulunamadı");
        }

    }



}
