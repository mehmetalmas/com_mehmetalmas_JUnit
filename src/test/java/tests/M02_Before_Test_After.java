package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class M02_Before_Test_After {

    // JUnit testleri karisik calistirir, belli bir sira takip etmez
    // Sira ile takip etmesini istiyorsan @FixMetotOrder(MetotSortes.NAME_ASCEDING) i kullanmalisin

    WebDriver driver; // notasyonlardan önce, disinda yazarsan, sinif icine olur ve tüm notasyonlardan ulasilir,
    // instance variable olarak da tanimlanimlanabilir
    // test notasyonunun icinde tanimlarsan lokal variable olur ve diger test lerden ulasilamaz

    @Before
    public void setUp(){  // Her test metodundan (@Test) önce calisir
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("@Before Calisti");
    }

    //  @Before calisir
    @Test
    public void amazonTest(){ // ne testi yapiyorsan test metodunun adi o olsun
        //Test kodlari yazilir
        System.out.println("Amazon Testi calisti");
    }
//  @After calisir


    //  @Before calisir
    @Test
    public void facebookTest(){ // ne testi yapiyorsan test metodunun adi o olsun
        //Test kodlari yazilir
        System.out.println("Facebook Testi calisti");
    }
//  @After calisir


    //  @Before calisir
    @Test
    public void youTubeTest(){ // ne testi yapiyorsan test metodunun adi o olsun
        //Test kodlari yazilir
        System.out.println("YouTube Testi calisti");
    }
//  @After calisir


    @After  // illa sonda yazilacak diye bir sart yok, nereye yazarsan yaz teslerden sonra calisir
    public void closed (){ // Her test metodundan(@Test) sonra calisir
        System.out.println("@After Calisti");
        driver.close();
    }







}
