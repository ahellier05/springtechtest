package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class GetAllUsersTestServiceTest {

    @Autowired
    private GetAllUsersService getAllUsersService;

    @Test
    public void getAllUsers() {

        User[] userArray = getAllUsersService.returnAllUsers();

        for (int i = 0; i < userArray.length; i++) {
            System.out.println("Next User: " + userArray[i]);
        }

        assertTrue(userArray.length == 1000);
        System.out.println("TEST SUCCESSFUL");

    }

}
