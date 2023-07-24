package ProjectCredOperationsTestCases;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class TC_03_GetProjectTest {
		@Test
		public void tC_03_GetProjectTest() {
			
			//Create Request and Validate Response
		when()
			.get("http://rmgtestingserver:8084/projects/TY_PROJ_10494")
		.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log()
			.all();
			
		}
}
