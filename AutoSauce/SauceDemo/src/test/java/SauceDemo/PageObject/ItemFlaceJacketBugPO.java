package SauceDemo.PageObject;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class ItemFlaceJacketBugPO extends BasePO {
    
    @FindBy(id="user-name")
    public WebElement inputUsername;

    @FindBy(id="password")
    public WebElement inputPassword;

    @FindBy(id="login-button")
    public WebElement buttonLogin;

    @FindBy(id="first-name")
    public WebElement inputFirstName;

    @FindBy(id="last-name")
    public WebElement inputLastName;

    @FindBy(id="postal-code")
    public WebElement inputPostalCode;

    @FindBy(id="reset_sidebar_link")
    public WebElement buttonReset;

    @FindBy(id="react-burger-menu-btn")
    public WebElement buttonMenu;

    @FindBy(id="finish")
    public WebElement buttonFinish;

    public ItemFlaceJacketBugPO(WebDriver driver) {
        super(driver);
        
    }

    public void action_logar(String username,String senha){
        inputUsername.sendKeys(username+Keys.TAB);
        inputPassword.sendKeys(senha);
        buttonLogin.click();
    }
    
    public void CadastraComprador(String name,String lastName,String zipCode){
        inputFirstName.sendKeys(name+Keys.TAB);
        inputLastName.sendKeys(lastName+Keys.TAB);
        inputPostalCode.sendKeys(zipCode);
    }
    
    public void CompraItemJuntoFlace(String texto) throws InterruptedException {
        action_logar("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart"+texto+"']")).click();

        driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
        driver.findElement(By.xpath("//button[@id='checkout']")).click(); 
        Thread.sleep(500);

        CadastraComprador("joao", "costa", "35510");
        
        driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]")).click();
        Thread.sleep(500);

    }

    public void comparaPrecoTotal(String valorTotal){
        String total =driver.findElement(By.xpath("//*[contains(text()[1],'Item total')]")).getText();
        if(total.length()>=22){
            assertNotEquals(total.length(), valorTotal.length());
            System.out.println("O valor informado precisa ser conferido,excede a quantidade de numeros");
        }
        else{
            assertEquals(total.length(), valorTotal.length());
            System.out.println("Pass");
        }
    }

    
    public void comprasEfetuadascomItemFlaceJacket() {
        
      action_logar("standard_user", "secret_sauce");

      /**
       * CONSEGUI CAPTURAR OS ITENS A SER COMPRADOS ATRAVES DO PRIMEIRO WEBELEMENT
       * que basicamente fez um elemento web com a div que contem os itens
       * E DEPOIS FIZ UMA LISTA DESSE PRIMEIRO WEBELEMENT
       * aonde filtrei pelo ids que continham a string "add-to-cart-"
       */
      WebElement prod=driver.findElement(By.id("root"));
      List <WebElement> listofItems = prod.findElements(By.xpath("//button[text()='Add to cart']"));
      /**
       * aqui usei o remove if(remova se) para deletar o item que vou usar de toda forma no loop,atraves do seu id,consegui o rastrear e assim o excluir
       */
      listofItems.removeIf(item -> item.getAttribute("id").equals("add-to-cart-sauce-labs-fleece-jacket"));
      System.out.println(listofItems.size());
     
   /**
    * notas:
    o for each nao estava funcionando o codigo,o loop nao percorria por todos produtos,entao usei o normal
    */
      for(int i=0;i<listofItems.size();i++){
   /**
    * atraves do try catch consegui finalizar o codigo com sucesso,pois no caso do erro "IndexOutOfBoundsException " o codigo daria um break ao inves 
    de continuar e consequentemente dar um erro.
    */
 
   try{
   driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
          
   prod=driver.findElement(By.id("root"));
   listofItems = prod.findElements(By.xpath("//button[text()='Add to cart']"));
   WebElement product=listofItems.get(i);
   //->usei o sysout abaixo para conferir se realmente os itens estao mudando
   System.out.println("Clicando no botão com id: " + product.getAttribute("id"));
   product.click();
   

   driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
   driver.findElement(By.xpath("//button[@id='checkout']")).click(); 
    

   CadastraComprador("joao", "costa", "35510");
   driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]")).click();
    

   comparaPrecoTotal("Item total: $65.98");
   buttonFinish.click();
   driver.findElement(By.xpath("//button[@id='back-to-products']")).click(); 

    

    prod=driver.findElement(By.id("root"));
    listofItems = prod.findElements(By.xpath("//button[text()='Add to cart']"));
 }catch(IndexOutOfBoundsException e){
   /**
    * utilizado somente um break para tratar e finalizar um possivel erro.
    */
   break;
 }
         
      }
    } 
    
}
