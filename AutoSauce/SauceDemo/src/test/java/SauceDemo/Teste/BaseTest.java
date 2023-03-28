package SauceDemo.Teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//a classe é abstrata por que ela so serve para outras classes herdarem seus atributos e metodos
public abstract class BaseTest {
    
    protected static WebDriver driver;
    private static final String URL_BASE="https://www.saucedemo.com/";
    
    //aqui no base test,deixamos somente metodos que vao servir para todos os testes,cmo exemplo o iniciar e o finalizar que vai servir para todos e pode ser reaproveitado em varios casos usando a herança.

    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/João Victor/Desktop/ChromeDriver.111/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}
