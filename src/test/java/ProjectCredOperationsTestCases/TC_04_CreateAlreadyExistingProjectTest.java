package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_04_CreateAlreadyExistingProjectTest {
	
	@Test
	public void tC_04_CreateAlreadyExistingProject() {
		//Create prerequisite
				ProjectPojo jobj=new ProjectPojo("Andrew39", "Alpha1", "created", 5);
				
				//Create Request and Validate Response
				given()
					.body(jobj)
					.contentType(ContentType.JSON)
				.when()
					.post("http://rmgtestingserver:8084/addProject")
				.then()
					.assertThat()
					.statusCode(401)
					.contentType(ContentType.JSON)
					.log()
					.all();
	}
}
