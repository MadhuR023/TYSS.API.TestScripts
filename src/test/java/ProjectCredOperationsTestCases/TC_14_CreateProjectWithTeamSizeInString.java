package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_14_CreateProjectWithTeamSizeInString {
	
	@Test
	public void tC_14_CreateProjectWithTeamSizeInString() {
		//Create prerequisite
		HashMap jobj=new HashMap();
		jobj.put("createdBy", "Andrew");
		jobj.put("projectName", 213);
		jobj.put("status", "on going");
		jobj.put("teamSize", "four");		
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
