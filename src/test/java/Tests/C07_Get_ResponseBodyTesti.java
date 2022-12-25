package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_ResponseBodyTesti {

    @Test
    public void test01(){
        /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in
        	status code'unun 200,
        	ve content type'inin Aplication.JSON,
        	ve response body'sinde bulunan userId'nin 5,
        	ve response body'sinde bulunan title'in "optio dolor molestias sit"
        	oldugunu test edin.

         */

        // 1- end point ve request body hazirla
        String url= "https://jsonplaceholder.typicode.com/posts/44";

        // 2- expected data hazirla
        // 3- request yollayip, donen response'i kaydet

        Response response= given().when().get(url);

        // 4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
