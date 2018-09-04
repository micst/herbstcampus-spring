package com.cc.spring.endpoints;

import com.cc.spring.RestApplication;
import com.cc.spring.domain.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.cc.spring.util.RestUtils.generateSampleProdukt;
import static com.cc.spring.util.RestUtils.generateSampleUser;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

// Ergänzen um Annotationen, die Spring-Support aktivieren und den Context konfigurieren (Achtung: SpringBoot!)
// Zusätzlich benötigen wir einen laufenden Container - Annotation für Integrationstests hinzufügen
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestEndpointsTest {
    
	@Test
	public void testWithSpringRestTemplate() {

	    User user = generateSampleUser();

	    // Given
        given()
            .contentType(ContentType.JSON)
            .body(user)
	    // When
        .when()
            .post("http://localhost:8080/api/produkt.json")
	    // Then
        .then()
            .statusCode(HttpStatus.SC_OK)
            .contentType(ContentType.JSON)
            .assertThat()
                .equals(generateSampleProdukt((user)));

	}

	/*
	@Test
    public void testWithRestAssured() {
		
    }
    */
	
	
	
	

}
