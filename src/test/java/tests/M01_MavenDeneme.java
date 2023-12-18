package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class M01_MavenDeneme {


    static WebDriver driver;
    Actions actions;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.de/");

        //cookeies onaylama
        WebElement cookeiesAkzeptieren = driver.findElement(By.xpath("//input[@id=\"sp-cc-accept\"]"));
        cookeiesAkzeptieren.click();

        // arama kutusu
        WebElement searchButtun = driver.findElement(
                By.xpath("//input[@id=\"twotabsearchtextbox\"]"));

        //java aratma
        searchButtun.sendKeys("Java" + Keys.ENTER);

        //arama sonucu
        WebElement searchResultNumber = driver.findElement(
                By.xpath("//span[contains(*, '1-16 von mehr als 30.000' )]"));
        System.out.println("arama sonucu = " + searchResultNumber.getText());

        // arama sonucu sayisinin 100 den büyük oldugunu test etme
        String searchResultNumberStr = searchResultNumber.getText();

/*
        searchResultNumberStr = searchResultNumberStr.substring(
                (searchResultNumberStr.indexOf("als")+3),  //Burada prolem var Strin icindeki degeri alamadim
                (searchResultNumberStr.indexOf("Ergebnissen")-11));

 */

        String searchResultNumberStr2 = searchResultNumberStr.substring(
                searchResultNumberStr.indexOf("als") + 4, //bosluga dikkat
                searchResultNumberStr.indexOf("Ergebnissen") - 1);

        System.out.println("arama sonucunun String olarak sayisi = " + searchResultNumberStr2);


        if (Integer.parseInt(searchResultNumberStr2) > 100) {
            System.out.println("testPassed");
        } else {
            System.out.println("testFailed");
        }

        driver.navigate().back();

    }


}
