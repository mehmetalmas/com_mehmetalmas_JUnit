package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class M07_RadioButton {
    WebDriver driver;


    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }


    @Test
    public void radioButton () throws InterruptedException {

        Actions actions = new Actions(driver);

        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));

        boolean isEnabledYesRadioButton = yesRadioButton.isEnabled(); // tiklanabiliniyormu
        System.out.println(isEnabledYesRadioButton);


        if (yesRadioButton.isEnabled()) { //tiklanabiliniyorsa click ile tikla
            actions.moveToElement(yesRadioButton).click().build().perform();
            // yesRadioButton.click(); bu böyle ElementClickInterceptedException hatasi verdigi icin actins ile
            // bu hatayai asdik, hatanisbebpleri ; cakisan ögeler, animasyonlar ve gecisler, zamanlama sorunlari
            // olabiliyor
        }

        boolean isSelectedYesRadioButton = yesRadioButton.isSelected();

        if (isSelectedYesRadioButton) {
            System.out.println("Yes radio button is selected");
        }

        WebElement outputYesRadioButton = driver.findElement(new By.ByCssSelector("p.mt-3"));
        System.out.println(outputYesRadioButton.getText()); // tiklama sonrasi cikan yaziyi aldik

    }










}
