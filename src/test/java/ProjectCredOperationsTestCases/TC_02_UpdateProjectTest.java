package ProjectCredOperationsTestCases;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_02_UpdateProjectTest {
	
	@Test
	public void tC_02_UpdateProjectTest() {
		//Create prerequisite
		ProjectPojo jobj=new ProjectPojo("Peterson", "Beta1", "on going", 7);
		
		//Create Request and Validate Response
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://rmgtestingserver:8084/projects/TY_PROJ_10494")
		.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log()
			.all();
	}
}
