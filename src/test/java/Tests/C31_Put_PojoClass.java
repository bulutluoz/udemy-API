package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceholder;

import java.util.LinkedList;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
        status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body : // expected data
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void test01(){
        // 1- request url ve body olustur
            specJsonPlaceholder.pathParams("pp1","posts","pp2","70");

        PojoJsonPlaceholder requestBodyPojo=
                new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);


        // 2- soruda varsa expected data olustur

        PojoJsonPlaceholder expectedDataPojo=
                new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        // 3 - Response olustur, request gonderip sonucu response'a ata
        Response response= given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                                .when().body(requestBodyPojo)
                                .put("{pp1}/{pp2}");
        PojoJsonPlaceholder responsePojo=response.as(PojoJsonPlaceholder.class);

        // 4- Assert
        // expected data (Pojo) <====> response (Pojo)
        // expectedDataPojo             responsePojo

        //status kodunun 200,
        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        //content type’inin “application/json; charset=utf-8”,

        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());

        //Connection header degerinin “keep-alive”

        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

        // response body’sinin asagida verilen ile ayni oldugunu test ediniz

        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),requestBodyPojo.getId());

    }
}

