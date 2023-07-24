package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_06_GetProjectAlreadyDeleted {
	
	@Test
	public void tC_06_GetProjectAlreadyDeleted() {
		//Create Request and Validate Response
		when()
			.get("http://rmgtestingserver:8084/projects/TY_PROJ_10494")
		.then()
			.assertThat()
			.statusCode(400)
			.contentType(ContentType.JSON)
			.log()
			.all();
	}

}
