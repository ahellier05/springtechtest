package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Config.AppConfig;
import interview.hellier.heroku.SpringREST.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * Service to return an array containing all users that are listed as living in London, it goes by
 * city entry
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */
@Service
public class GetUsersInLondonService {

    private static final Logger LOG = LoggerFactory.getLogger(GetUsersInLondonService.class);

    @Autowired
    private RestTemplate restTemplate;

    String londonUrl;

    @Autowired
    GetUsersInLondonService(final RestTemplate restTemplate,
                            @Value("${heroku.api.london.url}")String londonUrl) {
        this.restTemplate = restTemplate;
        this.londonUrl = londonUrl;
    }

    /**
     * Returns an array  of users that have London listed as their city
     *
     * @return User[] londonUsers
     */
    public User[] getUsersInLondon() {

        User[] londonUsers = null;

        /*try-catch statement which builds response entity with request headers and http entity
        * Makes HTTP GET request to url: https://dwp-techtest.herokuapp.com/city/London/users
         */
        try {
            //set value of uri to pass into rest call
            URI uri;
            uri = new URI(londonUrl);

            //Add headers to httpheader instance
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            //create http entity with request headers to pass to response entity
            HttpEntity<User[]> requestBody = new HttpEntity<User[]>(requestHeaders);
            //make HTTP GET request
            ResponseEntity<User[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestBody, User[].class);

            //assign value of response to variable
            londonUsers = responseEntity.getBody();

        } catch (URISyntaxException e) {

            new URISyntaxException(londonUrl, "Invalid URI Syntax");
        }

        return londonUsers;
    }

}
