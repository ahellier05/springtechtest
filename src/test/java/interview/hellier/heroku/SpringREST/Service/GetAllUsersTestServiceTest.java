package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class GetAllUsersTestServiceTest {

    @Autowired
    private GetAllUsersService getAllUsersService;

    @Test
    public void getAllUsers() {

        try {

            User[] userArray = getAllUsersService.returnAllUsers();

            assertTrue(userArray.length == 1000);

        } catch (FileNotFoundException e) {

            new FileNotFoundException("User Array file not found");

        } catch (URISyntaxException e) {

            new URISyntaxException(getAllUsersService.allUserUri, "Invalid URI format");

        }

    }
}
