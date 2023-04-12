package SauceDemo.Teste;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;





import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;


import SauceDemo.PageObject.ItemFlaceJacketBugPO;

public class ItemFlaceJacket extends BaseTest {
    private static  ItemFlaceJacketBugPO itemflacejacket;
    @BeforeClass
    public static void PrepararTestes(){
        itemflacejacket=new ItemFlaceJacketBugPO(driver);
    }

    @Test
    public void TCFJ001_comprarutilizandooitemBackpack() throws InterruptedException{
        
       itemflacejacket.CompraItemJuntoFlace("-sauce-labs-backpack");
       //maneira certa de se usar o contains com uma string
       //tambem poderia ser usado utilizando "//*[contains(string(),' text')]"
       //obs:so consegui obter o valor ,pegando tamnbem o no string item total
       String total =driver.findElement(By.xpath("//*[contains(text()[2],'79.98')]")).getText();
       assertEquals(total, "Item total: $79.98");
     
         
    }

    @Test
    public void TCFJ002_comprarutilizandooitemBikeLight() throws InterruptedException{
        
       itemflacejacket.CompraItemJuntoFlace("-sauce-labs-bike-light");

       String total =driver.findElement(By.xpath("//*[contains(text()[2],'59.980000000000004')]")).getText();
       assertNotEquals(total, "Item total: $59.98");
     
         
    }

    @Test
    public void TCFJ003_comprarutilizandooitemBoltTshirt() throws InterruptedException{
        
       itemflacejacket.CompraItemJuntoFlace("-sauce-labs-bolt-t-shirt");

       String total =driver.findElement(By.xpath("//*[contains(text()[2],'65.98')]")).getText();
       assertEquals(total, "Item total: $65.98");
     
         
    }

   @Test
    public void TCFJ004_comprarutilizandooitemOnesie() throws InterruptedException{
        
       itemflacejacket.CompraItemJuntoFlace("-sauce-labs-onesie");

       String total =driver.findElement(By.xpath("//*[contains(text()[2],'57.980000000000004)]")).getText();
       assertNotEquals(total, "Item total: $57.98");
     
         
    }

    @Test
    public void TCFJ005_comprarutilizandooitemALLTHETHINGS() throws InterruptedException{
        
       itemflacejacket.CompraItemJuntoFlace("-test.allthethings()-t-shirt-(red)");

       String total =driver.findElement(By.xpath("//*[contains(text()[1],'Item total')]")).getText();
       assertEquals(total, "Item total: $65.98");
     
         
    } 
    
    @Test
    public void TCFJ006_comprar1itemuntoaoflacejacket(){
      itemflacejacket.comprasEfetuadascomItemFlaceJacket();
    }

    @Test
    public void TCFJ007_comprarcadasitemcomTodosdaloja () {
      itemflacejacket.compraDecadaItemcomOsoutros();
        }
    }
    

   
   
