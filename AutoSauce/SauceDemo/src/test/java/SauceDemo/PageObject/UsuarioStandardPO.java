package SauceDemo.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsuarioStandardPO  extends BasePO{

public UsuarioStandardPO(WebDriver driver) {
         super(driver);
 }
    
@FindBy(id="user-name")
public WebElement inputUsername;

@FindBy(id="password")
public WebElement inputPassword;

@FindBy(id="login-button")
public WebElement buttonLogin;

@FindBy(id="react-burger-menu-btn")
public WebElement buttonMenu;

@FindBy(id="react-burger-cross-btn")
public WebElement buttonSairmenu;


public void action_logar(String username,String senha){
    inputUsername.sendKeys(username+Keys.TAB);
    inputPassword.sendKeys(senha);
    buttonLogin.click();
}


}
