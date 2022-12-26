package Tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlDummyRestapi2 extends BaseUrlJsonPlaceholder {

        @Test
        public void test01(){
            //3- https://jsonplaceholder.typicode.com/posts/50 endpointine
            //   bir DELETE request gonderdigimizde donen response’un
            //      status code’unun 200 oldugunu
            //      ve response body’sinin null oldugunu test edin


            // 1- endpoint ve request body olustur

            specJsonPlaceholder.pathParams("pp1","posts","pp2",50);


            // 2- expected data olustur
            // 3- request gonder ve donen response'i kaydet

            Response response= given()
                                    .when().spec(specJsonPlaceholder)
                                    .delete("/{pp1}/{pp2}");


            // 4- Assertion

            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("title",Matchers.nullValue());

        }

    }
