package platformLayer;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class ResourceLayer {

    public Response getResponse(String url){
        RequestSpecification specification = RestAssured.given().request();
        specification.contentType("application/json");
        specification.header("Accept", "application/json");
        specification.header("Accept-Encoding", "gzip,deflate,br");

        return specification.when().get(url);
    }
}
