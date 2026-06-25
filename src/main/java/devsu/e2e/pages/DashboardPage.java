package devsu.e2e.pages;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage {

        public static final Target ORDER_SELECT = Target.the("SELECT PARA ORDENAR PRODUCTOS")
            .located(By.className("product_sort_container"));            

        public static final Target CART_BUTTON = Target.the("BOTÓN PARA IR AL CARRITO DE COMPRAS")
                .located(By.cssSelector("[data-test='shopping-cart-link']"));

        public static final Target ADD_ONESIE_BUTTON = Target.the("BOTÓN PARA AÑADIR EL PRODUCTO ONESIE AL CARRITO")
            .located(By.id("add-to-cart-sauce-labs-onesie"));
            //.locatedBy("//a[@href='/login']");
        
        public static final Target ADD_BACKPACK_BUTTON = Target.the("BOTÓN PARA AÑADIR EL PRODUCTO BACKPACK AL CARRITO")
            .located(By.id("add-to-cart-sauce-labs-backpack"));
}
