package SauceDemo.Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import SauceDemo.PageObject.ActionADDStandardPO;

public class ActionADDStandard extends BaseTest {
    private static  ActionADDStandardPO actionADDS;
    @BeforeClass
    public static void PrepararTestes(){
        actionADDS=new ActionADDStandardPO(driver);
    }

//tsc,o primeiro nome do teste,fpo uma abreviação de TESTE COMPRAS STANDARD (usuario que foi logado)
    @Test
    public void TCS001_AdicionarBackpackCarrinho() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
         
    }

    @Test
    public void TCS002_AdicionarBikeLightCarrinho() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
         
    }

    @Test
    public void TCS003_AdicionarBoltTShirtCarrinho() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
         
    }

    @Test
    public void TCS004_AdicionarFlaceJacketCarrinho() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
         
    }

    @Test
    public void TCS005_AdicionarOnesieCarrinho() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
         
    }

    @Test
    public void TCS006_AdicionarTShirtREDCarrinho() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
         
    }

    @Test
    public void TCS007_AdicionarTodosositens() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
    
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        
        
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");

    
    }
    /**
     * recriei essa funcao afim de em outro teste poder reaproveitar a de cima,como inseri no teste 8,a confirmacao que o caarinho sem mantem com os itens
     * deixei as duas,sendo uma sem essa funcao
     * @throws InterruptedException
     */
    @Test
    public void TCS008_AdicionarTodosositensevoltarprateleinicial() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        //utilizei todos os itens do site,os selecionando atraves o xpath,usando seu recurso de filtrar aonde seria clicado,pelo comando buttton/@id='produto que sera escolhido'
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        
        
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        Thread.sleep(1000);
        //criei essa parte do teste,pois me gerou a duvida se caso eu sair do carrinho e voltar para pagina de compras,meus pedidos pendentes ainda continuariam no caarinho,pensando nisso realizei um assertequals comparando o texto com o valor 6(que é a quantidade de itens da loja)
        String qtd=actionADDS.spanItensCarrinho.getText();
        assertEquals(qtd, "6");
         
    }

    @Test
    public void TCS009_AdicionarTodosositensevoltarprateleinicialeRemover() throws InterruptedException{
        
        actionADDS.action_logar("standard_user", "secret_sauce");
        //utilizei todos os itens do site,os selecionando atraves o xpath,usando seu recurso de filtrar aonde seria clicado,pelo comando buttton/@id='produto que sera escolhido'
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        
        
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        assertEquals(actionADDS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        Thread.sleep(1000);
        //criei essa parte do teste,pois me gerou a duvida se caso eu sair do carrinho e voltar para pagina de compras,meus pedidos pendentes ainda continuariam no caarinho,pensando nisso realizei um assertequals comparando o texto com o valor 6(que é a quantidade de itens da loja)
        String qtd=actionADDS.spanItensCarrinho.getText();
        assertEquals(qtd, "6");

        driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();

        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        Thread.sleep(500);
        
        /**
         * atraves do metodo assertTrue,verifiquei se o objeto "qtd",estava vazio apos efetuar a acao de remover todos os itens que estavam no carrinho
         * qtd é o texto contido no objeto que possui a quantidade de produtos no carrinho
         */
        assertTrue(!qtd.isEmpty());
        
         
    }

    




    



}

