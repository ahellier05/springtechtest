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

        assertTrue(userArray.length == 1000);

    }

}
