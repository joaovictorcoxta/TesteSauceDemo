package SauceDemo.PageObject;
//classse que so serve como modelo
//classe base para criação de novas pages
//todas as apages devem ser herdadas dessa classe

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {
    //driver que vai ser usado pelas pages
    protected WebDriver driver;
    /**
     * construtor base para a criação da fabrica de elementos(page factory)
     * @param driver driver da pagina atual
     */
    protected BasePO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String  obterURLPagina(){
        return driver.getCurrentUrl();
    }
    
  


  
}
