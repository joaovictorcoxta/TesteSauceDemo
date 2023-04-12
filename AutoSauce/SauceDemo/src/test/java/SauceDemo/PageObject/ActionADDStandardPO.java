package SauceDemo.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * fiz esse arquivo para deixar a funcao comprar isolada
 *facilitando assim a identificacao de algum erro futuro
 */
public class ActionADDStandardPO extends BasePO {

@FindBy(id="user-name")
public WebElement inputUsername;

@FindBy(id="password")
public WebElement inputPassword;

@FindBy(id="login-button")
public WebElement buttonLogin;

@FindBy(css="#shopping_cart_container > a > span")
public WebElement spanItensCarrinho;
    

public ActionADDStandardPO(WebDriver driver) {
        super(driver);
        
    }

    public void action_logar(String username,String senha){
        inputUsername.sendKeys(username+Keys.TAB);
        inputPassword.sendKeys(senha);
        buttonLogin.click();
    }

    
    
}
