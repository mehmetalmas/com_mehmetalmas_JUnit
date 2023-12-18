package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class M04_CheckBox {
    WebDriver driver;

    // Eger locater lari baska testlerde de kullanacaksan sinif icinde böyle yazik her test icinde kullanabilirsin
    private static final By lokatorIsmi = By.xpath("(//input[@type='checkbox'])[1]");

    @Before
    public void setUp (){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkBox () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 =  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 =  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //WebElement locaterElementi = driver.findElement(lokatorIsmi);


        if (checkBox1.isSelected()) {
            System.out.println("testFailed");
        }else{
            System.out.println("testFailed");
        }

        if (!checkBox2.isSelected()) {
            System.out.println("tastFailed");
        }else{
            System.out.println("testFailed");
        }

        Thread.sleep(5000);

    }



    @After
    public void finish(){
        driver.close();
    }





















}
