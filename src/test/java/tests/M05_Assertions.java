package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class M05_Assertions {
    //Assert : iddia etmek demektir  / if yerine kullanilir
    // failed assertion dan sonraki satirlar calismaz

    int nummer1 = 1;
    int nummer2 = 2;
    int nummer3 = 3;

    WebDriver driver;


    @Test
    public void testing1 () {

        Assert.assertTrue(nummer2>nummer1);  // True oldugundan, parentez ici de true olmali 1>2 true, Test passed olur
        // dogru oldugunu iddia ediyoruz
        // Assert.assertTrue(nummer2<nummer1); bu hata verir

        Assert.assertFalse(nummer2<nummer1); // False oldugundan, parentez ici de false olmali 2<1 false, Test passed olur
        // yanlis oldugunu iddia ediyoruz
        // Assert.assertFalse(nummer2>nummer1); // bu hata verir

        Assert.assertEquals(nummer1,nummer1);         // Eguals oldugundan, parentez ici de equals olmali 1=1 true olur, Test passed olur
        // Assert.assertEquals(nummer1,nummer2);      // Eguals oldugundan, parentez ici de equals olmali 1!=2 false olur, Test failed olur
        // Esit oldugunu iddia ediyoruz

        Assert.assertNotEquals(nummer1,nummer2);      // NotEguals oldugundan, parentez ici de esit olmamali 1!=2 esit degil, Test passed olur
        // Assert.assertNotEquals(nummer1,nummer1);   // NotEguals oldugundan, parentez ici de esit olmamali 1=1 esit, Test failed olur


    }

    @Test
    public void testin2 () {
        Assert.assertEquals(nummer3, nummer2+nummer1); // Passed
        Assert.assertNotEquals(nummer3,nummer2); // Passed
        Assert.assertTrue(nummer1==nummer2);  // Failed, Bundan sonrakiler calismaz
        Assert.assertFalse(nummer1==nummer2); // Failed, Bundan sonrakiler calismaz, üstekki zaten failed oldugundan buna sira gelmez
    }



    @Test
    public void urlTest () {
        //sayfa url sinin https://www.bestbuy.com a esit oldugunu test edin
        driver.get("https://www.bestbuy.com");
        String expectedUrl = "https://www.bestbuy.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void titleTest () {
        // Sayfa baslaginin Rest icermedigini(contains) kontrol etme, olumsuz cümle : assertFalse
        driver.get("https://www.bestbuy.com");
        String expectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void logoTest () {
        // Bestbuylogosunun görüntülendigini test edin, olumlu cümle : assertTrue
        driver.get("https://www.bestbuy.com");
        WebElement logoBestbuy =driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoBestbuy.isDisplayed());

    }




    @After  // illa sonda yazilacak diye bir sart yok, nereye yazarsan yaz teslerden sonra calisir
    public void closed (){ // Her test metodundan(@Test) sonra calisir

        driver.close();
    }





























}
