package Tests;

import org.junit.Test;

public class C29_Get_DeSerialization {
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

    @Test
    public void test01(){
        // 1- endpoint ve request body olustur

        // 2- Soruda varsa expected data olustur

        // 3- Request gonder donen response'i kaydet

        // 4- Assertion
    }
}
