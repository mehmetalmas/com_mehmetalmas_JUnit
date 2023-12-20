package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class M12_Upload {

    WebDriver driver;
    Actions actions;


    @Before
    public void setUP () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void upLoad() {

        driver.get("https://demoqa.com/upload-download");
        WebElement uploadElement = driver.findElement(By.xpath("//input[@id=\"uploadFile\" and @type=\"file\"]"));
        System.out.println(System.getProperty("user.home"));
        String filePath = System.getProperty("user.home")+ Desktop\WhatsAppImage.jpg"
        uploadElement.sendKeys("C:\Users\Seyma\Desktop\WhatsAppImage.jpg");

    }





}
