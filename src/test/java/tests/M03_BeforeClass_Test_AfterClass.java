package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class M03_BeforeClass_Test_AfterClass {

    static WebDriver driver; //static olmazsa @BeforeClass ve @AfterClass ulasamaz, bunlari kullanacak isienkesin static olmali

    @BeforeClass
    public static void setUp (){ // static olmali,  bütün testlerden önce 1 defa calisir
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void amazonTest(){
        //Kodlar yazilir
    }

    @Test
    public void facebookTest(){
        //Kodlar yazilir
    }

    @Test
    public void youTubeTest(){
        //Kodlar yazilir
    }

    @AfterClass
    public static void closed (){ // static olmali, bütün testlerden sonra 1 defa calisir

        driver.close();
    }







}
