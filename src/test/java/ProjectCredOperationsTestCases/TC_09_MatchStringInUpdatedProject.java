package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_09_MatchStringInUpdatedProject {
	@Test
	public void tC_09_MatchStringInUpdatedProject() {
		
		//Create prerequisite
				ProjectPojo jobj=new ProjectPojo("Andrew39", "Alpha12", "created", 5);
				
				//Create Request and Validate Response
				given()
					.body(jobj)
					.contentType(ContentType.JSON)
				.when()
					.post("http://rmgtestingserver:8084/addProject")
				.then()
					.assertThat()
					.body(Matchers.containsString("Andrew"))
					.statusCode(201)
					.contentType(ContentType.JSON)
					.log()
					.all();
		
	}
}
