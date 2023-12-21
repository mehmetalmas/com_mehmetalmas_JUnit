package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class M13_Upload2 {

    WebDriver driver;
    Actions actions;


    @Before
    public void setUP () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    /*
    SetFileDetector() metodu;

        Selenium da WebDriver yardımıyla dosya yükleme işlemlerinde kullandığımız bir diğer metot da
        setFileDetector() metodudur.

        Bildiğiniz üzere dosya yüklemeleri sırasında sendKeys() metodu ile dosya yollarını doğrudan gönderebiliyoruz.
        Ancak dosya yolu belirlemek için sendKeys() metodunun yetersiz kalabiliyor.

        Örneğin, selenium gridde yaptığımız gibi testlerimizi remote server da çalıştırmamız gerektiğinde veya
        testlerimizi çalıştırdığımız işletim sistemindeki dosya yollarının farklı olması durumunda, sendKeys()
        metodu beklentimizi karşılayamayabilir.

        setFileDetector() metodu, bu tür durumlarda kullanılmak üzere tasarlanmıştır. Bu metotla dosya yükleyeceğimiz
        elementi önceden tanımlayarak dosya yükleme işlemlerimizi kolaylaştırırız.

        setFileDetector() metodu, WebDriver sınıfının bir yöntemidir ve FileDetector interface’sini kullanır.

        Örneğin, aşağıdaki kodda, setFileDetector() metodu kullanılarak dosya yükleyicinin belirlendiği bir örnek
        görebiliriz:

        driver.setFileDetector(new LocalFileDetector());

        Bu kod, LocalFileDetector sınıfını dosya yükleyicisi olarak belirler. LocalFileDetector sınıfı, dosya yükleme
        işleminin mevcut bilgisayardaki dosya yollarını kullanmasına izin verir.
        Ayrıca, RemoteFileDetector sınıfını da kullanılabiliriz. Bu sınıfı, dosya yükleme işlemi için uzak bir
        sunucu kullanmamız gerektiğinde kullanabiliriz. RemoteFileDetector sınıfı, dosya yükleyicisinin uzak sunucuda
        çalışmasına izin verir.

        driver.setFileDetector(new RemoteFileDetector(new URL("http://localhost:4444/wd/hub")));

        Bu kod da, RemoteFileDetector sınıfını dosya yükleyicisi tanımlanır ve bir uzak sunucu adresi belirtilir.

        Bu sayede, dosya yükleme işlemimizi uzak bir sunucuda gerçekleştirilebiliriz.
    */


    @Test
    public void upLoad() {
        driver.get("https://demoqa.com/upload-download");
        //WebElement uploadElement = driver.findElement(By.id("uploadFile"));

        /*
        DesiredCapabilities capabilities = new DesiredCapabilities("https://demoqa.com/upload-download");
        capabilities.setCapability("version", "11");
        capabilities.setCapability("platform", Platform.WIN10);
        capabilities.setCapability("platformName", "windows");
        capabilities.setCapability("video", "True");
        capabilities.setCapability("ie.fileUploadDialogTimeout", 10000); // First time open of the internet
        explorer file upload dialog box is slow.
         */

        WebElement uploadElement = driver.findElement(By.id("uploadFile"));

        RemoteWebDriver remoteWebDriver;

        //DesiredCapabilities.internetExplorer();







    }



}
