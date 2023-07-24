package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_10_CreateProjectWithoutMandatoryFieldTest {
	
	@Test
	public void tC_10_CreateProjectWithoutMandatoryFieldTest() {
		//Create prerequisite
		ProjectPojo jobj=new ProjectPojo("Andrew39", null, "created", 5);
		
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
