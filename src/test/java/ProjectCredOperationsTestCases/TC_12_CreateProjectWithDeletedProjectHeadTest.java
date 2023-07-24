package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_12_CreateProjectWithDeletedProjectHeadTest {
	
	@Test
	public void tC_12_CreateProjectWithDeletedProjectHeadTest() {
				//Create prerequisite
				ProjectPojo jobj=new ProjectPojo("Andrew39", "Gama1", "created", 1);
				
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
