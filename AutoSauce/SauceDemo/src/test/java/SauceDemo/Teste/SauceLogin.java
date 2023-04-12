package SauceDemo.Teste;




import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import SauceDemo.PageObject.SauceLoginPO;
/**
 * o fix method order serve para fazer os testes rodarem em ordem,poissem isso o selenium junto com java executa de forma sortida os testes solicitados.    
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SauceLogin extends BaseTest {
    
    private static  SauceLoginPO sauceloginPO;
    @BeforeClass
    public static void PrepararTestes(){
        sauceloginPO=new SauceLoginPO(driver);
    }

    @Test
    public void TL001_usuariocCorretoesenhainvalida(){
        
        sauceloginPO.clean_login();
        sauceloginPO.action_logar("standard_user", "");
        String erro=sauceloginPO.obterMensagem();
        assertEquals(erro, "Epic sadface: Password is required");
       

    }
    

    @Test
    public void TL002_usuarioincorretosenhavalida(){
        
        sauceloginPO.clean_login();
        sauceloginPO.action_logar("", "secret_sauce");
        String erro=sauceloginPO.obterMensagem();
        assertEquals(erro, "Epic sadface: Username is required");
        

    }

    @Test
    public void TL003_usuarioesenhasvazios(){
        
        sauceloginPO.clean_login();
        sauceloginPO.action_logar("", "");
        String erro=sauceloginPO.obterMensagem();
        assertEquals(erro, "Epic sadface: Userrname is required");
        

    }

    @Test
    public void TL004_usuario2EsenhavalidaLOCKED(){
        
        sauceloginPO.clean_login();
        sauceloginPO.action_logar("locked_out_user", "secret_sauce");
        String erro=sauceloginPO.obterMensagem();
        assertEquals(erro, "Epic sadface: Sorry, this user has been locked out.");
        

    }

    



    

    



}   
