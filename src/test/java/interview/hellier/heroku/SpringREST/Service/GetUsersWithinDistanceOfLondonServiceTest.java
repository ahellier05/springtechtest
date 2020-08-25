package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class GetUsersWithinDistanceOfLondonServiceTest {

    @Autowired
    private GetUsersWithinDistanceOfLondonService getUsersWithinDistanceOfLondonService;

    @Test
    public void getUsersWithin50MilesOfLondon() {

        List<User> distanceArray = getUsersWithinDistanceOfLondonService.getUsersWithin50MilesOfLondon(50);

        assertTrue(distanceArray.size() > 0);

    }


}
