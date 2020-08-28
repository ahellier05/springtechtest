package interview.hellier.heroku.SpringREST.Service;
import interview.hellier.heroku.SpringREST.Model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * Service to return an array containing all users
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */
@Service
public class GetAllUsersService {

    private static final Logger LOG = LoggerFactory.getLogger(GetAllUsersService.class);

    @Autowired
    private RestTemplate restTemplate;

    String allUserUri;

    @Autowired
    GetAllUsersService(final RestTemplate restTemplate,
                            @Value("${heroku.api.url}")String allUserUri) {
        this.restTemplate = restTemplate;
        this.allUserUri = allUserUri;
    }

    /**
     * Returns an array containing all users in the database by making a HTTP GET request to
     * https://dwp-techtest.herokuapp.com/users
     *
     * @return User[] array containing all users returned from the API
     * @throws FileNotFoundException, URISyntaxException
     *
     */
    public User[] returnAllUsers() throws FileNotFoundException, URISyntaxException {

        User[] allUsersArray = null; //sets an array of users to null

        try {
            //set value of uri to pass into rest call
            URI uri;
            uri = new URI(allUserUri);

            //Add headers to httpheader instance
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            //create http entity with request headers to pass to response entity
            HttpEntity<User[]> requestBody = new HttpEntity<User[]>(requestHeaders);
            //make HTTP GET request
            ResponseEntity<User[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestBody, User[].class);

            allUsersArray = responseEntity.getBody();

            writeToFile(allUsersArray);

        } catch (URISyntaxException e) {

            new URISyntaxException(allUserUri, "Invalid URI format");
        }

            return allUsersArray;

    }

    /**
     * This is to serialize results of the calling method into a text file using FileOutputStream
     *
     * @param responseArray
     * @throws FileNotFoundException
     */
    public void writeToFile(User[] responseArray) throws FileNotFoundException {

        //try-catch to check if file already exists, if not, the method will create file
        try {
            File responseArrayFile = new File("userarray");
            if (!responseArrayFile.exists()) {
                responseArrayFile.createNewFile();
            } else {
                System.out.println("File exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //try-catch to create output stream to serialize object
        try {
            FileOutputStream fos = new FileOutputStream("userarray");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(responseArray);
            oos.close();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("User array file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
