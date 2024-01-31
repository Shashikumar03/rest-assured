import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTesting {

    @Test
    public  void  get(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]",equalTo(7))
                .log().all();

    }

    @Test
    public void post(){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","shashi");

        given()
                .body(jsonObject.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201).log().all();

    }
    @Test
    public  void put(){

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","shashi");
        jsonObject.put("age",2);

        given()
                .body(jsonObject.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
    @Test
    public void delete(){
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();
    }
}
