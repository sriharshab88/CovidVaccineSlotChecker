package platformLayer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResourceLayer {

    public Response getResponse(String url) {
        RequestSpecification specification = RestAssured.given().request();
        specification.contentType("application/json");
        specification.header("Accept", "application/json");
        specification.header("Accept-Encoding", "gzip,deflate,br");

        return specification.when().get(url);
    }
}
