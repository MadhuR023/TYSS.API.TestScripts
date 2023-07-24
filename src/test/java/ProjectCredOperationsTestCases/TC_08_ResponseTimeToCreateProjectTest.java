package ProjectCredOperationsTestCases;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClasses.ProjectPojo;
import io.restassured.http.ContentType;

public class TC_08_ResponseTimeToCreateProjectTest {
	
	@Test
	public void tC_08_ResponseTimeToCreateProjectTest() {
		
		//Create prerequisite
		ProjectPojo jobj=new ProjectPojo("Andrew39", "Alpha12", "created", 5);
		
		//Create Request and Validate Response
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://rmgtestingserver:8084/addProject")
		.then()
			.assertThat()
			.time(Matchers.lessThan(400L))
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log()
			.all();
		
		
	}

}
