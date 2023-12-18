package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class M09_DynamicElement {

    // Dynamic Element sayfa her yenilendiginde locateri(id si) degisen element tir
    // eger elemente 3 atturibute varsa bunlarin 1 id 2 si baska ise ve bu 2 atturibute birden fazla element icin
    // ayni ve id de her sayfa yenilenmesinde degisiyorsa elementi nasil bulacaksin
    // böyle bir durumda sayfa her yenilendiginde test eski locater i bulamadigindan hata verir
    // bunlarin nasil handle edildigini bilmen gerekir
    // (elementin satirina kadar inilip xpath ile bulunur / start-with ve text kullanilir)
    // genelde güvenlik icin elementler bdynemic sekilde kullanilir


    static WebDriver driver;
    Actions actions;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void dynamicButton () {

        driver.get("https://demoqa.com/buttons");

        //    dynamic elementi xpyth ile locater i
        //   //div/button[starts-with(text(), 'Click Me')] bu sekilde kullandiginda = Text() den sonra virgül
        //   //div/button[(text() = 'Click Me')]  bu sekilde kullandiginda = Text() den sonra esittir (denenmedi kodda dene)
        //   //div/button   burada button not unu kadar indik bundan 3 tane var ve bizim elementimiz sonuncu
        //   söyle de elementi bulabiliriz //div[last()]/button  last() i button dan önce kullaninca bize son button u getirir

        WebElement dynamicClickButton = driver.findElement(By.xpath("//div/button[starts-with(text(), 'Click Me')]"));
        dynamicClickButton.click();

    }



    @Test
    public void dynamicText () {

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement dynamicText = driver.findElement(By.xpath("//div/p"));
        //div altinda p olan element sadece bu ondan böyle bulabildik ikinci bir p satiri olsaydi
        // x-path i devam ettirmeliyidik, text üzerinden devam edebilirdik
        System.out.println(dynamicText.getText());

    }

    @Test
    public void dynamicEnableAfter () {
        //etkin olmasi icin belli bir süre gecmesi gerekiyor, ondan önce gözükmüyor

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement enableAfterButton = driver.findElement(By.id("enableAfter"));
        // element sayfa acildiginda disable yani tiklanilabilir degil 5 saniye sonra aktif/enable oluyor
        // bunun icin driver i element gözükene kadar bekletmeliyiz

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // iki parametre alan bir WebDriverWait objesi olusturduk 10 sn bekle dedik

        driverWait.until(ExpectedConditions.elementToBeClickable(enableAfterButton));

        //(sayfa acildiginda 10 saniye beklenecek) sonra tiklanabilir oldugunda tiklama
        // yapacak 10 sn beklemesine gerek yok eger yukaridaki satiri yazmazsan
        // enableAfterButton.click(); i yazman gerekecek ama burada sürenin sonuna kadar bekler


    }



    @Test
    public void dynamicColorChange () {
        //Sinif ismi 5 sn sonra degisiyor, her sayfa yenilendiginde

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement colorChange = driver.findElement(By.id("colorChange"));
        String classValueBefore = colorChange.getAttribute("class");
        System.out.println("Before Value = " + classValueBefore);


        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.attributeToBe(colorChange, "class", "mt-4 text-danger btn btn-primary"));
        String classValueAfter = colorChange.getAttribute("class");
        System.out.println("After Value = " + classValueAfter);

    }


    @Test
    public void dynamicVisibleAfter() {
        // ilk basta gözükmeyen belli bir süre sonra gözüken bir button, kodlarida DOM a sonra düsüyor
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        WebElement visibleAfter = driver.findElement(By.id("visibleAfter"));
        // burayi ilk satirda yazarsak hemen hata aliriz (cünkü hemen element gözükmüyor)

        visibleAfter.click();
    }































}
