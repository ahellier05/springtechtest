package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

@Service
public class GetOneUserService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${heroku.api.url}")
    String oneUserEndpoint;

    public User getOneSpecifiedUser() {

        User response = null;

        try {
            URI uri;
            uri = new URI(oneUserEndpoint);

            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<User> requestBody = new HttpEntity<User>(requestHeaders);
            ResponseEntity<User[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestBody, User[].class);

            response = responseEntity.getBody()[0];

        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }

        return response;

    }
}
