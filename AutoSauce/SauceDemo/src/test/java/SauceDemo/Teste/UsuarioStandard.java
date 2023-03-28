package SauceDemo.Teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import SauceDemo.PageObject.UsuarioStandardPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioStandard extends BaseTest {
    private static  UsuarioStandardPO usuarioStandard;
    @BeforeClass
    public static void PrepararTestes(){
        usuarioStandard=new UsuarioStandardPO(driver);
    }

   

    @Test
    public void TS001_clicksobrebuttonMENUeSAIR() throws InterruptedException{
        
        usuarioStandard.action_logar("standard_user", "secret_sauce");
        usuarioStandard.buttonMenu.click();
        Thread.sleep(500);
        usuarioStandard.buttonSairmenu.click();
       
    
        assertEquals(usuarioStandard.obterURLPagina(), "https://www.saucedemo.com/inventory.html");
        

    }

    @Test
    public void TS002_clicksobrebuttonMENUeABOUT() throws InterruptedException{
        
        usuarioStandard.action_logar("standard_user", "secret_sauce");
        usuarioStandard.buttonMenu.click();
        // a funcao abaixo serve para da um time,que nesse caso foi de 500 milissegundos ate a proxima execução do teste
        Thread.sleep(500);

        //serve para conseguir clicar em um link href,atraves do nome do a <href
        driver.findElement(By.xpath("//a[text()='About']")).click(); 
        
        assertEquals(usuarioStandard.obterURLPagina(), "https://saucelabs.com/");
        

    }

    @Test
    public void TS003_clicksobrebuttonMENUeALLITEMS() throws InterruptedException{
        
        usuarioStandard.action_logar("standard_user", "secret_sauce");
        usuarioStandard.buttonMenu.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='All Items']")).click(); 
        
        assertEquals(usuarioStandard.obterURLPagina(), "https://www.saucedemo.com/inventory.html");
        

    }


    @Test
    public void TS004_clicksobrebuttonMENUeLOGOUT() throws InterruptedException{
        
        usuarioStandard.action_logar("standard_user", "secret_sauce");
        usuarioStandard.buttonMenu.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='Logout']")).click(); 
        
        assertEquals(usuarioStandard.obterURLPagina(), "https://www.saucedemo.com/");
        

    }

    @Test
    public void TS005_clicksobrebuttonCarrinho() throws InterruptedException{
        
        usuarioStandard.action_logar("standard_user", "secret_sauce");
        
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(usuarioStandard.obterURLPagina(), "https://www.saucedemo.com/cart.html");
        

    }











}
