import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTesting2 {

    @Test
    public  void get(){
       given()
               .header("Content-Type","application/json")
               .when()
               .get("https://reqres.in/api/users?page=2")
               .then()
               .body("data[0].id",equalTo(7))
               .body("data.email",hasItems("lindsay.ferguson@reqres.in","tobias.funke@reqres.in"))
               .body("data.id",hasItems(7,8,9))
               .body("page",equalTo(2))
               .statusCode(200)
               .log()
               .ifStatusCodeIsEqualTo(200);
    }
    @Test
    public void post(){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","shashi");
        jsonObject.put("age",25);

        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log()
              ;
    }

}
