package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test01(){
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
        Response body (Expected Data) :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

        // 1- endpoint ve request body olustur

        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        JSONObject requestBody = TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 2- expected data olustur

        JSONObject expectedData= TestDataJsonPlaceholder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 3- request gonder ve donen response'i kaydet

        Response response= given().spec(specJsonPlaceholder)
                                .when().body(requestBody.toString()).contentType(ContentType.JSON)
                                .put("{pp1}/{pp2}");


        // 4- Assertion

        JsonPath responseJP= response.jsonPath();

        // status kodunun 200,
        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        // content type’inin “application/json; charset=utf-8”,
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());

        // Connection header degerinin “keep-alive”

        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

        // ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        assertEquals(expectedData.getInt("id"),responseJP.getInt("id"));
        assertEquals(expectedData.getInt("userId"),responseJP.getInt("userId"));
        assertEquals(expectedData.getString("title"),responseJP.getString("title"));
        assertEquals(expectedData.getString("body"),responseJP.getString("body"));




    }
}
