import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTesting1 {
    @Test
    public void get(){
//        given()
//                .header("Content-Type","application/json")
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200)
//                .body("data[0].id",equalTo(7))
//                .body("data.first_name",hasItems("Michael","Lindsay"))
//                .body("data.last_name",hasItems("Fields","Lawson"))
//                .log()
//                .all();
        given()
                .header("Content-Type","application/json")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id",equalTo(7))
                .body("data.first_name",hasItems("Michael","Lindsay"))
                .log().all();


    }
    @Test
    public  void post(){

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","shashi");
        jsonObject.put("age",28);
        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public  void getUser(){
        given()
                .header("Content-Type","application/json")
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id",equalTo(2))
                .body("data.first_name",equalTo("Janet"))
                .log()
                .all();

    }

    @Test
    public  void put(){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("age",28);
        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("age",equalTo(28))
                .log().all();

    }
    @Test
    public void delete(){
        given()
                .when().
                delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }

    @Test
    public void register(){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");
        System.out.println(jsonObject);
        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toJSONString())
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void login(){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("email","eve.holt@reqres.in");
        jsonObject.put("password","cityslicka");
        System.out.println(jsonObject);
        given()
                .header("Content-Type","application/json")
                .body(jsonObject.toJSONString())
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .log().all();

    }


}
