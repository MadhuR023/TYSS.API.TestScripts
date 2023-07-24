package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_05_DeleteProjectTest {
	@Test
	public void tC_05_DeleteProjectTestme() {
		//Create Request and Validate Response
		when()
			.delete("http://rmgtestingserver:8084/projects/TY_PROJ_10494")
		.then()
			.assertThat()
			.statusCode(204)
			.contentType(ContentType.JSON)
			.log()
			.all();
	}
}
