package Session2;
import Session2.pojo.Cart;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HowToHandleTest {

    @Test
    public void getCart(){
        RestAssured.baseURI = "https://dummyjson.com/";

        Cart cart =
        RestAssured
                .given()
                .when()
                    .get("/carts/1")
                .then()
                    .statusCode(200)
                    .extract()
                    .as(Cart.class);

        System.out.println(cart.toString());


        assertThat("There must be at least one item in the cart", cart.getProducts().size(), greaterThanOrEqualTo(1));
        assertThat(cart.getProducts().getFirst().getPrice(), greaterThan(0.0));

        assertThat(cart.getProducts().getLast(), hasProperty("title"));
        assertThat(cart.getProducts().get(1).getPrice(), both(greaterThan(1000.0)).and(lessThan(2000.0)));
    }

    @Test
    public void getListOfCart(){
        RestAssured.baseURI = "https://dummyjson.com/";

        Response response =
                RestAssured
                        .given()
                        .when()
                            .get("/carts")
                        .then()
                            .statusCode(200)
                            .extract()
                            .response();

        List<Cart> cartList = response.jsonPath().getList("carts", Cart.class);


        for (Cart cart : cartList){
            assertThat(cart.getProducts(), notNullValue());
            assertThat("Total value should be greaterThan zero", cart.getTotal(), greaterThan(0.0));
            assertThat("Discount value can not be negative", cart.getDiscountedTotal(), greaterThanOrEqualTo(0.0));
        }

    }

}
