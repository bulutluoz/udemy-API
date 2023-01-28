package Tests;

import TestDatalari.TestDataDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Get_TestDataClassKullanimi extends BaseUrlDummyExample {

    @Test
    public void test01(){
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200,
        content Type’inin application/json
        ve body’sinin asagidaki gibi oldugunu test edin.

          Expected Response Body
            {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
            }
         */

        // 1- endpoint ve request body olustur
           specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2- expected data olustur

        JSONObject expectedData= TestDataDummyExample
                                        .jsonResponseBodyOlustur(3,
                                                      "Ashton Cox",
                                                        86000,
                                                         66,
                                                         "");

        // 3- request gonder ve donen response'i kaydet
        Response response= given().spec(specDummyExample).
                                when().
                                get("{pp1}/{pp2}");

        // 4- assertion
        //   Expected data : JSONObject
        //   response : JsonPath

        JsonPath responseJP= response.jsonPath();
        //donen response’un status code’unun 200,
        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        //content Type’inin application/json
        assertEquals(TestDataDummyExample.contentType,response.contentType());
        //ve body’sinin asagidaki gibi oldugunu test edin.

        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),
                     responseJP.getString("data.profile_image"));

        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),
                responseJP.getString("data.employee_name"));

        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"),
                responseJP.getInt("data.employee_salary"));

        assertEquals(expectedData.getJSONObject("data").getInt("id"),
                responseJP.getInt("data.id"));

        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),
                responseJP.getInt("data.employee_age"));

        assertEquals(expectedData.getString("message"),responseJP.getString("message"));

        assertEquals(expectedData.getString("status"),responseJP.getString("status"));
    }
}
