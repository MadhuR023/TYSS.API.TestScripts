package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_19_CreateProjectFromExternalJSONFileWithDeletedLine {
	@Test
	public void tC_19_CreateProjectFromExternalJSONFileWithDeletedLine() {
		File jobj=new File("./src/test/resources/TestCase.json");
		
		//Create Request and Validate Response
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://rmgtestingserver:8084/addProject")
		.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log()
			.all();
		
	}
}
