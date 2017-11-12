package edoatley.scenarios;


import com.netflix.ribbon.proxy.annotation.Http;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

import edoatley.ds.HelloWorldApp;
import edoatley.ds.NumberGenerator;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StepDefinitions extends StepDefs {

    @Autowired
    NumberGenerator numberGenerator;

    @Autowired
    TestRestTemplate restTemplate;

    private Map response;

    @Given("^the random number generator is in test mode$")
    public void the_random_number_generator_is_in_test_mode() throws Throwable {
        assertThat(numberGenerator).isInstanceOf(TestNumberGenerator.class);
    }

    @When("^the hello API is called$")
    public void the_hello_API_is_called() throws Throwable {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity request = new HttpEntity(headers);
        restTemplate.getRestTemplate().

        ResponseEntity<Map> responseEntity = restTemplate.exchange("/hello", HttpMethod.GET, request, Map.class, new HashMap<>());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        response = responseEntity.getBody();
    }

    @Then("^the number is (\\d+)$")
    public void the_number_is(int expectedNumber) throws Throwable {
        assertThat(response.get("num")).isEqualTo(Integer.toString(expectedNumber));
    }
}
