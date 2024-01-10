package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class H01_ActionsClass {
    /*
            kullanici "https://www.migros.com.tr/" sitesine gider
            kullanici coocies kabul eder
            kullanici uyariyi kabul eder
            kullanici sayfa altindaki migros logosunu gorur
            kullanici searchBox'in gorundugunu dogrular
            kullanici searchBox'a tiklar
            kullanici searchBox'a "RİZE ÇAYIVVV" yazar ardindan duzeltip arama yapar
            kullanici"RİZE ÇAYI" yazan urunlerin goruntulendigini dogrular

     */


    WebDriver driver;
    Actions actions;

    @Test
    public void actions() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);


        //kullanici "https://www.migros.com.tr/" sitesine gider
        driver.get( "https://www.migros.com.tr/");

        //kullanici coocies kabul eder
        WebElement cookies= driver.findElement(By.id("accept-all"));
        cookies.click();

        //kullanici uyariyi kabul eder
        WebElement uyari= driver.findElement(By.xpath("(//fa-icon[@class='ng-fa-icon'])[1]"));
        uyari.click();
        wait(2);










    }












}



