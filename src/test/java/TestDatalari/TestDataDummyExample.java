package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataDummyExample {

    public static int basariliSorguStatusCode=200;
    public static String contentType="application/json";

    /*
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

    public static JSONObject jsonResponseBodyOlustur(int id,
                                                     String employee_name,
                                                     int employee_salary,
                                                     int employee_age,
                                                     String profile_image){

        JSONObject responseBody= new JSONObject();
        JSONObject dataBody= new JSONObject();

        dataBody.put("id",id);
        dataBody.put("employee_name",employee_name);
        dataBody.put("employee_salary",employee_salary);
        dataBody.put("employee_age",employee_age);
        dataBody.put("profile_image",profile_image);

        responseBody.put("status","success");
        responseBody.put("data",dataBody);
        responseBody.put("message","Successfully! Record has been fetched.");

        return responseBody;
    }


    /*
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

    public static Map<String,Object> mapBodyOlustur(){

        Map<String,Object> bodyMap= new HashMap<>();
        Map<String,Object> dataMap= new HashMap<>();

        dataMap.put("id",3.0);
        dataMap.put("employee_name","Ashton Cox");
        dataMap.put("employee_salary",86000.0);
        dataMap.put("employee_age",66.0);
        dataMap.put("profile_image","");

        bodyMap.put("status","success");
        bodyMap.put("data",dataMap);
        bodyMap.put("message","Successfully! Record has been fetched.");

        return bodyMap;
    }


}
