package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@Service
public class GetUsersInLondonService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${heroku.api.london.url}")
    String londonUrl;

    public User[] getUsersInLondon() {

        User[] londonUsers = null; //sets an array of users to null initially

        try {
            URI uri; //declare uri for hitting
            uri = new URI(londonUrl); //assign value from application.properties

            HttpHeaders requestHeaders = new HttpHeaders(); //create headers to pass to entity
            requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE); //add header to accept json type
            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); //add header to ensure response is returned as a json array

            HttpEntity<User[]> requestBody = new HttpEntity<User[]>(requestHeaders);
            ResponseEntity<User[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestBody, User[].class);

            londonUsers = responseEntity.getBody();

        } catch (URISyntaxException e) {
            e.getMessage();
        }

        return londonUsers;
    }

}
