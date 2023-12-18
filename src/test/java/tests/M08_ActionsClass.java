package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class M08_ActionsClass {

    // Action Class'i klavye  ve maus islemlerini yapmak icin olusturulmus bir siniftir

    static WebDriver driver;
    Actions actions;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }



    @Test
    public void doubleClick () {

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        // doubleClickButton.click(); bu tek tiklama yapiyor buna cift tiklama yapmamiz gerekiyor, ama bu
        // webelement metotlari icinde yok, bundan dolayi Actions class ini kullanmaliyiz

        actions = new Actions(driver); //Parametre olarak driver aliyor
        actions.doubleClick(doubleClickButton).perform(); // parametre olarak web elementini olani sectik

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String messageText = doubleClickMessage.getText();
        System.out.println(messageText);
    }

    @Test
    public void rightClick () {
        driver.get("https://demoqa.com/buttons");

        WebElement rightClickButton = driver.findElement(new By.ByCssSelector("#rightClickBtn")); //Css Selector de id
        actions = new Actions(driver); //Parametre olarak driver aliyor
        actions.contextClick(rightClickButton).perform(); // fare ile sag clik yapar

        WebElement rightClickMessage = driver.findElement(new By.ByCssSelector("#rightClickMessage")); //Css Selector de id
        String rightClickText = rightClickMessage.getText();
        System.out.println(rightClickText);

    }

    @Test
    public void test1() throws InterruptedException {

        //https://www.alibaba.com/?spm=a2700.7699653.0.0.7bc23e5f7N3QQV
        //cookies i kabul edin veya reddedin
        //shipto kismina giderek ulke olarak turkiye yi secelim ve kaydedelim
        //sayfanin en altina inerek dil olarak turkceyi secelim
        //categori kismina giderek tarim seceneginin ustune gelelim ve acilan yan sayfadan tarim ekipmanlarini secelim
        //tekrardan ilk sayfaya gecelim

        driver.get("https://www.alibaba.com/");
        String ilksayfahandle= driver.getWindowHandle();

        //cookies i kabul edin veya reddedin
        driver.findElement(By.xpath("//*[text()='Reject']")).click();

        //shipto kismina giderek ulke olarak turkiye yi secelim ve kaydedelim
        Actions actions=new Actions(driver);
        WebElement shipto= driver.findElement(By.xpath("(//label[@class='ellipsis'])[3]"));
        actions.moveToElement(shipto).clickAndHold(shipto).perform();

        Thread.sleep(1000);

        WebElement country= driver.findElement(By.xpath("//div[@data-role='select-country']"));
        actions.moveToElement(country).click(country).perform();

        Thread.sleep(1000);

        WebElement aramakutusu= driver.findElement(By.xpath("//input[@placeholder='Enter keyword to search.']"));
        actions.sendKeys(aramakutusu,"Turkey").perform();
        driver.findElement(By.xpath("(//li[@data-value='TR'])[1]")).click();
        driver.findElement(By.xpath("(//button[@data-role='save'])[3]")).click();

        Thread.sleep(2500);

        //sayfanin en altina inerek dil olarak turkceyi secelim
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Türk']")).click();

        //categori kismina giderek tarim seceneginin ustune gelelim ve acilan yan sayfadan tarim ekipmanlarini secelim
        WebElement kategori= driver.findElement(By.xpath("(//h3[@class='header-category-trigger'])[2]"));
        actions.moveToElement(kategori).clickAndHold(kategori).perform();

        WebElement tarim= driver.findElement(By.xpath("(//div[@class='title'])[33]"));
        actions.scrollToElement(tarim).clickAndHold(tarim).perform();

        WebElement tarimekipman= driver.findElement(By.xpath("(//*[text()='Tarım Ekipmanları'])[2]"));
        actions.moveToElement(tarimekipman).click(tarimekipman).perform();

        //tekrardan ilk sayfaya gecelim
        driver.switchTo().window(ilksayfahandle);

    }

    @Test
    public void bookingTest() throws InterruptedException {
        // https://www.booking.com/ sayfasina gidelim
        driver.get("www.booking.com/");
        driver.findElement(By.xpath("//*[text()='Accept']")).click();

        // para birimi olarak TL secelim
        Actions actions=new Actions(driver);
        WebElement paraBirimi= driver.findElement(By.xpath("(//button[@class='bui-button bui-button--light bui-button--large'])[1]"));
        actions.moveToElement(paraBirimi).click(paraBirimi).perform();
        actions.sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1500);
        WebElement turkishLira= driver.findElement(By.xpath("(//a[@class='bui-list-item bui-list-item--size-small '])[52]"));
        actions.moveToElement(turkishLira).click(turkishLira).perform();

        // ulke olarak Turkiye yi secelim
        WebElement language= driver.findElement(By.xpath("(//button[@class='bui-button bui-button--light bui-button--large'])[2]"));
        actions.moveToElement(language).click(language).perform();
        WebElement turkishLanguge= driver.findElement(By.xpath("//div[@lang='tr']"));
        actions.moveToElement(turkishLanguge).click(turkishLanguge).perform();

        // sayfanin en altindan ulkeler kismini secelim
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        WebElement ulkeler= driver.findElement(By.xpath("(//a[@data-ga='seoindexlinks'])[1]"));
        ulkeler.click();
        WebElement turkiye= driver.findElement(By.xpath("//*[@id=\"countryTmpl\"]/div[43]/div[1]/h2/a"));
        actions.scrollToElement(turkiye).click(turkiye).perform();

    }

















}
