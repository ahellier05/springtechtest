package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class GetUsersInLondonServiceTest {

    @Autowired
    private GetUsersInLondonService getUsersInLondonService;

    @Test
    public void getLondonUsers() {

        User[] londonArray = getUsersInLondonService.getUsersInLondon();

        for(int i = 0; i < londonArray.length; i++) {
            System.out.println("Next User: " + londonArray[i]);
        }

        assertTrue(londonArray.length == 6);
        System.out.println("TEST SUCCESSFUL");
    }
}
