package Session3;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

        protected RequestSpecification request;
        private final Gson gson;

        public ApiBase(String baseUrl) {
            RestAssured.baseURI = baseUrl;
            this.gson = new Gson();
            this.request = RestAssured.given()
                    .header("Content-Type", "application/json");
        }

        public Response get(String endpoint) {
            return request.get(endpoint);
        }

        public Response post(String endpoint, Object body) {
            return request.body(gson.toJson(body))
                    .post(endpoint);
        }

        public <T> T deserializeResponse(Response response, Class<T> responseClass) {
            return gson.fromJson(response.asString(), responseClass);
        }

        public String serializeRequestBody(Object body) {
            return gson.toJson(body);
        }
}

