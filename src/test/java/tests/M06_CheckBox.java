package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class M06_CheckBox {


    static WebDriver driver;

    By checkBoxHome = new By.ByCssSelector("label[for='tree-node-home'] span.rct-checkbox svg");

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void checkBox1 () {

        driver.get("https://demoqa.com/checkbox");
        WebElement checkBoxHome = driver.findElement(this.checkBoxHome);
        // this kullanmak istemiyorsan yukaridaki By dakinin adinin sonuna By ekleyebilirsin

        checkBoxHome.click();

        // simdi secilip secilmedigini selenium ile konrol edelim, secilen her check box in DOM da clas ismi degisir
        // bizde elementin attuributunu alip bu attirute isminde degisen clas ismi varmi diye kontrol edebiliriz

        checkBoxHome = driver.findElement(this.checkBoxHome);
        // tiklamadan sonra elementi bulamadi ve StaleElementReferenceException hatasini aldik
        // elementi tekrar bulabilsin diye sonra bu satir ekledik
        // bu tekrardan elementi buraya yazarak elementi bulmasini sagliyoruz

        String checkBoxHomeClassName = checkBoxHome.getAttribute("class");
        // icine "class" yazarsan sadece class attrubutinin value sini getirir, bu durmda if de equals ile
        // karsilastirma yapabilirsin yada
        //String checkBoxHomeClassName = "rct-icon rct-icon-check";  seklinde yapabiliriz, kopyala yapistir
        // tiklama olmadan önceki class value: rct-icon rct-icon-uncheck dir

        if (checkBoxHomeClassName.equals("rct-icon rct-icon-check")) {
            System.out.println("Check Box tiklanmis");
        }else {
            System.out.println("Check Box tiklanmamis");
        }

        // StaleElementReferenceException hatasini aliyoruz cünkü tiklamadan sonra DOM degistigi icin checkBoxHome u
        // bulamadi, aslinda class value si degisiyor bizde onun üzerinden calistigimizdan checkBoxHome u bulamiyor
        // belki id üzerinden calissaydik bu hatayai almaya bilirsidik
        // cözümü clik den sonra elementi yine yazmaktir

    }



    @Test
    public void checkBox2 () {

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement sportCheckBox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
        boolean isEnabledSportCheckBox = sportCheckBox.isEnabled();
        // tiklanabiliyorsa true dönecektir, calistirip bak sonra devam et

/*
        if (isEnabledSportCheckBox) {
            sportCheckBox.click();   // tiklanabiliyorsa tiklama yapacak
        }

*/

        // ElementClickInterceptedException hatasini aldik kutucuga degilde kutucugun yanindaki yaziya tiklmaya calisti
        // yazi ya tiklasan aslinda kutucuk isaretleniyor ama elemnti yanlis buldugundan hata firlatiyor
        // böyle durumlar cok karsilasilan durumlardir bunu asmak icin try catch blogu kullanilmali

        WebElement sportCheckBoxText = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));
        //CheckBox yazisina tikladigi icin (bunu hata acaiklamalarindan anladik) bunu da locate ettik

        try {
            // 1-Burada yazdigimiz kot bir hata firlatirsa
            sportCheckBox.click(); // bu bize bir hata dönecek bunu biliyoruz
        }catch (ElementClickInterceptedException e){ // hata aciklamalarin icinden aldik
            // 2-catch bloguna girer hata firlatmadan buradaki yazdigimiz koddan devam eder
            sportCheckBoxText.click();
        }

        boolean isSelectedSportCheckBox = sportCheckBox.isSelected();









    }


}
