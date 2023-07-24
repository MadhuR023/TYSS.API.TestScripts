package ProjectCredOperationsTestCases;
import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TC_01_CreatePostTest {

	@Test
	public void tC_01_CreatePostTest() {
		
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
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log()
			.all();
	}
}
