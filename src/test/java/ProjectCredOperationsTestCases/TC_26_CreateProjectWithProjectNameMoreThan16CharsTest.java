package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_26_CreateProjectWithProjectNameMoreThan16CharsTest {
	
	@Test
	public void tC_26_CreateProjectWithProjectNameMoreThan16CharsTest() {
		//Create prerequisite
		ProjectPojo jobj=new ProjectPojo("Andrew39", "Alpha12Beta34Gama56", "suspended", 1);
		
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
