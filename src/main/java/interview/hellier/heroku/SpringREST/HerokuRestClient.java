package interview.hellier.heroku.SpringREST;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;

@Component
public class HerokuRestClient {

    @Value("${heroku.api.url}")
    String herokuUrl;

    RestTemplate restTemplate;

    public HerokuRestClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public User getOneUser() {

        User response = null;
        try {
            URI uri;
            uri = new URI(herokuUrl);

           HttpHeaders requestHeaders = new HttpHeaders();
           requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
           requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

           HttpEntity<User> requestBody = new HttpEntity<User>(requestHeaders);
           ResponseEntity<User[]> responseEntity = restTemplate.exchange(uri,HttpMethod.GET, requestBody, User[].class);

           response = responseEntity.getBody()[0];

        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }

        return response;

    }

    public User[] returnAllUsers() {

        User[] response; //sets an array of users to null initially

        try {
            URI uri; //declare uri for hitting
            uri = new URI(herokuUrl); //assign value from application.properties

            HttpHeaders requestHeaders = new HttpHeaders(); //create headers to pass to entity
            requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE); //add header to accept json type
            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); //add header to ensure response is returned as a json array

            HttpEntity<User[]> requestBody = new HttpEntity<User[]>(requestHeaders);
            ResponseEntity<User[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestBody, User[].class);





        } catch (URISyntaxException e) {
            System.out.println("Issue is: " + e.getMessage());
        }

        return null;

    }




}
