package SauceDemo.PageObject;






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

    public void comparaPrecoTotal(){
        /**
         * aqui utilizei o metodo index of
         * ele nada mais é que um contador a partir do ponto escolhido,no caso selecionei o "." e subtrai 1 para que nao contasse com ele
         */
        

         //na hora que selecionar o elemento,é melhor selecionar o elemenmto em si,nao o texto que se encontra nele
        String valueTotal=driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]")).getText();
        int casasDecimais=0;
        //caso o valor total da compra contenha a string "." o loop if é iniciado
        //aonde casas decimais=quantidade de caracteres de valor total-a quantidade de caracteres de valor total a partir do ponto-1
        //como disse o "-1" é para desconsiderar o "."
       if(valueTotal.contains(".")){
            casasDecimais=valueTotal.length()-valueTotal.indexOf(".")-1;
       }
       //caso for igual a dois,que é o esperado,satisfaz a condicao que o valor esta correto
       if(casasDecimais==2){
        System.out.println(casasDecimais);
        System.out.println("O valor Total da compra esta correto");
       }else{
        System.out.println(casasDecimais);
        System.out.println("Valor ultrapassa o numero de casas decimais");
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
   //na hora de igualar ou chamar  algum item da lista,utilizar o get() com o indice desejado,nesse caso foi o "i"
   WebElement product=listofItems.get(i);
   //->usei o sysout abaixo para conferir se realmente os itens estao mudando
   System.out.println("Clicando no botão com id: " + product.getAttribute("id"));
   product.click();
   

   driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]")).click(); 
   driver.findElement(By.xpath("//button[@id='checkout']")).click(); 
    

   CadastraComprador("joao", "costa", "35510");
   driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]")).click();

   comparaPrecoTotal();
    

   
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


public void compraDecadaItemcomOsoutros(){
    action_logar("standard_user", "secret_sauce");
    
    WebElement prod = driver.findElement(By.id("root"));
    List<WebElement> listofItems = prod.findElements(By.xpath("//button[text()='Add to cart']"));

    for (int i = 0; i < listofItems.size(); i++) {
//utilizando o tratamento try catch,evita o erro de quantidade que o loop traalharia
// poderia considerar o .size-1,mas utiliozei da forma acima
        try{
prod = driver.findElement(By.id("root"));
listofItems = prod.findElements(By.xpath("//button[text()='Add to cart']"));
WebElement productI = listofItems.get(i);
System.out.println("Clicando no botão com id: " + productI.getAttribute("id"));



for (int j = 0; j < listofItems.size(); j++) {
 // Combina todos os itens, exceto o item atual, com o item atual
 if (i != j) {
  int aux=1;
  prod = driver.findElement(By.id("root"));
  listofItems = prod.findElements(By.xpath("//button[text()='Add to cart']"));
  //na maioria das vezes,voce tem que novamente chamar a linha que esta procurando o elemento
  //pois na medida que o loop é ativado,a mesma pode se perder nele,ocasionando erro
  productI = listofItems.get(i);
  productI.click();

  WebElement productJ = listofItems.get(j);
  // somente um sysout para verificar em qual item o click do loop esta
  //considerando o elemento productJ
       System.out.println((aux+i)+"Clicando no botão com id: " + productJ.getAttribute("id"));
       productJ.click();

       driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_container')]"))
               .click();
       driver.findElement(By.xpath("//button[@id='checkout']"))
               .click();
        CadastraComprador("joao", "costa", "35510");

       driver.findElement(By.xpath("//*[contains(@class, 'submit-button btn btn_primary cart_button btn_action')]"))
               .click();
      
        
       comparaPrecoTotal();

       buttonFinish.click();
       driver.findElement(By.xpath("//button[@id='back-to-products']"))
               .click();
   }

      }
     }    catch(IndexOutOfBoundsException e){
  /**
   * utilizado somente um break para tratar e finalizar um possivel erro.
   */
  break;
}
}
      
}
    
}
