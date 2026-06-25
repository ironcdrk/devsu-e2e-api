package altiora.pages;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

        public static final Target USER_FIELD = Target.the("INPUT PARA USUARIO")
            .located(By.id("user-name"));

        public static final Target PASSWORD_FIELD = Target.the("INPUT PARA CONTRASEÑA")
            .located(By.id("password"));
            
        public static final Target LOGIN_BUTTON = Target.the("BOTÓN LOGIN")
            .located(By.id("login-button"));
            //.locatedBy("//a[@href='/login']");
}
