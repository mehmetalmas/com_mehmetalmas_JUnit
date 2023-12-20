package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class M11_Download {
    static WebDriver driver;
    Actions actions;


    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }



    @Test
    public void downloadTest() throws InterruptedException {

/*
        driver.get("https://demoqa.com/");

        WebElement elementsButton = driver.findElement(By.xpath("//*[@fill=\"currentColor\"][1]"));
        Thread.sleep(2000);
        WebElement elementHeader = driver.findElement(By.xpath("//*[@class=\"header-text\"  and text()='Elements']"));
        Thread.sleep(2000);
        WebElement uploadanDownloadButton = driver.findElement(By.xpath("//*[@class=\"text\"  and text()='Upload and Download']"));


 */

        driver.get("https://demoqa.com/upload-download");

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        String path = "H:/";  // Bilgisayara inen dosyanin indigi klasör path i
        String fileName = "sampleFile.jpg"; // Bilgisayara inen dosyanin adi
        Thread.sleep(3000); // indirme süresi icin zaman verelim


        // Bu test icin olusturdugumuz instance isFileDownloaded metodunu kullanalim(en asagida)
        boolean isDownloaded = isFileDownloaded(path, fileName);
        System.out.println(isDownloaded);

    }

    @Test
    public void downloadTest2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement spectrumLogo = driver.findElement(By.xpath("//a[text()='spectrum-logo.png' and @href =\"download/spectrum-logo.png\" ]"));
        Thread.sleep(3000);
        String filePath = "H:\\spectrum-logo";  //Dosya yolunu dosya adi ile direk girdik, üstteki cözümde tüm inen
        // dosya klasörünü bir Array aldik ve icinde arama yaptik

        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }












    public static boolean isFileDownloaded(String downloadPath, String fileName){
        // Bu metot bilgisayara inen dosyayi belirtilen yolda(klasörde) ariyor
        // bunu java daki File class ile yapiyoruz, bu sinif ile bilgisayardaki dosyalara ulasabiliriz
        File file = new File(downloadPath); // file objesi olusturduk, metodun aldigi ilk parametre ile
        File[] files = file.listFiles(); //indirilen klasörün elemanlarinin path lerini files arrayine atadik

        for (int i = 0; i < files.length; i++) {
            // if icinde equals ile karsilastirma yapalim
            if (files[i].getName().equals(fileName)) {
                files[i].delete(); // inen dosyayi silelim, elle silmemek icin
                //indirilen dosya adi ile inen dosya adi ayni ise true döndürsün, metodun aldigi 2. paremetre gecildi
                return true;
            }
        }
        //degilse false döndürsün
        return false;
    }





}
