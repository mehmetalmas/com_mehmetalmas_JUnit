package tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.HttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class M10_BrokenLinks_Images {
    // Bazen resim acilmadiginda resim yerine cikan simge, resmi bulamadigi icin böyle sonuc dönor html bu bir hatadir
    // ayni sey link ler icinde gecerli tikladiginda calismayan veya istenilen yee gitmeyen link lerde hatadir
    // hatali link ler 500 döner / hatasizlar 200 döner
    // bu kirik link ve images ler icin Apache HttpClient dependency ini MavenRepository den indirmelsin

    static WebDriver driver;
    Actions actions;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void brokenLink () {
        // Bu cözüm dönüs tiplerini kontrol ederek  resim veya link in kirik olup olmadigina bakiyor
        // 1-HttpClient tipinde bir variable olusturulur ona asagidaki sekilde atama yapilir (cast ti otomatik yapti intellije)
        // 2-request objesi olusturulur ve parametre olarak tiklama yaptigimiz linkin gittigi adres strin olarak verilir
        // 3-response almak ve onu bir HttpResponse tipinde tutmak icin bir variable olusturulur



        HttpClient client = (HttpClient) HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://demoqa.com/");
        HttpResponse response; // = client.execute(request);
        // parametre olarak HttpRequest sinifinfan bir referans
        // parametre istiyor, derste anlatilan ve olan HttpGet referansi ama bende olmadi
        int statusCode; // = response.getStatusLine().getStatusCode();
        //System.out.println(statusCode); // 200 dönerse test gecer 500 dönerse test kalir

    }


    @Test
    public void brokenLink2 () throws IOException {
        //<a href=”www.comrevo.com”>Click here</a>  link tag i ve link attirubute si

        // Bilgilendirici yanıtlar ( 100– 199)
        // Başarılı yanıtlar ( 200– 299)
        // Yönlendirme mesajları ( 300– 399)
        // İstemci hatası yanıtları ( 400– 499)
        // Sunucu hatası yanıtları ( 500– 599)

        //HTTP Response(Yanit) / Status(Durum) Code (Response:yanit, karsilik)
        //200: Valid Link / Geçerli Bağlantı

        //400: Bad Request (Bad URL) / Hatalı İstek (Kötü URL)  (Request : rica etmek,istemek)
        //400: Broken if response code / Yanıt kodu bozuksa

        //404: Web Page Not Found / Web Sayfası Bulunamadı
        //405: Server knows the request method, target resource doesn’t support this method
        //Sunucu istek yöntemini biliyor, hedef kaynak bu yöntemi desteklemiyor

        //503: Server is overloaded and can not process request / Sunucu aşırı yüklendi ve isteği işleyemiyor

        driver.get("https://demoqa.com/broken"); //sadece sayfanin adresini yaz giger kodlar degismiyor

        //Sayfadaki tüm link elementlerini bir listeye alalim
        List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href,'.')]"));
        //xpat icin bir element locate edilmedi a taglerindeki href attirubute lerine sahip elementeri aliyor

        //simdi tüm tagler i bozuk mu diye for each ile kontol edeilim
        for (WebElement link: links) {
            String url = link.getAttribute("href");
            HttpURLConnection con=(HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD"); //acilan web sayfasinin basligina ihtiyacimiz var,
            // sayfanin gövdesi ile ilginemiyoru baslikla ilgileniyoruz
            con.connect();
            int respcode=con.getResponseCode();

            if(respcode>=400) {
                System.out.println("Link Text:"+link.getText()+" Response Code:"+respcode);
            }
        }


    }




    @Test
    public void brokenImage() throws IOException, InterruptedException { // hata bulmazsa hic bir sey yazdirmaz

        //<img src="/images/Toolsqa_1.jpg">

        driver.get("https://demoqa.com/broken"); //sadece sayfanin adresini yaz giger kodlar degismiyor

        //Sayfadaki tüm link elementlerini bir listeye alalim
        List<WebElement> images = driver.findElements(By.tagName("img"));
        //xpat icin bir element locate edilmedi a taglerindeki href attirubute lerine sahip elementeri aliyor

        //simdi tüm tagler i bozuk mu diye for each ile kontol edeilim
        for (WebElement image: images) {
            String url = image.getAttribute("src");
            HttpURLConnection con=(HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD"); //acilan web sayfasinin basligina ihtiyacimiz var,
            // sayfanin gövdesi ile ilginemiyoru baslikla ilgileniyoruz
            con.connect();
            int respcode=con.getResponseCode();

            if(respcode>=400) {
                System.out.println("Image Text:"+image.getText()+" Response Code:"+respcode);
                System.out.println("hata bulunmadi");
            }
        }



    }





























}
