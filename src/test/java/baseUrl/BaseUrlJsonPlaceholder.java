package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlaceholder {


    protected RequestSpecification specJsonPlaceholder;


    @Before
    public void setUp(){

        specJsonPlaceholder= new RequestSpecBuilder()
                                .setBaseUri("https://jsonplaceholder.typicode.com")
                                .build();
    }

}
