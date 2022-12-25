package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;


public class C15_Get_SoftAssertIleExpectedDataTesti {

    @Test
    public void test01(){
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un asagidaki gibi oldugunu test edin.
            Response Body
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

        // 1- end point ve request body olustur

        String url= "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- expected data olustur

        JSONObject expectedData= new JSONObject();
        JSONObject dataBilgileriJson=new JSONObject();

        dataBilgileriJson.put("id",3);
        dataBilgileriJson.put("employee_name","Ashton Cox");
        dataBilgileriJson.put("employee_salary",86000);
        dataBilgileriJson.put("employee_age",66);
        dataBilgileriJson.put("profile_image","");

        expectedData.put("status","success");
        expectedData.put("data",dataBilgileriJson);
        expectedData.put("message","Successfully! Record has been fetched.");

        // 3- Request gonder, donen response'i kaydet

        Response response= given().when().get(url);


        // 4- Assertion

        // oncelikle response uzerindeki bilgileri kolay almak icin
        // JSonPath'e cast edelim

        JsonPath responseJsonPath= response.jsonPath();

        // Assertion'lari soft assert ile yapalim

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.id"),
                            expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),
                expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),
                expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),
                expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),
                expectedData.getJSONObject("data").get("profile_image"));
        softAssert.assertAll();



    }
}
