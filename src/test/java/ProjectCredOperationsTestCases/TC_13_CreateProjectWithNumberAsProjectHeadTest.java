package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_13_CreateProjectWithNumberAsProjectHeadTest {
	@Test
	public void tC_13_CreateProjectWithNumberAsProjectHeadTest() {
		//Create prerequisite
		HashMap jobj=new HashMap();
		jobj.put("createdBy", "Andrew");
		jobj.put("projectName", 213);
		jobj.put("status", "on going");
		jobj.put("teamSize", 5);

		
		//Create Request and Validate Response
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://rmgtestingserver:8084/addProject")
		.then()
			.assertThat()
			.statusCode(400)
			.contentType(ContentType.JSON)
			.log()
			.all();
	}
}
