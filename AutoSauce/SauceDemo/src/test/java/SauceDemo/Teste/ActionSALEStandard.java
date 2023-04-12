package SauceDemo.Teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import SauceDemo.PageObject.ActionSALEStandardPO;

public class ActionSALEStandard extends BaseTest {
    private static  ActionSALEStandardPO actionSaleS;
    @BeforeClass
    public static void PrepararTestes(){
        actionSaleS=new ActionSALEStandardPO(driver);
    }

    @Test
    public void TSS001_FinalizarCompraSemProdutoSemDados() throws InterruptedException{
        
        actionSaleS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionSaleS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
        actionSaleS.buttonCheckout.click();

        actionSaleS.CadastraComprador("", "", "");
        driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]")).click();
        Thread.sleep(500); 
        String ErrorCadastro=actionSaleS.obterSpan();
        assertEquals(ErrorCadastro, "Error: First Name is required");
         
    }

    @Test
    public void TSS002_FinalizarCompraSemProdutoSomentecomNome() throws InterruptedException{
        
        actionSaleS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionSaleS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
        actionSaleS.buttonCheckout.click();

        actionSaleS.CadastraComprador("User-Teste", "", "");
        driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]")).click();
        Thread.sleep(500); 
        String ErrorCadastro=actionSaleS.obterSpan();
        assertEquals(ErrorCadastro, "Error: Last Name is required");
         
    }

    @Test
    public void TSS003_FinalizarCompraSemProdutoSomentecomNomeeSobrenome() throws InterruptedException{
        
        actionSaleS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionSaleS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
        actionSaleS.buttonCheckout.click();

        actionSaleS.CadastraComprador("User-Teste", "teste", "");
        driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]")).click();
        Thread.sleep(500); 
        String ErrorCadastro=actionSaleS.obterSpan();
        assertEquals(ErrorCadastro, "Error: Postal Code is required");
         
    }

    /**
     * o teste abaixo foi realizado sem nenhum item ter sido adicionado ao carrinho,
     * mostrando que a ordem de pedido foi concluida mesmo sem ter sido realizado compra de nunhuma mercadoria
     * @throws InterruptedException
     */
    @Test
    public void TSS004_FinalizarCompraComTodosDadosSemNenhumItem() throws InterruptedException{
        
        actionSaleS.action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        Thread.sleep(500);
        assertEquals(actionSaleS.obterURLPagina(), "https://www.saucedemo.com/cart.html");
        actionSaleS.buttonCheckout.click();

        actionSaleS.CadastraComprador("User-Teste", "teste", "35501250");
        driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]")).click();
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(500); 
        assertEquals(actionSaleS.obterURLPagina(), "https://www.saucedemo.com/checkout-complete.html");

         
    }

    //o flace jacket,se comprado com outra mercadoria,retorna um valor total float de muitas casas

    

    
}
